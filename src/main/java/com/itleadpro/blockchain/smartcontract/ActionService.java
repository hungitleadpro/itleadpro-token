package com.itleadpro.blockchain.smartcontract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class ActionService extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160408061090c833981016040528080519190602001805160008054600160a060020a03958616600160a060020a031991821617909155600180549590921694169390931790925550506108a28061006a6000396000f3006060604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631c490e2e811461007c5780632b784e32146100e357806346bdca9a1461014c5780634b7c207b146101df5780636115da6814610232578063fc558a7114610295575b600080fd5b341561008757600080fd5b6100cf60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050933593506102d192505050565b604051901515815260200160405180910390f35b34156100ee57600080fd5b6100cf60046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496505050923573ffffffffffffffffffffffffffffffffffffffff169250610337915050565b341561015757600080fd5b6100cf60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506104e595505050505050565b34156101ea57600080fd5b6100cf60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050933593506105a992505050565b341561023d57600080fd5b61028360046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061060e95505050505050565b60405190815260200160405180910390f35b34156102a057600080fd5b6102a861071d565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200160405180910390f35b6000600280548060010182816102e79190610739565b91600052602060002090600202016000604080519081016040528681526020810186905291905081518190805161032292916020019061076a565b50602082015160019182015595945050505050565b6000805b6002548110156104d95761040760028281548110151561035757fe5b90600052602060002090600202016000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103fc5780601f106103d1576101008083540402835291602001916103fc565b820191906000526020600020905b8154815290600101906020018083116103df57829003601f168201915b5050505050856104e5565b156104d1576000546002805473ffffffffffffffffffffffffffffffffffffffff909216916340c10f199186918590811061043e57fe5b9060005260206000209060020201600101546040517c010000000000000000000000000000000000000000000000000000000063ffffffff851602815273ffffffffffffffffffffffffffffffffffffffff90921660048301526024820152604401602060405180830381600087803b15156104b957600080fd5b5af115156104c657600080fd5b505050604051805150505b60010161033b565b600191505b5092915050565b6000816040518082805190602001908083835b602083106105175780518252601f1990920191602091820191016104f8565b6001836020036101000a0380198251168184511617909252505050919091019250604091505051908190039020836040518082805190602001908083835b602083106105745780518252601f199092019160209182019101610555565b6001836020036101000a0380198251168184511617909252505050919091019250604091505051908190039020149392505050565b6000805b600254811015610604576105c960028281548110151561035757fe5b156105fc57826002828154811015156105de57fe5b906000526020600020906002020160010181905550600191506104de565b6001016105ad565b5060009392505050565b6000805b600254811015610712576106de60028281548110151561062e57fe5b90600052602060002090600202016000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106d35780601f106106a8576101008083540402835291602001916106d3565b820191906000526020600020905b8154815290600101906020018083116106b657829003601f168201915b5050505050846104e5565b1561070a5760028054829081106106f157fe5b9060005260206000209060020201600101549150610717565b600101610612565b600091505b50919050565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b8154818355818115116107655760020281600202836000526020600020918201910161076591906107e8565b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106107ab57805160ff19168380011785556107d8565b828001600101855582156107d8579182015b828111156107d85782518255916020019190600101906107bd565b506107e4929150610815565b5090565b61081291905b808211156107e4576000610802828261082f565b50600060018201556002016107ee565b90565b61081291905b808211156107e4576000815560010161081b565b50805460018160011615610100020316600290046000825580601f106108555750610873565b601f0160209004906000526020600020908101906108739190610815565b505600a165627a7a72305820652474f7e3b745c18638ceb317720a6969ae1e9f44ca9086501f8e4c1dcfaef50029";

    protected ActionService(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ActionService(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addActionToken(String _idAction, BigInteger _value) {
        final Function function = new Function(
                "addActionToken", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_idAction), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> sendTokenUser(String _idAction, String _user) {
        final Function function = new Function(
                "sendTokenUser", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_idAction), 
                new org.web3j.abi.datatypes.Address(_user)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> equal(String _a, String _b) {
        final Function function = new Function(
                "equal", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_a), 
                new org.web3j.abi.datatypes.Utf8String(_b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeTokenAction(String _idAction, BigInteger _newValue) {
        final Function function = new Function(
                "changeTokenAction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_idAction), 
                new org.web3j.abi.datatypes.generated.Uint256(_newValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getTokenFromAction(String _idAction) {
        final Function function = new Function("getTokenFromAction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_idAction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> tokenDepositAddress() {
        final Function function = new Function("tokenDepositAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<ActionService> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenTokenAddress, String _tokenDepositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenTokenAddress), 
                new org.web3j.abi.datatypes.Address(_tokenDepositAddress)));
        return deployRemoteCall(ActionService.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<ActionService> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenTokenAddress, String _tokenDepositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenTokenAddress), 
                new org.web3j.abi.datatypes.Address(_tokenDepositAddress)));
        return deployRemoteCall(ActionService.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static ActionService load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ActionService(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static ActionService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ActionService(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
