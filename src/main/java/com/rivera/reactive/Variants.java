package com.rivera.reactive;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Zoe", "Fabricio", "Gabriel");
        source
                .first("Name")
                .subscribe(System.out::println);

        System.out.println();
        // Single
        Single<String> singleSource = Single.just("Zoe");
        singleSource.subscribe(System.out::println);

        System.out.println();

        Observable<String> source1 = Observable.empty();
        // Maybe
        source1
                .firstElement()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed!"));

        System.out.println();

        Completable completable = Completable.complete();
        completable.subscribe(() -> System.out.println("Completed"));

        System.out.println();

        Completable
                .fromRunnable(() -> {
                    System.out.println("Some process are running");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .subscribe(() -> System.out.println("The process executed successfully!!!"));
    }
}
