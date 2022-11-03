package com.reactiveprogramming.sec03;

import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class CountryEmiter implements Consumer<FluxSink<String>> {

    private FluxSink<String> stringFluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.stringFluxSink = stringFluxSink;
    }

    public void emit() {
        var countryName = FakerWrapper.getRandomCountry();
        var threadName = Thread.currentThread().getName();
        stringFluxSink.next(threadName + " - " +countryName);
    }
}
