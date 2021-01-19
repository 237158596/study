package com.example.optionaldemo;


import org.springframework.stereotype.Component;

@Component
public class DBService {

    public UserInfo getUserInfo(){
        return new UserInfo("wang","id1",15);
    }


    public UserInfo getUserInfoNull(){
        return null;
    }

}
