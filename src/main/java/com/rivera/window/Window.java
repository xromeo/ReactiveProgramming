package com.rivera.window;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Window {
    public static void main(String[] args) throws InterruptedException {

        @NonNull
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observable.interval(500, TimeUnit.MILLISECONDS)
        .window(interval)
        .subscribe(System.out::println);

        Thread.sleep(8000);
    }
}
