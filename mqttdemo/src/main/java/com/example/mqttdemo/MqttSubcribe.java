package com.example.mqttdemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: 订阅mqtt主题
 *
 * @author linli
 * @since 2021/1/25 14:56
 */
@Slf4j
@Service
public class MqttSubcribe {

    AtomicInteger count = new AtomicInteger();

    @Bean
    @ServiceActivator(inputChannel = "dataInputChannel")
    public MessageHandler handler() {
        return message -> {
            String payload = (String) message.getPayload();
            String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            log.info("receive topic : " + topic);
            log.info("receive message : " + payload);
            System.out.println("总共" + count.incrementAndGet());

//            SubcribeProcessor subcribeProcessor = subcribeProcessorMap.get(topic);
//            if (subcribeProcessor == null) {
//                log.warn("no processor can process this topic");
//            }
//            subcribeProcessor.process(payload);
        };
    }

}
