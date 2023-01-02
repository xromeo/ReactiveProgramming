package com.rivera.combiningobservables;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class MergeAndConcat {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> source1 = Observable.just("Zoe", "Sophia", "Rivera");
        Observable<String> source2 = Observable.just("Marlene", "Lourdes");

        Observable.merge(source1, source2)
        .subscribe(e-> System.out.println("Received: " + e));


        Observable<String> source3 = Observable.interval(1, TimeUnit.SECONDS).map(e-> "Source 3: " + e); 
        Observable<String> source4 = Observable.interval(1, TimeUnit.SECONDS).map(e-> "Source 4: " + e); 

        
        Observable.merge(source3, source4)
        .subscribe(e-> System.out.println("Received: " + e));
        
        Observable.concat(source3, source4)
        .subscribe(e-> System.out.println("Received: " + e));
        
        Thread.sleep(10000);

        source1.mergeWith(source2)
         .subscribe(e-> System.out.println("Received with: " + e));
        
        source1.concatWith(source2)
         .subscribe(e-> System.out.println("Received concat with: " + e));

    }

}
