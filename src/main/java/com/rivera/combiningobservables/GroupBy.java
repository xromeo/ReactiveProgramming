package com.rivera.combiningobservables;

import java.security.Key;

import com.rivera.operators.Employee;

import io.reactivex.rxjava3.core.Observable;

public class GroupBy {
    public static void main(String[] args) throws InterruptedException {
        Observable<Employee> observable = Observable.just(
                new Employee(10, "Zoe", 600.0, 4.0),
                new Employee(10, "Sophia", 700.0, 4.7),
                new Employee(10, "Gabriel", 400.0, 4.7),
                new Employee(10, "Fabricio", 800.0, 5.4),
                new Employee(10, "Alejandro", 900.0, 7.4),
                new Employee(10, "Omar", 1100.0, 7.4),
                new Employee(10, "Marlene", 1600.0, 3.25),
                new Employee(10, "Enrique", 300.0, 4.3),
                new Employee(10, "Cristina", 200.0, 4.2),
                new Employee(10, "Lourdes", 1400.0, 4.0));

        observable.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), employee -> employee.getName()))
                              .subscribe(e -> System.out.println(e));
    }

}
