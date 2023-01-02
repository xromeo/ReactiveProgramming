package com.rivera.observerpattern;

public class User implements Observer {

    private String name;

    
    public User(String name, SubjectLibrary subject) {
        this.name = name;
        subject.subscribe(this);
    }

    @Override
    public void update(String value) {
        System.out.println("Hello " + this.name + " we are glad to notify you that your book is now " + value);
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
