package com.reactiveprogramming.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnMultipleItems {

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 20; i++) {
                        fluxSink.next(i);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next: "+ i));

        Runnable runnable = () -> flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub" + v));

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(50000);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: "+ Thread.currentThread().getName());
    }
}
