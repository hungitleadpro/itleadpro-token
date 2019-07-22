package com.itleadpro.blockchain.controller;

import com.google.gson.Gson;
import com.itleadpro.blockchain.dto.Address;
import com.itleadpro.blockchain.dto.InformationToken;
import com.itleadpro.blockchain.dto.Response;
import com.itleadpro.blockchain.dto.Transfer;
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
@RequestMapping(value = "/token")
public class TokenController {
    private static Logger logger = Logger.getLogger(TokenController.class);
    @Autowired
    private RequestLogService requestLogService;

    /**
     * funtion transfer token from address _tokenDepositAddress
     */
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<?> transfer(
            @RequestBody Transfer transfer
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(transfer), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);

        TransactionReceipt transactionReceipt = null;
        try {
            logger.info(transfer);

            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadITLeadProToken();
            transactionReceipt = SmartContractUtil.itLeadProToken.transfer(transfer.getAddress(), transfer.getValue()).send();

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
     * get token
     */
    @RequestMapping(value = "/getITLeadProCoin", method = RequestMethod.POST)
    public ResponseEntity<?> getITLeadProCoin(
            @RequestBody Address address
    ) {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(gson.toJson(address), new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);
        BigInteger coin = null;

        try {
            logger.info(coin);

            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadITLeadProToken();
            RemoteCall<BigInteger> remoteCall = SmartContractUtil.itLeadProToken.balanceOf(address.getAddress());

            coin = remoteCall.send();

            logger.info(remoteCall);
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }

        requestLogUpdate.setResponse(gson.toJson(coin));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);

        return ResponseEntity.ok(new Response(200, "Successful", coin));
    }
    /**
     * get information token
     */
    @RequestMapping(value = "/getInformationToken", method = RequestMethod.GET)
    public ResponseEntity<?> getInformationToken() {
        Gson gson = new Gson();

        RequestLog requestLog = new RequestLog(null, new Date());
        RequestLog requestLogUpdate = requestLogService.insertOrUpdate(requestLog);

        InformationToken informationToken = new InformationToken();

        try {
            SmartContractUtil.loadWeb3j();
            SmartContractUtil.loadITLeadProToken();
            informationToken.setDecimals(SmartContractUtil.itLeadProToken.decimals().send());
            informationToken.setName(SmartContractUtil.itLeadProToken.name().send());
            informationToken.setOwner(SmartContractUtil.itLeadProToken.owner().send());
            informationToken.setSymbol(SmartContractUtil.itLeadProToken.symbol().send());
            informationToken.setTotalSupply(SmartContractUtil.itLeadProToken.totalSupply().send());
        } catch (IOException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
        requestLogUpdate.setResponse(gson.toJson(informationToken));
        requestLogUpdate.setUpdatedTime(new Date());
        requestLogService.insertOrUpdate(requestLogUpdate);
        return ResponseEntity.ok(new Response(200, "Successful", informationToken));
    }

}
