package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

public class FluxCreateFixTakeIssue {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String countryName = "";
                    while (!countryName.equals("Brazil") && !fluxSink.isCancelled()) {
                        countryName = FakerWrapper.getRandomCountry();
                        System.out.println("emitting "+countryName);
                        fluxSink.next(countryName);

                    }
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(new DefaultSubscriber("Country name"));

    }
}
