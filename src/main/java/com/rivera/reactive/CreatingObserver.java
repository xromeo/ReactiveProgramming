package com.rivera.reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {
        @NonNull
        Observable<String> source = Observable.just("Zoe", "Gabriel", "Fabricio");
        source.subscribe(s -> System.out.println(s), Throwable::printStackTrace, () -> System.out.println("Completed"));
        System.out.println();

        source.subscribe(System.out::println, Throwable::printStackTrace);
        System.out.println();

        source.subscribe(System.out::println);
    }
}
