package com.self.invoke;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InjectBeanSelfProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BeanSelfAware) {//如果Bean实现了BeanSelfAware标识接口，就将代理对象注入
            ((BeanSelfAware) bean).setSelf(bean); //即使是prototype Bean也可以使用此种方式
        }
        return bean;
    }
}
