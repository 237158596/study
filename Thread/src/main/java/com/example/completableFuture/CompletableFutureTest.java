package com.example.completableFuture;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> future.complete(CompletableFutureTest.get())).start();
        System.out.println("main thread -> I am not blocked");
        future.whenComplete((v, t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(Throwable::printStackTrace);
        });
        System.out.println("main thread -> I am not blocked");

    }

    @lombok.SneakyThrows
    static double get() {
        Random random = new Random(System.currentTimeMillis());
        Thread.sleep(ThreadLocalRandom.current().nextInt(50));
        return random.nextDouble();
    }
}
