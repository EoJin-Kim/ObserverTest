package com.ej.observertest.observer;

import java.util.ArrayList;
import java.util.Observer;

public abstract class MyEdit {
    private ArrayList<MyObserver> observers = new ArrayList();

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }

    public void deleteObserver(MyObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (MyObserver observer : observers) {
            observer.update(this);
        }
    }

    public abstract String getEditStr();
    public abstract void excuteEditText(String str);
}
