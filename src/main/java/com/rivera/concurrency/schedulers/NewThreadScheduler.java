package com.rivera.concurrency.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {
    public static void main(String[] args) throws InterruptedException{

        // just
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(Schedulers.newThread());

        source.subscribe(e -> task());
        Thread.sleep(6000);
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());
        source.subscribe(e -> task());

        Thread.sleep(50000);
    }

    public static void task() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computing done by: " + Thread.currentThread().getName());
    }
}
