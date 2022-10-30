package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

public class LogFlux {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> i * 10)
                .subscribe(System.out::println);
    }
}
