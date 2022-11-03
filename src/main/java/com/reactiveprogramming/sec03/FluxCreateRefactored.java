package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

public class FluxCreateRefactored {

    public static void main(String[] args) throws InterruptedException {

        CountryEmiter countryEmiter = new CountryEmiter();
        Flux.create(countryEmiter)
                .subscribe(new DefaultSubscriber("country name with Emiter"));


        for (int i = 0; i < 10; i++) {
            new Thread(countryEmiter::emit).start();
        }

        Thread.sleep(2000);
    }
}
