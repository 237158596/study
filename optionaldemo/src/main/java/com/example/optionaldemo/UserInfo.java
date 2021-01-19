package com.example.optionaldemo;


public class UserInfo {
    private String name;
    private String id;
    private Integer age;

    public UserInfo(){

    }

    public UserInfo(String name, String id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
