package com.nj.designpatterntest.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.util.Map;

/**
 * 优惠券奖品实现类
 */
public class CouponCommodityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {


          System.out.println("发放优惠券奖品！！");
    }
}
