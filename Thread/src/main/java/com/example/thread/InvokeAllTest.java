package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        System.out.println(invokeAny("你谁说"));
    }


    static String invokeAny(String input) {
        List<Callable<Data>> list = new ArrayList<>();
        list.add(new MycallableA(input));
        list.add(new MycallableB(input));
        try {
            List<Future<Data>> results = executorService.invokeAll(list);
            for (Future<Data> i : results) {
                System.out.println(i.get().toString());
            }
            return String.valueOf(results.size());
        } catch (Exception e) {
            System.out.println("++++++++++++main方法中捕获异常+++++++++++++++");
            e.printStackTrace();
        }
        return "";
    }


    static class MycallableA implements Callable<Data> {
        private String input;

        public MycallableA(String input) {
            this.input = input;
        }

        @Override
        public Data call() throws Exception {
            int sl = ThreadLocalRandom.current().nextInt(50);
            Thread.sleep(ThreadLocalRandom.current().nextInt(sl));
            return new Data("A",sl);
        }
    }

    static class MycallableB implements Callable<Data> {
        private String input;

        public MycallableB(String input) {
            this.input = input;
        }

        @Override
        public Data call() throws Exception {
            int sl = ThreadLocalRandom.current().nextInt(50);
            Thread.sleep(ThreadLocalRandom.current().nextInt(sl));
            return new Data("B",sl);
        }
    }


   static class Data {
        private String str;
        private int num;

        public Data(String str, int num) {
            this.num = num;
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

       @Override
       public String toString() {
           return "Data{" +
                   "str='" + str + '\'' +
                   ", num=" + num +
                   '}';
       }
   }
}