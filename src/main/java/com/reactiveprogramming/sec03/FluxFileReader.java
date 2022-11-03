package com.reactiveprogramming.sec03;

import com.reactiveprogramming.DefaultSubscriber;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FluxFileReader {
    public static void main(String[] args) throws IOException {
        var path = Path.of("./src/main/resources/file.txt");
        Flux.fromStream(Files.lines(path))
                .subscribe(new DefaultSubscriber());
    }
}
