package com.nj.designpatterntest.observer;

import java.util.Observable;

/**
 * 实现微信公众号为订阅者推送文章
 * 观察者模式有点类似发布订阅模式，但又不完全相像
 * 发布订阅模式，中间有个中间件，就是我们所说的消息队列，而观察者模式却
 */
public class ObserverMain {
public static void main(String[] args){
    WeiXinUser u1 = new WeiXinUser("张三");
    WeiXinUser u2 = new WeiXinUser("李四");
    WeiXinUser u3 = new WeiXinUser("王五");
    //实例化被观察者
    ObserverAble obs = new ObserverAble();
    //新增观察者
    obs.addObserver(u1);
    obs.addObserver(u2);
    obs.addObserver(u3);
    //推送文章
    obs.sendData("最新一期的娱乐碰碰碰更新啦！");
}

}
