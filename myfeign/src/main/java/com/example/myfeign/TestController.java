package com.example.myfeign;


import com.example.myfeign.client.BaiduClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private BaiduClient baiduClient;

    @RequestMapping("/test")
    public Object getHello() {
        Object calculateResult = baiduClient.query("热点新闻");
        return calculateResult;
    }
}
