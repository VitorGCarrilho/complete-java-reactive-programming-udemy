package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;

public class MultipleSubscribers {

    public static void main(String[] args) {
        var flux = Flux.just(1, 2, 3, 4);
        flux.subscribe(i -> System.out.println("Sub 1 : "+i));
        flux.subscribe(i -> System.out.println("Sub 2 : "+i));
    }
}
