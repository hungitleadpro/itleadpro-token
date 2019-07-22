package com.itleadpro.blockchain.dto;


public class ActionUserRequest {
    private String action;
    private String addressUser;
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }
}
