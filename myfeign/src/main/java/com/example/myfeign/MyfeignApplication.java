package com.example.myfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class MyfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfeignApplication.class, args);
    }

}
