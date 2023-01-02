package com.rivera.observerpattern;

public interface SubjectLibrary {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void communicate();
}
