package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100)  // after 75% of items consumed, it request more 75
                .subscribe(new DefaultSubscriber());
    }
}
