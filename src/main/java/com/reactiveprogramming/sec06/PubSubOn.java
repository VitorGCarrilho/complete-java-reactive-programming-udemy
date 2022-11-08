package com.reactiveprogramming.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PubSubOn {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next: "+ i));

        flux
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("next: "+ i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub" + v));


        Thread.sleep(5000);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: "+ Thread.currentThread().getName());
    }
}
