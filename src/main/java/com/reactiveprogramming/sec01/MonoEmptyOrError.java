package com.reactiveprogramming.sec01;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.Locale;

public class MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(2)
                .map(s -> s.toUpperCase(Locale.ROOT))
                .subscribe(
                    System.out::println,
                    err -> System.out.println(err.getMessage()),
                    () -> System.out.println("completed"));
    }

    // mock
    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Faker.instance().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(RuntimeException::new);
        }

    }
}
