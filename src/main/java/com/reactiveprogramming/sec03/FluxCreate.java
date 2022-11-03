package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String countryName = "";
                    while (!countryName.equals("Brazil")) {
                        countryName = FakerWrapper.getRandomCountry();
                        fluxSink.next(countryName);
                    }
                    fluxSink.complete();
                })
                .subscribe(new DefaultSubscriber("Country name"));

    }
}
