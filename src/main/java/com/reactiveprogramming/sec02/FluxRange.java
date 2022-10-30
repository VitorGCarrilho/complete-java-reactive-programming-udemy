package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .subscribe(System.out::println);
    }
}
