package com.nj.mybatisplus.samples.service;

import com.nj.mybatisplus.samples.entity.TApp;
public interface TAppService{


    int deleteByPrimaryKey(String appId);

    int insert(TApp record);

    int insertSelective(TApp record);

    TApp selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(TApp record);

    int updateByPrimaryKey(TApp record);

}
