package com.rivera.subjects;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Subjects2 {
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<@NonNull Integer> source1 = Observable.just(5,10,15,20,25).subscribeOn(Schedulers.computation());
      //  @NonNull
      //  Observable<@NonNull Integer> source2 = Observable.just(500,1000,1500,2000,2500).subscribeOn(Schedulers.computation());

        //source1.subscribe(e-> System.out.println(e));
        //source2.subscribe(e-> System.out.println(e));

        @NonNull
        PublishSubject<Object> subject = PublishSubject.create();

        subject.subscribe(e-> System.out.println(e));
        subject.subscribe(e-> System.out.println("The element is: " + e));

        source1.subscribe(subject);
        //source2.subscribe(subject);

        Thread.sleep(10000);
    }
}
