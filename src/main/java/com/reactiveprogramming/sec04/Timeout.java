package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Timeout {
    public static void main(String[] args) throws InterruptedException {

        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(new DefaultSubscriber());

        Thread.sleep(5000);

    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(0, 10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
