package com.example.mqttdemo;

/**
 * Description: 订阅处理器
 *
 * @author linli
 * @since 2021/1/25 14:49
 */
public interface SubcribeProcessor {



    /**
     * 处理消息
     * @param payload
     */
    void process(String payload);

}
