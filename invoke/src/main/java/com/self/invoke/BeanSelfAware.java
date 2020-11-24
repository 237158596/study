package com.self.invoke;

public interface BeanSelfAware {

    /**
     * 注入自身
     * @param proxyBean
     */
    void setSelf(Object proxyBean);

}
