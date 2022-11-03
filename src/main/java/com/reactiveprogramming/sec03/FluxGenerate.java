package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxGenerate {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();

        Flux.generate(synchronousSink -> {
                    var country = FakerWrapper.getRandomCountry();
                    synchronousSink.next(country); // only one item

                    var times = atomicInteger.incrementAndGet();
                    if (country.equals("Brazil") || times >= 10) {
                        synchronousSink.complete();
                    }
                    // synchronousSink.next(FakerWrapper.getRandomCountry()); // error: More than one call to onNext
                })
                //.take(10)
                .subscribe(new DefaultSubscriber());
    }
}
