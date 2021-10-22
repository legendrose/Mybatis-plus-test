package com.nj.designpatterntest.one_template_method;

import com.nj.designpatterntest.one_template_method.method2.template2_app;
import com.nj.designpatterntest.one_template_method.method2.template2_lib;

/**
 * 模板方法模式：稳定与变化（抽象方法）
 * 含义：定义一个操作中的算法的骨架（稳定），而将一些步骤延迟（变化）到子类中。
 * Template Method使得子类可以不改变（复用）一个算法的结构即可重定义（重写）该算法的某些特定步骤
 */
public class Main {
    public static void main(String[] args){
       /* template1_app t1_app = new template1_app();
        template_lib t1_lib = new template_lib();
        if(t1_lib.step1()){
            t1_app.step2();
        }else if (t1_lib.step3()){
            t1_app.step4();
        }
        t1_lib.step5();*/

        //利用模板方法
        template2_lib t2_app = new template2_app();
        t2_app.run();

        /**
         * 公交智慧大脑是一个集成多个子系统的平台，各个子系统通过单点登录的方式进行统一认证登录
         * 采用springsecurity进行开发
         * 我负责的部分是认证服务的开发，以及基础平台的开发
         * 认证服务是通过springsecurity进行开发，认证服务也是资源服务，在同一项目中进行开发，涉及自定义认证管理，资源的获取
         * 基础平台是一个权限分配以及开发基础信息的平台，该平台采用rbac设计模式进行开发，rbac设计模式是角色分配权限。用户获取角色，达到用户控制权限的一种模式
         * ，从而使用户与权限分离开来，便于管理
         *
         * //自定义认证管理：因为传统的登录是采用form进行登录，由于要采用ajax进行发送请求，以及需要获取一些其他的信息，因此需要自定义认证。
         *
         *                  自定义认证是在web安全配置类中进行配置，采用处理器继承‘抽象认证处理器AbstractAuthenticationProcessingFilter’
         *                  ,然后重写方法以及构造函数，构造函数中有认证失败，成功类
         *
         * 单点登录&&自定义认证
         *注销某一个平台，清除token
         */
    }
}
