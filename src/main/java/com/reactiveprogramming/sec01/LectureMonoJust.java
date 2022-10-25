package com.reactiveprogramming.sec01;

import reactor.core.publisher.Mono;

public class LectureMonoJust {


    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(i -> System.out.println(i));
    }
}
