package com.nj.designpatterntest.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者 需要实现Observer
 */
public class WeiXinUser implements Observer {
    private String name;
    public WeiXinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name+"-"+arg);
    }
}
