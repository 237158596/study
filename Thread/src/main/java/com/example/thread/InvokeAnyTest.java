package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class InvokeAnyTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        System.out.println(invokeAny("你谁说"));
    }


    static String invokeAny(String input) {
        List<Callable<String>> list = new ArrayList<>();
        list.add(new MycallableA(input));
        list.add(new MycallableB(input));
        try {
            return executorService.invokeAny(list);
        } catch (Exception e) {
            System.out.println("++++++++++++main方法中捕获异常+++++++++++++++");
            e.printStackTrace();
        }
        return "";
    }


    static class MycallableA implements Callable<String> {
        private String input;

        public MycallableA(String input) {
            this.input = input;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50));
            return input + "A";
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
            return input + "B";
        }
    }
}