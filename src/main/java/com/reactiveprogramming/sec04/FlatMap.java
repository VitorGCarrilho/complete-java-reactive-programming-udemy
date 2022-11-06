package com.reactiveprogramming.sec04;

import com.reactiveprogramming.DefaultSubscriber;
import com.reactiveprogramming.sec01.wrapper.FakerWrapper;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMap {

    public static void main(String[] args) throws InterruptedException {

        UserService.getUsers()
                //.map(user -> OrderService.getOrders(user.getUserId())) // flux
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(new DefaultSubscriber());

        Thread.sleep(10_000);

    }
}

class OrderService {
    private static Map<Integer, List<PurchaseOrder>> repository = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = Arrays.asList(new PurchaseOrder(1), new PurchaseOrder(1), new PurchaseOrder(1));
        List<PurchaseOrder> list2 = Arrays.asList(new PurchaseOrder(2), new PurchaseOrder(2));
        repository.put(1, list1);
        repository.put(2, list2);
    }

    public static Flux<PurchaseOrder> getOrders(int userId) {
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
            repository.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        })
                .delayElements(Duration.ofSeconds(1));
    }
}

class UserService {
    public static Flux<User> getUsers() {
        return Flux.range(1, 2)
                .map(i -> new User(i));
    }
}

@Data
@ToString
class User {
    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        name = FakerWrapper.getName();
    }
}


@Data
@ToString
class PurchaseOrder {
    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = FakerWrapper.getProduct();
        this.price = FakerWrapper.getPrice();
    }
}
