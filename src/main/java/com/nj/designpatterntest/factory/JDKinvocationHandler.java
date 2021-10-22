package com.nj.designpatterntest.factory;

import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * 抽象工厂实现代理类
 */
public class JDKinvocationHandler implements InvocationHandler {

    private ICommodityAdapter iCommodityAdapter;
    public JDKinvocationHandler(ICommodityAdapter iCommodityAdapter){
        this.iCommodityAdapter = iCommodityAdapter;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
//        return ICommodityAdapter.class.getMethod(method.getName(),
//                ClassLoaderUtils.getClazzByArgs(args)).invoke(iCommodityAdapter, args);
    }
}
