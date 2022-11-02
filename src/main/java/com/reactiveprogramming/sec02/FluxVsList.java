package com.reactiveprogramming.sec02;

import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FluxVsList {

    public static void main(String[] args) {
        getNamesList(5).forEach(System.out::println);
        getNamesFlux(5).subscribe(System.out::println);
    }

    private static List<String> getNamesList(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    private static Flux<String> getNamesFlux(int count) {
        return Flux.range(1, count)
                .map(i -> getName());
    }

    private static String getName() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return FakerWrapper.getName();
    }
}
