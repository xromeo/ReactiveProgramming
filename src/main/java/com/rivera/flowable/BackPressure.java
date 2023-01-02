package com.rivera.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure {
    public static void main(String[] args) {
        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item is : " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(e -> {
                    sleep(100);
                    System.out.println("Consumed item is : " + e + " : " + Thread.currentThread().getName());
                });

        sleep(1000000000);

    }

    private static void sleep(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
