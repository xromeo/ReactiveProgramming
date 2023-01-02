package com.rivera.reactive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class CreateObservable {
    public static void main(String[] args) throws InterruptedException {
        
        // create
        Observable<String>  source = Observable.create(e -> {
            e.onNext("Hola");
            e.onNext("Zoe");
            e.onNext("Fabricio");
            e.onNext("Gabriel");
            e.onComplete();
        });

        source.subscribe(System.out::println);

        // just
        Observable<Integer> just = Observable.just(1,2,3);
        just.subscribe(System.out::println);

        // fromIterable
        List<String> list = List.of("Zoe", "Gabriel", "Fabricio");
        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(s -> System.out.println(s));

        //range
        Observable<Integer> range = Observable.range(25, 2);
        range.subscribe(System.out::println);

        //interval
        Observable<Long> interval = Observable.interval(1,TimeUnit.SECONDS);
        interval.subscribe(System.out::println);
        Thread.sleep(10000);

    }
}
