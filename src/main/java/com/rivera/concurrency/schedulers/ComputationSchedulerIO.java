package com.rivera.concurrency.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationSchedulerIO {
    public static void main(String[] args) throws InterruptedException{

        // just
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(Schedulers.io());

        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());
        source.subscribe(e -> ioOperation());

        Thread.sleep(50000);
    }

    public static void ioOperation() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computing done by: " + Thread.currentThread().getName());
    }
}
