package com.reactiveprogramming.sec01.wrapper;

import com.github.javafaker.Faker;

public class FakerWrapper {
    private static final Faker faker = Faker.instance();

    public static String getName() {
        return faker.name().firstName();
    }
}
