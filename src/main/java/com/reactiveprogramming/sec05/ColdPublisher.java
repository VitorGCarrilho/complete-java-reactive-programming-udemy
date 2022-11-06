package com.reactiveprogramming.sec05;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ColdPublisher {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> movieStream = Flux.fromStream(ColdPublisher::getMovie)
                .delayElements(Duration.ofSeconds(2));

        movieStream
                .subscribe(new DefaultSubscriber("Sam"));

        Thread.sleep(5000);

        movieStream
                .subscribe(new DefaultSubscriber("Mike"));

        Thread.sleep(60_000);
    }


    // netflix
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming request");
        return IntStream.range(1, 1000).mapToObj(i -> "Scene"+i);
    }
}
