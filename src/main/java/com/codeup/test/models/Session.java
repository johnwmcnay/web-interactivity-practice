package com.codeup.test.models;

public class Session {
    private long id;
    private long userOneID;
    private long userTwoID;

    public Session() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserOneID() {
        return userOneID;
    }

    public void setUserOneID(long userOneID) {
        this.userOneID = userOneID;
    }

    public long getUserTwoID() {
        return userTwoID;
    }

    public void setUserTwoID(long userTwoID) {
        this.userTwoID = userTwoID;
    }
}
