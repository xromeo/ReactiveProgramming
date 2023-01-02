package com.rivera.concurrency.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {
    public static void main(String[] args) throws InterruptedException{

        // just
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(Schedulers.single());

        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());
        source.subscribe(e -> sensitiveTask());

        Thread.sleep(50000);
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computing done by: " + Thread.currentThread().getName());
    }
}
