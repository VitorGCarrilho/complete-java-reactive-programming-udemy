package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnError {

    public static void main(String[] args) {


        Flux.range(1, 10)
                .log()
                .map(i -> 10/ (5 - i))
                //.onErrorReturn(-1)
                //.onErrorResume(e -> fallback())
                .onErrorContinue((err, obj) -> {})
                .subscribe(new DefaultSubscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> FakerWrapper.getRandomCountry().length());
    }
}
