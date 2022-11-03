package com.reactiveprogramming.sec03;

import com.github.javafaker.Faker;
import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

public class FluxWithState {
    public static void main(String[] args) {
        Flux.generate(
                ()  -> 1,
                (counter, sink ) -> {
                    String country = FakerWrapper.getRandomCountry();
                    sink.next(country);
                    if(counter>=10 || counter.equals("Brazil")) {
                        sink.complete();
                    }

                    return counter + 1;
                }
        ).subscribe(new DefaultSubscriber());
    }
}
