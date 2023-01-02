package com.rivera.reactive;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class ColdObservable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zoe");
        list.add("Gabriel");
        list.add("Fabricio");
        

        @NonNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(s -> System.out.println(s));
        
        getData(list);
        
        fromIterable.subscribe(s -> System.out.println(s));

    }

    private static boolean getData(List<String> list) {
        return list.add("Omar");
    }
}
