package com.study.beanexpose;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {

    public Foo(){
        System.out.println("bean的创建");
    }


    @PostConstruct
    public void init(){
        System.out.println("bean的初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("bean的销毁");
    }
}