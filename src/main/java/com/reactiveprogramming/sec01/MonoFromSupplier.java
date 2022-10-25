package com.reactiveprogramming.sec01;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class MonoFromSupplier {

    public static void main(String[] args) {
        // use just only when you have data already
        //var mono = Mono.just(getName());

        Supplier<String> stringSupplier = MonoFromSupplier::getName;
        var mono = Mono.fromSupplier(stringSupplier); // suply only when there is a sub
    }

    private static String getName() {
        System.out.println("Generating name");
        return Faker.instance().name().firstName();
    }
}
