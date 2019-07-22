package com.itleadpro.blockchain.dto;

import java.math.BigInteger;

public class Transfer {
    private String address;
    private BigInteger value;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
}
