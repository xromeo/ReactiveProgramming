package com.rivera.observerpattern;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Book book = new Book("History", "Drama", "xyz", "SoldOut", 145);

        User user1 = new User("Gabriel", book);
        User user2 = new User("Fabricio", book);
        User user3 = new User("Zoe", book);

        System.out.println(book.getInStock());

        book.setInStock("In Stock");
    }
}
