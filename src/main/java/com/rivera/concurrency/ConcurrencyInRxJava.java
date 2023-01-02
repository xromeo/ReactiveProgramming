package com.rivera.concurrency;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava {
    public static void main(String[] args) {
        
        // create
        Observable<String> source = Observable.create(e -> {
            e.onNext("Hola");
            e.onNext("Zoe");
            e.onNext("Fabricio");
            e.onNext("Gabriel");            
        });

        source.subscribe(e -> System.out.println("Observer 1: " + e));
        source.subscribe(e -> System.out.println("Observer 2: " + e));
    }
}
