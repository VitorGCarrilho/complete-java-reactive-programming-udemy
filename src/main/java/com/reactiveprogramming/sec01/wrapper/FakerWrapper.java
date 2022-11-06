package com.reactiveprogramming.sec01.wrapper;

import com.github.javafaker.Faker;

public class FakerWrapper {
    private static final Faker faker = Faker.instance();


    public static String getProduct() {
        return faker.commerce().productName();
    }

    public static String getPrice() {
        return faker.commerce().price();
    }
    public static String getName() {
        return faker.name().firstName();
    }

    public static int randomNumber(int min, int max) {
        return faker.random().nextInt(min, max);
    }

    public static String getRandomCountry() {
        return faker.country().name();
    }
}
