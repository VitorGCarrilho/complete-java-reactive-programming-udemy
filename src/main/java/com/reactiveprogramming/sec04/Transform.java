package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;

import javax.swing.text.Utilities;
import java.util.function.Function;

public class Transform {

    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(new DefaultSubscriber());
    }

    private static Flux<Person> getPerson() {
        return Flux.range(1, 18)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing person: "+p));
    }
}


@Data
@ToString
class Person {
    private String name;
    private int age;

    public Person() {
        this.name = FakerWrapper.getName();
        this.age = FakerWrapper.randomNumber(1, 30);
    }
}
