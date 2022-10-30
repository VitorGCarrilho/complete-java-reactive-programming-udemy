package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

public class FluxIntro {

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4, 5);

        flux.subscribe(System.out::println);
    }
}
