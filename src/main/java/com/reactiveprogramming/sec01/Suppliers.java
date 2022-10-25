package com.reactiveprogramming.sec01;

import jdk.jshell.execution.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

public class Suppliers {

    public static void main(String[] args) {


        String name = getName("Vitor")
                .subscribeOn(Schedulers.boundedElastic())
                .block(); // should not use
        System.out.println(name);

        // async non blocking
        getName("Gabriel")
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(System.out::println);
        getName("Carrilho")
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(System.out::println);

        sleepSeconds(4);
    }


    private static Mono<String> getName(String name) {
        System.out.println("started="+ LocalDateTime.now() +" name="+name);
        return Mono.fromSupplier(() -> {
            System.out.println("generating="+LocalDateTime.now()+" name="+name);
            sleepSeconds(3);
            System.out.println("generated="+LocalDateTime.now()+" name="+name);
            return name;
        }).map(String::toUpperCase);
    }


    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
