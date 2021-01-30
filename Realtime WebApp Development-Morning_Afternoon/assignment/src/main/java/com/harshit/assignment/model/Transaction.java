package com.harshit.assignment.model;

public class Transaction {
    int tId;
    int accountNo;
    int currencySerialKey;
    boolean legal;

    public Transaction(int tId, int accountNo, int currencySerialKey) {
        this.tId = tId;
        this.accountNo = accountNo;
        this.currencySerialKey = currencySerialKey;
    }

    public Transaction() {

    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getCurrencySerialKey() {
        return currencySerialKey;
    }

    public void setCurrencySerialKey(int currencySerialKey) {
        this.currencySerialKey = currencySerialKey;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }
}
