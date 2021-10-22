package com.nj.designpatterntest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

/**
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问
 * 何时使用：想在访问一个类时做一些控制，如：我们没有办法直接访问一个对象，但又想用这个对象的一些功能，这种时候
 * 我们就可以创建一个代理对象，通过代理对象，间接的访问这个对象。
 * 要想访问国外的网站，必须通过蓝灯，lanten就是代理对象
 * 如何解决：增加中间层
 * 违反了哪个原则：单一性原则：每个类的功能尽可能单一，否则又输出日志又处理业务，后期改动较大。
 * 这就出现了aop为啥使用代理来做的原因
 * 代码中遇到的哪些问题，需要通过代理模式进行重构？如日志处理
 *
 * AOP采用的是动态代理
 * 动态代理是代理类不需要开发人员编译，而是通过反射机制进行创建
 * 如jdk动态代理，cglib动态代理
 * jdk代理，需要实现InvocationHandler,重写invoke方法
 * 采用Proxy.newProxyInstance
 * cglib可以对任意类生成代理对象，而jdk只对实现了InvocationHandler的类生成代理对象
 * cglib是对jdk动态代理的补充，为没有实现接口的目标对象提供代理
 *
 */
public class MyInvocationHandler  implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("权限校验");

        Object result = method.invoke(target, args);

        System.out.println("日志记录");

        return result; // 返回的是代理对象
    }

    public static void main (String[] args){
        Person xx = new Student("zzz");
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(xx);
        Proxy.newProxyInstance(xx.getClass().getClassLoader(),xx.getClass().getInterfaces(), myInvocationHandler);
        xx.giveMoney();
    }
}
//接口
interface Person {
    //上交班费
    void giveMoney();
}

//被代理类
class Student  implements Person{
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
