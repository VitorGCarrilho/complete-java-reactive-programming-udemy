package com.reactiveprogramming.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        var flux = Flux.from(mono);

        flux.subscribe(System.out::println);


        Mono<String > monoFromFlux = flux.next();



    }
}
