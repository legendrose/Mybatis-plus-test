package com.nj.designpatterntest.factory;

import java.util.Map;

/**
 * 0 抽象工厂适配器
 */
public interface ICommodityAdapter {
    /**
     *
     * @param uId 用户ID
     * @param commodityId 奖品ID
     * @param bizId 业务ID
     * @param extMap 扩展字段
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap)throws Exception;
}
