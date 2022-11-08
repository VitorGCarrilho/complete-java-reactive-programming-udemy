package com.reactiveprogramming.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
        })
                .subscribeOn(Schedulers.newParallel("vins"))
                .doOnNext(i -> printThreadName("next: "+ i));

        Runnable runnable = () -> flux
                .doFirst(() -> printThreadName("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("first1"))
                .subscribe(v -> printThreadName("sub" + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(5000);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: "+ Thread.currentThread().getName());
    }
}
