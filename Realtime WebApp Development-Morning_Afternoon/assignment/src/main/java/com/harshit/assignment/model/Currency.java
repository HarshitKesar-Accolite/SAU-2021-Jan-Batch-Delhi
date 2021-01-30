package com.harshit.assignment.model;

public class Currency {
    int amt;
    int serialKey;

    public Currency(int amt, int serialKey) {
        this.amt = amt;
        this.serialKey = serialKey;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public int getSerialKey() {
        return serialKey;
    }

    public void setSerialKey(int serialKey) {
        this.serialKey = serialKey;
    }
}
