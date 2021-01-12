package com.example.myfeign.client;


import com.example.myfeign.Myfeign;
import org.springframework.web.bind.annotation.GetMapping;

@Myfeign(url = "http://www.baidu.com")
public interface BaiduClient {


    @GetMapping("/s/s?wd=")
    Object query(String text);
}
