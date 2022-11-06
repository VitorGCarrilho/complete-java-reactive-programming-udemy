package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Handle {

    public static void main(String[] args) {
        Flux.range(0, 20)
                .handle(((integer, synchronousSink) -> {
                    if (integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
                }))
                .subscribe(new DefaultSubscriber());
    }
}
