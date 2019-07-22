package com.itleadpro.blockchain.util;

import com.itleadpro.blockchain.service.DataBlockchainService;
import com.itleadpro.blockchain.service.impl.DataBlockchainServiceImpl;
import com.itleadpro.blockchain.smartcontract.ActionService;
import com.itleadpro.blockchain.smartcontract.TokenSale;
import com.itleadpro.blockchain.smartcontract.ITLeadProToken;
import com.itleadpro.blockchain.model.DataBlockchain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.IOException;

/**
 * Created by vanluong on 16/12/2017.
 */
public class SmartContractUtil {
    private static final Logger log = LoggerFactory.getLogger(SmartContractUtil.class);

    public static Web3j web3j;
    public static Credentials credentials;
    public static TokenSale tokenSale;
    public static ITLeadProToken itLeadProToken;
    public static ActionService actionService;
    /**
     * connect ethereum network and load wallet ethereum
     */
    public static void loadWeb3j() throws IOException {
        DataBlockchainService dataBlockchainService = BeanUtil.getBean(DataBlockchainServiceImpl.class);
        DataBlockchain dataBlockchainUrl = dataBlockchainService.findByCode("url_blockchain");

        web3j = Web3j.build(new HttpService(dataBlockchainUrl.getData()));
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        DataBlockchain dataBlockchain = dataBlockchainService.findByCode("privateKey");
        if (dataBlockchain != null && dataBlockchain.getData() != null)
            credentials = Credentials.create(dataBlockchain.getData());
    }

    /**
     * load smartcontract token use address
     */
    public static void loadITLeadProToken() {
        DataBlockchainService dataBlockchainService = BeanUtil.getBean(DataBlockchainServiceImpl.class);
        DataBlockchain dataBlockchain = dataBlockchainService.findByCode("ITLeadProTokenAddress");
        if (dataBlockchain != null)
            itLeadProToken = itLeadProToken.load(dataBlockchain.getData(), web3j, credentials,
                    Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }
    /**
     * load smartcontract token sale use address
     */
    public static void loadTokenSale() {
        DataBlockchainService dataBlockchainService = BeanUtil.getBean(DataBlockchainServiceImpl.class);
        DataBlockchain dataBlockchain = dataBlockchainService.findByCode("tokenSaleAddress");
        if (dataBlockchain != null)
            tokenSale = tokenSale.load(dataBlockchain.getData(), web3j, credentials,
                    Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }
    /**
     * load smartcontract actionService use address
     */
    public static void loadActionService() {
        DataBlockchainService dataBlockchainService = BeanUtil.getBean(DataBlockchainServiceImpl.class);
        DataBlockchain dataBlockchain = dataBlockchainService.findByCode("actionServiceAddress");
        if (dataBlockchain != null)
            actionService = actionService.load(dataBlockchain.getData(), web3j, credentials,
                    Contract.GAS_PRICE, Contract.GAS_LIMIT);
    }


}
