pragma solidity ^0.4.15;
import  "./Token.sol";

contract ActionService  {

    struct ActionToken{
        string idAction;
        uint256 valueToken;
    }

    function equal(string _a, string _b) returns (bool) {
        return keccak256(_a) == keccak256(_b);
    }

    ITLeadProToken token;
    address public tokenDepositAddress;
    ActionToken[] private actionTokenList;

    function ActionService(ITLeadProToken _tokenTokenAddress,  address _tokenDepositAddress) public {
        token = ITLeadProToken(_tokenTokenAddress);
        tokenDepositAddress = _tokenDepositAddress;
    }

    function addActionToken(string _idAction, uint256 _value) public returns (bool) {
        actionTokenList.push(ActionToken({
            idAction :_idAction,
            valueToken: _value

            }));
        return true;
    }

    function getTokenFromAction(string _idAction) public view returns (uint256 value) {
        for (uint i = 0; i < actionTokenList.length; i++) {
            if(equal(actionTokenList[i].idAction, _idAction)){
                return actionTokenList[i].valueToken;
            }
        }
        return 0;

    }
    function changeTokenAction(string _idAction, uint256 _newValue) public returns (bool) {
        for (uint i = 0; i < actionTokenList.length; i++) {
            if(equal(actionTokenList[i].idAction, _idAction)){
                actionTokenList[i].valueToken=_newValue;
                return true;
            }
        }

        return false;
    }

    function sendTokenUser(string _idAction, address _user) public returns (bool) {
        for (uint i = 0; i < actionTokenList.length; i++) {
            if(equal(actionTokenList[i].idAction, _idAction)){
                token.mint(_user, actionTokenList[i].valueToken);

            }
        }
        return true;
    }

}
