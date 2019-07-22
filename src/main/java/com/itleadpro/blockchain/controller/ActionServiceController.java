package com.itleadpro.blockchain.controller;

import com.google.gson.Gson;
import com.itleadpro.blockchain.dto.Action;
import com.itleadpro.blockchain.dto.ActionUserRequest;
import com.itleadpro.blockchain.dto.Response;
import com.itleadpro.blockchain.dto.TokenActionRequest;
import com.itleadpro.blockchain.model.RequestLog;
import com.itleadpro.blockchain.service.RequestLogService;
import com.itleadpro.blockchain.util.SmartContractUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

@RestController
@RequestMapping(value = "/actionService")
public class ActionServiceController {
    private static Logger logger = Logger.getLogger(ActionServiceController.class);
    @Autowired
    private RequestLogService requestLogService;

    /**
     * api add object(token, action) to blockchain
     */
    @RequestMapping(value = "/addTokenAction", method = RequestMethod.POST)
    public ResponseEntity<?> addTokenAction(
            @RequestBody TokenActionRequest tokenActionRequest
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(tokenActionRequest), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);


        Thread thread = new Thread() {
            public void run() {
                try {
                    logger.info(tokenActionRequest);
                    SmartContractUtil.loadWeb3j();
                    SmartContractUtil.loadActionService();
                    TransactionReceipt  transactionReceipt = SmartContractUtil.actionService.addActionToken(tokenActionRequest.getAction(), tokenActionRequest.getValue()).send();

                    System.out.println("xong cmnr");
                } catch (IOException e) {
                    logger.error(e);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        };
        thread.start();

//        logger.info(transactionReceipt);


//        requestLogUpdate.setResponse(gson.toJson(transactionReceipt));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);

        return ResponseEntity.ok(new Response(200, "Successful", "done"));
    }

    /**
     * api change value token
     */
    @RequestMapping(value = "/changeTokenAction", method = RequestMethod.POST)
    public ResponseEntity<?> changeTokenAction(
            @RequestBody TokenActionRequest tokenActionRequest
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(tokenActionRequest), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);

        TransactionReceipt transactionReceipt = null;

        try {
            logger.info(tokenActionRequest);

            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadActionService();
            transactionReceipt = SmartContractUtil.actionService.changeTokenAction(tokenActionRequest.getAction(), tokenActionRequest.getValue()).send();

            logger.info(transactionReceipt);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }

        requestLogUpdate.setResponse(gson.toJson(transactionReceipt));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);

        return ResponseEntity.ok(new Response(200, "Successful", transactionReceipt));
    }

    /**
     * when user take action, api send token user
     */
    @RequestMapping(value = "/sendTokenUser", method = RequestMethod.POST)
    public ResponseEntity<?> sendTokenUser(
            @RequestBody ActionUserRequest request
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(request), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);

        TransactionReceipt transactionReceipt = null;

        try {
            logger.info(request);

            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadActionService();
            transactionReceipt = SmartContractUtil.actionService.sendTokenUser(request.getAction(), request.getAddressUser()).send();

            logger.info(transactionReceipt);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }

        requestLogUpdate.setResponse(gson.toJson(transactionReceipt));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);

        return ResponseEntity.ok(new Response(200, "Successful", transactionReceipt));
    }

    /**
     * get token from action on blockchain
     */
    @RequestMapping(value = "/getTokenFromAction", method = RequestMethod.POST)
    public ResponseEntity<?> getTokenFromAction(
            @RequestBody Action action
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(action), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);

        BigInteger value = null;
        try {
            logger.info(action);

            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadActionService();
            RemoteCall<BigInteger> remoteCall = SmartContractUtil.actionService.getTokenFromAction(action.getAction());
            value = remoteCall.send();

            logger.info(remoteCall);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }

        requestLogUpdate.setResponse(gson.toJson(value));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);
        return ResponseEntity.ok(new Response(200, "Successful", value));
    }
}
