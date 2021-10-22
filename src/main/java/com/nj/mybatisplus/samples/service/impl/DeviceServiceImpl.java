package com.nj.mybatisplus.samples.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.nj.mybatisplus.samples.entity.Device;
import com.nj.mybatisplus.samples.dao.DeviceMapper;
import com.nj.mybatisplus.samples.service.DeviceService;
@Service
public class DeviceServiceImpl implements DeviceService{

    @Resource
    private DeviceMapper deviceMapper;

    @Override
    public int deleteByPrimaryKey(Long deviceid) {
        return deviceMapper.deleteByPrimaryKey(deviceid);
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public int insertSelective(Device record) {
        return deviceMapper.insertSelective(record);
    }

    @Override
    public Device selectByPrimaryKey(Long deviceid) {
        return deviceMapper.selectByPrimaryKey(deviceid);
    }

    @Override
    public int updateByPrimaryKeySelective(Device record) {
        return deviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Device record) {
        return deviceMapper.updateByPrimaryKey(record);
    }

}
