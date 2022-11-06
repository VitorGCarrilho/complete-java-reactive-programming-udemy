package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class SwitchOnFirst {

    public static void main(String[] args) {
        getPerson()
                .switchOnFirst(((signal, flux) -> {
                    return signal.isOnNext() && signal.get().getAge() > 18 ? flux : applyFilterMap().apply(flux);
                }))
                .subscribe(new DefaultSubscriber());
    }

    private static Flux<Person> getPerson() {
        return Flux.range(1, 18)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 18)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing person: "+p));
    }
}
