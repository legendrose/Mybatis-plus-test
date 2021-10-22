package com.nj.designpatterntest.store;

import java.util.Map;

/**
 * 第三方兑换卡奖品实现类
 */
public class CardCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("发放第三方兑换卡奖品！！");
    }
}
