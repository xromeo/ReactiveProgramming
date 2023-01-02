package com.rivera.operators;

import io.reactivex.rxjava3.core.Observable;

public class Operators {
    public static void main(String[] args) {

        // Suppressing operators

        Observable.just(6,57,89,34,74,77)
        .filter(e -> e > 70)
        .sorted()
        .subscribe(e-> System.out.println("Grade A with " + e));


        Observable.just(6,57,89,34,74,77)
        .take(2)        
        .subscribe(e-> System.out.println("Grade B with " + e));

        Observable.just(6,57,89,34,74,77)
        .skip(4)        
        .subscribe(e-> System.out.println("Grade C with " + e));

        Observable.just(6,57,89,34,74,77, 74)
        .distinct()       
        .subscribe(e-> System.out.println("Grade D with " + e));

        Observable.just(6,57,89,34,74,77, 74)
        .elementAt(5)       
        .subscribe(e-> System.out.println("Grade E with " + e));

    }
}
