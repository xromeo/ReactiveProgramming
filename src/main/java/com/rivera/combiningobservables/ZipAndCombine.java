package com.rivera.combiningobservables;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombine {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> source1 = Observable.interval(1, TimeUnit.SECONDS); 
        Observable<Long> source2 = Observable.interval(1, TimeUnit.MILLISECONDS); 

 
        Observable.zip(source1, source2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
        .subscribe(e-> System.out.println(e));

        Thread.sleep(11000);

        Observable<Long> source3 = Observable.interval(1, TimeUnit.SECONDS).take(5); 
        Observable<Long> source4= Observable.interval(1, TimeUnit.MILLISECONDS).take(5); 

        Observable.combineLatest(source3, source4, (e1, e2) -> "Source 3: " + e1 + " Source 4: " + e2)
        .subscribe(e-> System.out.println(e));

        Thread.sleep(11000);
    }

}
