package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(new DefaultSubscriber());
    }

    // redis cache
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(0, 10);
    }

    // database
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }
}
