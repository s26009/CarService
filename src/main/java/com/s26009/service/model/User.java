package com.s26009.service.model;

public class User {
    private String accId;

    public User(String accId) {
        this.accId = accId;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    @Override
    public String toString() {
        return "User{" +
                "accId='" + accId + '\'' +
                '}';
    }
}
