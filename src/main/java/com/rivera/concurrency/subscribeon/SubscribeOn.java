package com.rivera.concurrency.subscribeon;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) throws InterruptedException{

        // just
        Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .subscribeOn(Schedulers.computation())
                .map(e-> e.toUpperCase())
                .subscribeOn(Schedulers.newThread())
                .filter(e-> e.startsWith("Z"))
                .subscribe(e-> print(e));


        Thread.sleep(6000);
    }

    public static void print(String e) throws InterruptedException {
        System.out.println( e + " : Printed By : " + Thread.currentThread().getName());
    }
}
