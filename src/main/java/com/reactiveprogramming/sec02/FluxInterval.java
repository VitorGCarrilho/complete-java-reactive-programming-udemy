package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(System.out::println);

        Thread.sleep(5000);
    }
}
