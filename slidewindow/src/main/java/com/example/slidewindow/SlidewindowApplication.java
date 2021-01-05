package com.example.slidewindow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SlidewindowApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SlidewindowApplication.class, args);
        new WindowLimiter().slideWindow();
    }

}
