package com.rivera.reactive;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

/**
 * ObservableDefer
 */
public class ObservableDefer {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Zoe");
        list.add("Gabriel");
        list.add("Fabricio");
        
        // fromIterable
        System.out.println("Observable fromIterable");

        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(s -> System.out.println(s));
        
        list.add("Omar");
        
        fromIterable.subscribe(s -> System.out.println(s));

        System.out.println("Observable  Defer");

        Observable<String> defer = Observable.defer(() -> Observable.fromIterable(list));

        defer.subscribe(s -> System.out.println(s));

        list.add("Marlene");

        defer.subscribe(System.out::println);
    }
}