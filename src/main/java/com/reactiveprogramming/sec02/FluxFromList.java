package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxFromList {
    public static void main(String[] args) {
        var strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(System.out::println);

        Integer [] arr = {1, 2, 3};
        Flux.fromArray(arr)
                .subscribe(System.out::println);
    }
}
