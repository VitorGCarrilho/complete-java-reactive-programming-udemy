package com.reactiveprogramming.sec05;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HotShare {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> movieStream = Flux.fromStream(HotShare::getMovie)
                .delayElements(Duration.ofSeconds(2))
                .share();

        movieStream
                .subscribe(new DefaultSubscriber("Sam"));

        Thread.sleep(5000);

        movieStream
                .subscribe(new DefaultSubscriber("Mike"));

        Thread.sleep(60_000);
    }


    // movie theater
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return IntStream.range(1, 1000).mapToObj(i -> "Scene"+i);
    }
}
