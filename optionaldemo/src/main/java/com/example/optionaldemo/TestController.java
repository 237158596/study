package com.example.optionaldemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private DBService dbService;

    @RequestMapping("/getUserInfo")
    public void getUserInfo() {
        Optional<UserInfo> userInfo = Optional.ofNullable(dbService.getUserInfo());
        System.out.println(userInfo.map(user -> user.getName().toLowerCase())
                .orElse("空")
        );
    }


    @RequestMapping("/getUserInfoNull")
    public void getUserInfoNull() {
        Optional<UserInfo> userInfo = Optional.ofNullable(dbService.getUserInfoNull());
        System.out.println(userInfo.map(user -> user.getName().toLowerCase())
                .orElse("空")
        );
    }
}
