package com.rivera.operators;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OperatorsInAction {
    public static void main(String[] args) {
        Observable<Employee> observable = Observable.just(
            new Employee(10, "Zoe", 600.0, 4.0),
            new Employee(10, "Sophia", 700.0, 4.7),
            new Employee(10, "Gabriel", 400.0, 4.9),
            new Employee(10, "Fabricio", 800.0, 5.4),
            new Employee(10, "Alejandro", 900.0, 7.0),
            new Employee(10, "Omar", 1100.0, 7.4),
            new Employee(10, "Marlene", 1600.0, 3.25),
            new Employee(10, "Enrique", 300.0, 4.3),
            new Employee(10, "Cristina", 200.0, 4.2),
            new Employee(10, "Lourdes", 1400.0, 4.0)
            );

        observable
        .filter(e-> e.getRating() > 4.0)
        .sorted((e1,e2) -> Double.compare(e1.getRating(), e2.getRating()))
        .map(e-> e.getName())
        .take(4)
        .toList()
        .subscribe(System.out::println);

        List<Integer> expenses = List.of(200,300,400,500,350,450,325,275,250,470);
        
        Observable.fromIterable(expenses)
        .scan((a,b) -> a + b)
        .subscribe(System.out::println);

        Observable.fromIterable(expenses)
        .reduce((a,b) -> a + b)
        .subscribe(System.out::println);
    }
}
