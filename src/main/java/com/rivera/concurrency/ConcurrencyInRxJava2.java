package com.rivera.concurrency;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava2 {
    public static void main(String[] args) {

        // create
        Observable<String> source = Observable.create(e -> {

            new Thread(() -> {
                e.onNext("Hola");
                e.onNext("Zoe");
                e.onNext("Fabricio");
                e.onNext("Gabriel");
            }).start();

        });

        source.subscribe(e -> System.out.println("Observer 1: " + e + " Thread is : " + Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2: " + e + " Thread is : " + Thread.currentThread().getName()));
    }
}
