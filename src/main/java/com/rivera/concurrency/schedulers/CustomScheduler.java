package com.rivera.concurrency.schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomScheduler {
    public static void main(String[] args) throws InterruptedException{

        ExecutorService executor = Executors.newFixedThreadPool(20);

        @NonNull
        Scheduler scheduler = Schedulers.from(executor);
        // just
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());

    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computing done by: " + Thread.currentThread().getName());
    }
}
