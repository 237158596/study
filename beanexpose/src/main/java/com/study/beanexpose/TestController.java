package com.study.beanexpose;


import com.study.beanexpose.se.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CalculateService calculateService;

    @RequestMapping("/test")
    public String getHello() {
        String calculateResult = calculateService.getResult("测试");
        return (calculateResult);
    }
}
