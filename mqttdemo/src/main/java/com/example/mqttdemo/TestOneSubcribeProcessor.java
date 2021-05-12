package com.example.mqttdemo;

import org.springframework.stereotype.Service;

/**
 * Description: 主题处理器1
 *
 * @author linli
 * @since 2021/1/25 14:54
 */
@Service
public class TestOneSubcribeProcessor implements SubcribeProcessor{


    @Override
    public void process(String payload) {
        System.out.println("process $queue/dd22-soulmate/public/CMD,receive payload content:" + payload);
    }
}
