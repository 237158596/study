package com.example.mqttdemo;

import lombok.Data;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@ConfigurationProperties(prefix = "mqtt")
@Data
@Configuration
public class SpringMqttConfig {

    private String broker;
    private String userName;
    private String passWord;
    private List<String> subTopic;
    private Integer connectionTimeout;
    private Integer keepAliveInterval;

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] {broker});
        options.setCleanSession(false);
        options.setAutomaticReconnect(true);
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    public MessageChannel dataOutputChannel() {
        return new DirectChannel();
    }



    @Bean
    public MessageChannel dataInputChannel() {
        return new DirectChannel();
    }

    /**
     * 接收通道
     * @return
     */
    @Bean
    public MqttPahoMessageDrivenChannelAdapter inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(UUID.randomUUID().toString(),
                mqttClientFactory());
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
//        converter.setPayloadAsBytes(true);
//        adapter.setConverter(converter);
        adapter.setQos(1);
        adapter.setOutputChannel(dataInputChannel());
        return adapter;
    }


    private static int[] qos = {2, 2, 2};

    @Bean
    public  MqttPahoMessageDrivenChannelAdapter   messageDrivenChannelAdapter(MqttPahoMessageDrivenChannelAdapter adapter){
        adapter.addTopics(subTopic.toArray(new String[subTopic.size()]),qos);
        return adapter;

    }
}
