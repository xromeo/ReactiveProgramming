package com.rivera.concurrency.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {
    public static void main(String[] args) throws InterruptedException{

        // just
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(Schedulers.computation());

        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());
        source.subscribe(e -> compute());

        Thread.sleep(5000);
    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computing done by: " + Thread.currentThread().getName());
    }
}
