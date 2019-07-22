package com.itleadpro.blockchain.dto;

import java.math.BigInteger;

public class InformationToken {
    private BigInteger decimals;
    private String name;
    private String symbol;
    private BigInteger totalSupply;
    private String owner;

    public BigInteger getDecimals() {
        return decimals;
    }

    public void setDecimals(BigInteger decimals) {
        this.decimals = decimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigInteger getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(BigInteger totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
