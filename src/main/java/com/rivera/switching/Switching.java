package com.rivera.switching;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

/**
 * Switching
 */
public class Switching {

    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<@NonNull String> source = Observable.just("Zoe", "Fabricio", "Gabriel", "Marlene", "Omar")
        .concatMap(s-> Observable.just(s)
        .delay(ThreadLocalRandom.current().nextInt(1000),TimeUnit.MILLISECONDS)
        );

        Observable.interval(2, TimeUnit.SECONDS)
        .switchMap(s-> source.doOnDispose(() -> System.out.println("Disposing and starting again!")))
        .subscribe(System.out::println);

        Thread.sleep(10000);
    }
}