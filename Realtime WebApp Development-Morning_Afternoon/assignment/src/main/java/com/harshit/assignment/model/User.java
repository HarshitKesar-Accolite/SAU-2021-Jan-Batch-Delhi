package com.harshit.assignment.model;

public class User {
    String userName;
    int accountNo;

    public User(String userName, int accountNo) {
        this.userName = userName;
        this.accountNo = accountNo;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}
