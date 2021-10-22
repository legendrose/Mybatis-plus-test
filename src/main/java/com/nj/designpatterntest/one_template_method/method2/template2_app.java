package com.nj.designpatterntest.one_template_method.method2;

public class template2_app extends template2_lib{
    @Override
    protected void step2() {
/**
 * 单点登录
 * 在多个应用系统中，只需要登录一次，就可以访问其他相互信任的应用系统。
 *sso就是一处登录，就可以访问其他相互信任的应用系统
 * 授权码的流程：
 * 首先注册，拿到客户端id,以及秘钥
 * 进行单个子系统的登录，跳转到认证登录页面，采集到用户信息，
 * 判断是否授权，没授权，需要通过授权，根据用户以及密码以及注册的客户端标识以及秘钥和代授权码类型code，授权之后，然后进入下一步。
 * 如果已授权，跳转到原先注册的重定向地址
 * 项目采用的授权模式为授权码方式，授权码，然后进行登录，拿到token
 *
 */
        System.out.println("步骤二");
    }

    @Override
    protected void step4() {
        System.out.println("步骤四");
    }
}
