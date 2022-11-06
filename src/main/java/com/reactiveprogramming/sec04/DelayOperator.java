package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DelayOperator {
    public static void main(String[] args) throws InterruptedException {
        Flux.range(0, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(new DefaultSubscriber());

        Thread.sleep(100* 1000);
    }
}
