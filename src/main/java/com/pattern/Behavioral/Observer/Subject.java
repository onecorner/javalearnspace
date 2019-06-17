package com.pattern.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jhons
 * @since 2019/6/1 15:56
 */
public class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        this.observers.add(observer);
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(observer -> {
            observer.subscrible(this);
        });
    }

}
