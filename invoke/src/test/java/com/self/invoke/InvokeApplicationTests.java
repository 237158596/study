package com.self.invoke;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class InvokeApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        BizService bizService = context.getBean(BizService.class);

        System.out.println(bizService==bizService.self);
    }

}
