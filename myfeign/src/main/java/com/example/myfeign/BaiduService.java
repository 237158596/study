package com.example.myfeign;


import com.example.myfeign.client.BaiduClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class BaiduService {

    @Autowired
    private BaiduClient baiduClient;

    ExecutorService pool = Executors.newFixedThreadPool(3);


    @Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 1000L, multiplier = 1))
    public Object query(String text) {
        System.out.println("调用开始....");
        Future<Object> objectFuture = pool.submit(() -> baiduClient.query(text));
        Object result;
        try {
            result = objectFuture.get(10, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            throw new RuntimeException("百度cp异常");
        }
        System.out.println("调用结束....");
        return result;
    }
}
