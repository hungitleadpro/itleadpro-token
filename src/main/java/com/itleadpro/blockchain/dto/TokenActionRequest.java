package com.itleadpro.blockchain.dto;

import java.math.BigInteger;

public class TokenActionRequest {
    private String action;
    private BigInteger value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}
