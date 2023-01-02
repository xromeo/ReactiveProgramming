package com.rivera.flowable;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Convertion {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1,1000000)
        .toFlowable(BackpressureStrategy.BUFFER)
        .observeOn(Schedulers.io())
        .subscribe(e -> System.out.println(e + " " + Thread.currentThread().getName()));

        Thread.sleep(5000);
    }
}
