package com.ej.observertest.observer;

public class MyTextEdit extends MyEdit{

    private String editStr;

    @Override
    public String getEditStr() {
        return editStr;
    }

    @Override
    public void excuteEditText(String str) {
        editStr = str;
        notifyObservers();
    }
}
