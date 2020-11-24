package com.self.invoke;


import org.springframework.stereotype.Component;

@Component
public class BizService implements BeanSelfAware  {

    public BizService self;
    @Override
    public void setSelf(Object proxyBean) {
        this.self = (BizService)proxyBean;
    }




}
