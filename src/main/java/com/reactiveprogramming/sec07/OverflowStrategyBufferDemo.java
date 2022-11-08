package com.reactiveprogramming.sec07;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class OverflowStrategyBufferDemo {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed: "+i);
            }
            fluxSink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    sleep(10);
                })
                .subscribe(new DefaultSubscriber());

        sleep(60_000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
