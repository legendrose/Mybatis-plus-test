package com.nj.designpatterntest.store;

import java.util.Map;

/**
 * 实物奖品实现类
 */
public class GoodsCommodityService implements ICommodity{
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("发放实物奖品！！");
    }
}
