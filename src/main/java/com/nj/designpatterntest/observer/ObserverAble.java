package com.nj.designpatterntest.observer;

import java.util.Observable;

/**
 * 被观察者类，需要继承Observable
 */
public class ObserverAble  extends Observable {

    public void sendData(String msg){
        setChanged();
        notifyObservers(msg);
    }
}
