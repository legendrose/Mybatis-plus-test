package com.nj;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Test {
    public void start(){
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("钩子函数被执行，可以在这里关闭资源");
        }));
    }
    public static void main(String[] args){
        /**
         * 容器是spring的核心。spring容器使用依赖注入（DI）管理构成的组件。
         * spring容器负责创建组件，装配组件，配置他们并管理他们的生命周期，从生存到死亡（new-finialize()）
         * spring容器不止一个，spring自带了许多容器，为bean工厂（org.springframework.beans.factory.BeanFactory接口定义）是最简单的容器，提供基本的DI支持
         * 以及应用上下文（org.springframework.context.ApplicationContext接口定义）基于BeanFactory构建，并提供应用框架级别的组件
         *
         */

        //使用应用上下文，spring自带了许多类型的应用上下文：
       /* AnnotationConfigApplicationContext;
        AnnotationConfigWebApplicationContext;
        ClassPathXmlApplicationContext*/


        new Test().start();
        System.out.println("主应用程序在执行");
//        Runtime.getRuntime().halt(1);
        byte[] b = new byte[500*1024*1024];
    }
}
