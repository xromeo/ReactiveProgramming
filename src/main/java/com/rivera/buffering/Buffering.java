package com.rivera.buffering;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Buffering {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 30)
        .buffer(4)
        .subscribe(System.out::println);

        System.out.println();
        
        Observable.range(1, 30)
        .buffer(4,7)
        .subscribe(System.out::println);
        
        System.out.println();

        Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(1, TimeUnit.SECONDS)
        .subscribe(System.out::println);

        Thread.sleep(8000);

        System.out.println();

        Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(1, TimeUnit.SECONDS, 3)
        .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
