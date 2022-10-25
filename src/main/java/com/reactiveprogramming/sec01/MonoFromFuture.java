package com.reactiveprogramming.sec01;

import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {

    public static void main(String[] args) throws InterruptedException {
        Mono.fromFuture(getName())
                .subscribe(System.out::println);

        Thread.sleep(1000);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(FakerWrapper::getName);
    }
}
