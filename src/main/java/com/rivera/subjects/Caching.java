package com.rivera.subjects;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class Caching {
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<@NonNull Long> source1 = Observable.interval(1, TimeUnit.SECONDS)
        .cache(); 
       
        source1.subscribe(e-> System.out.println("Observer 1 :" +e) );
        
        Thread.sleep(5000);
        
        source1.subscribe(e-> System.out.println("Observer 2-> :" +e) );

        Thread.sleep(3000);
    }

}
