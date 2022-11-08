package com.reactiveprogramming.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ParallelExecution {

    public static void main(String[] args) throws InterruptedException {

        Flux.range(0, 100)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next: " + i))
                .subscribe(i -> printThreadName("sub: " + i));

        Thread.sleep(5000);

    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread: "+ Thread.currentThread().getName());
    }
}
