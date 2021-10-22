package com.nj.mybatisplus.samples.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.nj.mybatisplus.samples.dao.TAppMapper;
import com.nj.mybatisplus.samples.entity.TApp;
import com.nj.mybatisplus.samples.service.TAppService;
@Service
public class TAppServiceImpl implements TAppService{

    @Resource
    private TAppMapper tAppMapper;

    @Override
    public int deleteByPrimaryKey(String appId) {
        return tAppMapper.deleteByPrimaryKey(appId);
    }

    @Override
    public int insert(TApp record) {
        return tAppMapper.insert(record);
    }

    @Override
    public int insertSelective(TApp record) {
        return tAppMapper.insertSelective(record);
    }

    @Override
    public TApp selectByPrimaryKey(String appId) {
        return tAppMapper.selectByPrimaryKey(appId);
    }

    @Override
    public int updateByPrimaryKeySelective(TApp record) {
        return tAppMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TApp record) {
        return tAppMapper.updateByPrimaryKey(record);
    }

}
