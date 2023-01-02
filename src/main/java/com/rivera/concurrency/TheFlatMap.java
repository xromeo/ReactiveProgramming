package com.rivera.concurrency;

import java.time.LocalTime;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TheFlatMap {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
                .flatMap(e -> Observable.just(e)
                        .subscribeOn(Schedulers.computation())
                        .map(s -> compute(s)))
                .subscribe(System.out::println);

        Thread.sleep(7000);
    }

    public static String compute(String e) throws InterruptedException {
        return e + " : Printed By : " + Thread.currentThread().getName() + " at: " + LocalTime.now();
    }
}
 