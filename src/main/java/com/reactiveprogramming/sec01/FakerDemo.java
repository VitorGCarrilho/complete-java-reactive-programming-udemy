package com.reactiveprogramming.sec01;

import com.github.javafaker.Faker;

public class FakerDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Faker.instance().name().firstName();
        }
    }
}
