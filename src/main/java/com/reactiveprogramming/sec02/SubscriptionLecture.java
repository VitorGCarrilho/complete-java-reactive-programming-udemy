package com.reactiveprogramming.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import javax.swing.text.Utilities;
import java.util.concurrent.atomic.AtomicReference;

public class SubscriptionLecture {

    public static void main(String[] args) throws InterruptedException {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(0, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: "+ integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError: "+ throwable);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Thread.sleep(3000);
        atomicReference.get().request(3);
        Thread.sleep(5000);
        atomicReference.get().request(3);
        Thread.sleep(5000);
        System.out.println("Cancel");
        atomicReference.get().cancel();
        Thread.sleep(3000);
        atomicReference.get().request(3);
    }
}
