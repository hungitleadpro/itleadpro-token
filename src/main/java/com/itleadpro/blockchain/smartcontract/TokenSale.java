package com.itleadpro.blockchain.smartcontract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class TokenSale extends Contract {
    private static final String BINARY = "60606040526000805460a060020a60ff0219168155600255341561002257600080fd5b604051604080610701833981016040528080519190602001805160008054600160a060020a03338116600160a060020a0319928316179092556003805496831696821696909617909555600180549190921694169390931790925550506106738061008e6000396000f3006060604052600436106100a35763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166324645c5a81146100af5780633f4ba83a146100d45780634172d080146100fb5780634bb278f31461010e5780635c975abb146101215780638456cb59146101345780638da5cb5b14610147578063b5f7f63614610176578063f2fde38b14610189578063fc558a71146101a8575b6100ad33346101bb565b005b34156100ba57600080fd5b6100c261030d565b60405190815260200160405180910390f35b34156100df57600080fd5b6100e761031c565b604051901515815260200160405180910390f35b341561010657600080fd5b6100c26103a0565b341561011957600080fd5b6100ad6103a6565b341561012c57600080fd5b6100e76103fc565b341561013f57600080fd5b6100e761040c565b341561015257600080fd5b61015a610495565b604051600160a060020a03909116815260200160405180910390f35b341561018157600080fd5b6100c26104a4565b341561019457600080fd5b6100ad600160a060020a03600435166104aa565b34156101b357600080fd5b61015a610500565b6000805481908190819060a060020a900460ff16156101d957600080fd5b6101eb856103e863ffffffff61050f16565b6002549094506a295be96e640669720000000392506000915081905080831161021357600080fd5b828411156102385750816102318185036103e863ffffffff61054516565b915061023b565b50825b610245868261055c565b50600280548201905560008211156102cc577f4cb6590c1ffd2e57414843853ce8a5cb27f8c86cd527d9a5c7058b3e0e96aebc3383604051600160a060020a03909216825260208201526040908101905180910390a1600160a060020a03331682156108fc0283604051600060405180830381858888f1935050505015156102cc57600080fd5b600154600160a060020a039081169030163180156108fc0290604051600060405180830381858888f19350505050151561030557600080fd5b505050505050565b6a295be96e6406697200000081565b6000805433600160a060020a0390811691161461033857600080fd5b60005460a060020a900460ff16151561035057600080fd5b6000805474ff0000000000000000000000000000000000000000191690557f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a150600190565b6103e881565b60005433600160a060020a039081169116146103c157600080fd5b600154600160a060020a039081169030163180156108fc0290604051600060405180830381858888f1935050505015156103fa57600080fd5b565b60005460a060020a900460ff1681565b6000805433600160a060020a0390811691161461042857600080fd5b60005460a060020a900460ff161561043f57600080fd5b6000805474ff0000000000000000000000000000000000000000191660a060020a1790557f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a150600190565b600054600160a060020a031681565b60025481565b60005433600160a060020a039081169116146104c557600080fd5b600160a060020a038116156104fd576000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383161790555b50565b600154600160a060020a031681565b600080831515610522576000915061053e565b5082820282848281151561053257fe5b041461053a57fe5b8091505b5092915050565b600080828481151561055357fe5b04949350505050565b6001546000907fb2c0ac17769dc4009cb3bb7bc94bf96c53610105f662c66592910dd10319dcf890600160a060020a03168484604051600160a060020a039384168152919092166020820152604080820192909252606001905180910390a1600354600160a060020a03166340c10f1984846040517c010000000000000000000000000000000000000000000000000000000063ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b151561062a57600080fd5b5af1151561063757600080fd5b50505060405180519493505050505600a165627a7a72305820d6c02ad36676b16481393d00525e3d6fa3d0ed62ebdf9a051269b89c0e3bd57a0029";

    protected TokenSale(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TokenSale(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<MintTokenEventResponse> getMintTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MintToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MintTokenEventResponse> responses = new ArrayList<MintTokenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintTokenEventResponse typedResponse = new MintTokenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintTokenEventResponse> mintTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MintToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintTokenEventResponse>() {
            @Override
            public MintTokenEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MintTokenEventResponse typedResponse = new MintTokenEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<RefundTokenEventResponse> getRefundTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("RefundToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<RefundTokenEventResponse> responses = new ArrayList<RefundTokenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RefundTokenEventResponse typedResponse = new RefundTokenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RefundTokenEventResponse> refundTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("RefundToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, RefundTokenEventResponse>() {
            @Override
            public RefundTokenEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                RefundTokenEventResponse typedResponse = new RefundTokenEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<LogTokenEventResponse> getLogTokenEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<LogTokenEventResponse> responses = new ArrayList<LogTokenEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogTokenEventResponse typedResponse = new LogTokenEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.add = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogTokenEventResponse> logTokenEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogToken", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogTokenEventResponse>() {
            @Override
            public LogTokenEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                LogTokenEventResponse typedResponse = new LogTokenEventResponse();
                typedResponse.log = log;
                typedResponse.add = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.val = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> totalTokenSale() {
        final Function function = new Function("totalTokenSale", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                "unpause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> tokenExchangeRate() {
        final Function function = new Function("tokenExchangeRate", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

//    public RemoteCall<TransactionReceipt> finalize() {
//        final Function function = new Function(
//                "finalize",
//                Arrays.<Type>asList(),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function("paused", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                "pause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalTokenSold() {
        final Function function = new Function("totalTokenSold", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> tokenDepositAddress() {
        final Function function = new Function("tokenDepositAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<TokenSale> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenTokenAddress, String _tokenDepositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenTokenAddress), 
                new org.web3j.abi.datatypes.Address(_tokenDepositAddress)));
        return deployRemoteCall(TokenSale.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<TokenSale> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenTokenAddress, String _tokenDepositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenTokenAddress), 
                new org.web3j.abi.datatypes.Address(_tokenDepositAddress)));
        return deployRemoteCall(TokenSale.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static TokenSale load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenSale(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TokenSale load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TokenSale(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MintTokenEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger val;
    }

    public static class RefundTokenEventResponse {
        public Log log;

        public String to;

        public BigInteger val;
    }

    public static class LogTokenEventResponse {
        public Log log;

        public String add;

        public BigInteger val;
    }

    public static class PauseEventResponse {
        public Log log;
    }

    public static class UnpauseEventResponse {
        public Log log;
    }
}
