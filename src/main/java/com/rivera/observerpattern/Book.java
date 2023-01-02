package com.rivera.observerpattern;

import java.util.ArrayList;

public class Book implements SubjectLibrary {

    private String name;
    private String type;
    private String author;
    private String inStock;
    private double price;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Book() {
    }

    public Book(String name,
            String type,
            String author,
            String inStock,
            double price) {
                this.price = price;
                this.type = type;
                this.name = name;
                this.author = author;
                this.inStock = inStock;
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void communicate() {
        System.out.println("Book [name=" + name + ", type=" + type + ", author=" + author + ", inStock=" + inStock + ", price="
        + price + "], So, notify all users.");
        for (Observer observer : observers) {
            observer.update(this.inStock);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
        System.out.println("Available changed from Sold out to Back in stock");
        this.communicate();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

}
