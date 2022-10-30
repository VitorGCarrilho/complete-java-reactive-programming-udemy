package com.reactiveprogramming.sec01;

import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                System.out.println("running");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Mono.fromRunnable(runnable)
                .subscribe(
                        System.out::println,
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("completed"));
    }
}
