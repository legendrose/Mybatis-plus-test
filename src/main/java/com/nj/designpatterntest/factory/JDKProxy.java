package com.nj.designpatterntest.factory;

import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.security.Signature;
import java.util.List;

/**
 * 抽象工厂：1 代理类
 */
public class JDKProxy implements Cloneable{


    public static<T> T getProxy(Class<T> interfaceClass,ICommodityAdapter iCommodityAdapter)throws Exception{
        InvocationHandler handler = new JDKinvocationHandler(iCommodityAdapter);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = interfaceClass.getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, (org.springframework.cglib.proxy.InvocationHandler) handler);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /*  无法同时出现在同一个类中的原因：泛型擦除，因为参数List<String>,List<Integer>编译之后都被擦除了，变成了原生类型List.所以无法通过编译.
    擦除动作导致这两种方法的特征签名变得相同
    public static void method(List<String> list){
        Signature
        System.out.println("invoke method(List<String> list)");

    }
    public static void method(List<Integer> list){
        System.out.println("invoke method(List<Integer> list)");

    }*/
}
