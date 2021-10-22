package com.nj.designpatterntest.store;

import java.util.Map;

/**
 * 奖品发放接口
 * 保证入参出参的一致性
 */
public interface ICommodity {
    /**
     *
     * @param uId 用户ID
     * @param commodityId 奖品ID
     * @param bizId 业务ID
     * @param extMap 扩展字段
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String,String> extMap)throws Exception;
}
