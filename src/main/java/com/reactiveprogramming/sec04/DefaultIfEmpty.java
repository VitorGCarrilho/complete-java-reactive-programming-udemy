package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(new DefaultSubscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(0, 10);
    }
}
