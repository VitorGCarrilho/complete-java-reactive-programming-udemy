package com.reactiveprogramming.sec01;

import reactor.core.publisher.Mono;

import java.util.Locale;

public class MonoSubscribe {
    public static void main(String[] args) {
        // publisher
        var mono = Mono.just("ball")
                .map(s -> s.toUpperCase(Locale.ROOT))
                .map(s -> s.concat(" :)"))
                .map(s -> s.length())
                .map(n -> n/0);

        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed"));
    }
}
