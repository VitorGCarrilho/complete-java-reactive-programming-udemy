package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {

    public static void main(String[] args) {
        var stream = Stream.of(1, 2, 3, 4, 5);
        var integerFlux = Flux.fromStream(stream);

        integerFlux.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed"));

        // Stream already operated
        integerFlux.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed"));
    }
}
