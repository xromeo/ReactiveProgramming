package com.rivera.buffering;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Buffering2 {
    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS)
        .buffer(interval)
        .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
