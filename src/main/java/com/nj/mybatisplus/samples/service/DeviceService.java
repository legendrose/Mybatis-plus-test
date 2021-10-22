package com.nj.mybatisplus.samples.service;

import com.nj.mybatisplus.samples.entity.Device;
public interface DeviceService{


    int deleteByPrimaryKey(Long deviceid);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long deviceid);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

}
