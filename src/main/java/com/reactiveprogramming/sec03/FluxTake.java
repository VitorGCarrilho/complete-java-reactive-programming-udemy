package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class FluxTake {

    public static void main(String[] args) {
        Flux.range(0, 10)
                .log()
                .take(3) // cancels
                .log()
                .subscribe(new DefaultSubscriber());
    }
}
