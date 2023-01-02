package com.rivera.operators;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ambiguous {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.interval(1, TimeUnit.SECONDS).take(10).map(e-> "Observable 1: " + e); 
        Observable<String> source2 = Observable.interval(1, TimeUnit.MILLISECONDS).take(10).map(e-> "Observable 2: " + e); 


        Observable.amb(Arrays.asList(source1, source2))
        .subscribe(e-> System.out.println(e));

        Thread.sleep(11000);
    }

}
