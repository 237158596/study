package com.example.completableFuture;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureAnyOfTest2 {

    @SneakyThrows
    public static void main(String[] args) {

        String input = "需要翻译的内容1";
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                return new MycallableA(input).call();
            }
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @SneakyThrows
            @Override
            public String get() {
                return new MycallableB(input).call();
            }
        });
        CompletableFuture f = CompletableFuture.anyOf(f1, f2);

        System.out.println("主线程结束..." + f.get());
    }

    @lombok.SneakyThrows
    static String doAction(int d) {
        Random random = new Random(System.currentTimeMillis());
        int t = d + ThreadLocalRandom.current().nextInt(50 + d);
        Thread.sleep(t);
        System.out.println("正在get 数据..." + d);
        return "正在get 数据..." + d;
    }


    static class MycallableA implements Callable<String> {
        private String input;

        public MycallableA(String input) {
            this.input = input;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50));
            return input + "from A";
        }
    }

    static class MycallableB implements Callable<String> {
        private String input;

        public MycallableB(String input) {
            this.input = input;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50));
            return input + "from B";
        }
    }
}
