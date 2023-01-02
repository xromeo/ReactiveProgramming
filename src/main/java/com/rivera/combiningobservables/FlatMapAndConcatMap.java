package com.rivera.combiningobservables;

import io.reactivex.rxjava3.core.Observable;

public class FlatMapAndConcatMap {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.just("Zoe", "Sophia", "Rivera");
        
        source1.flatMap(e-> Observable.fromArray(e.split("")))
        .subscribe(e-> System.out.println(e));
        
        Observable<String> source2 = Observable.just("Marlene", "Lourdes");

        source2.concatMap(e-> Observable.fromArray(e.split("")))
        .subscribe(e-> System.out.println(e));

    }

}
