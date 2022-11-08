package com.reactiveprogramming.sec06;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class FluxInterval {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .subscribeOn(Schedulers.boundedElastic()) // does not change
                .subscribe(new DefaultSubscriber());


        Thread.sleep(10000);
    }
}
