package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class FluxPush {

    public static void main(String[] args) throws InterruptedException {

        CountryEmiter countryEmiter = new CountryEmiter();
        Flux.push(countryEmiter) // not thread safe
                .subscribe(new DefaultSubscriber("country name with Emiter"));


        for (int i = 0; i < 10; i++) {
            new Thread(countryEmiter::emit).start();
        }

        Thread.sleep(2000);
    }
}
