package com.nj.designpatterntest;

import com.nj.designpatterntest.store.CardCommodityService;
import com.nj.designpatterntest.store.CouponCommodityService;
import com.nj.designpatterntest.store.GoodsCommodityService;
import com.nj.designpatterntest.store.ICommodity;

/**
 * 创建型设计模式之一：工厂模式
 * 含义：在父类中提供一个创建对象的方法，允许子类决定实例化对象的类型
 * 实现：定义⼀一个创建对象的接⼝口，让其子类自⼰己决定实例例化哪⼀一个⼯厂类，⼯厂模式使其创建过程延迟到子类行行
 * 采用工厂模式实现以下需求
 * 根据不同的商品类型，发放不同的商品---1优惠券、2实物商品、3第三⽅方兑换卡(爱奇艺)
 *
 * 创建商店工厂
 * 如果不采用工厂模式，直接写一坨代码（一个类中写多个ifelse且逻辑混合一块），业务不出问题。但随着逻辑的复杂性，
 * 加上类型的增多，对于测试回归验证，时间会比较长，不易维护
 */
public class StoreFactory {
    public ICommodity getICommodityService(Integer commodityType){
        if(null == commodityType){return null;}
        if(1 == commodityType){return new GoodsCommodityService();}
        if(2 == commodityType){return new CouponCommodityService();}
        if(3 == commodityType){return new CardCommodityService();}
        throw new RuntimeException("不存在的商品服务类型");
    }
}
