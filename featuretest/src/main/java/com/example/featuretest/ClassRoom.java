package com.example.featuretest;

import java.util.List;

public class ClassRoom {


    private String className;
    private List<User> userList;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
