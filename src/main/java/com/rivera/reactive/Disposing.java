package com.rivera.reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Disposing {

    private static final CompositeDisposable disposables  = new CompositeDisposable();
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        source.subscribe(e -> System.out.println("Observer 1: " + e)).dispose();
        Disposable disposable2 = source.subscribe(e -> System.out.println("Observer 2 : " + e));
        Thread.sleep(5000);
        disposables.add(disposable2);
        disposables.dispose();
        
        Disposable disposable = source.subscribe(e -> System.out.println("Observer 3 ---> : " + e));
        
        Thread.sleep(5000);
        disposable.dispose();


        source.subscribe(e -> System.out.println("Observer 4 ---> : " + e));
        Thread.sleep(10000);
        


    }
}
