package com.nj.mybatisplus.samples.dao;

import com.nj.mybatisplus.samples.entity.TApp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TAppMapper {
    int deleteByPrimaryKey(String appId);

    int insert(TApp record);

    int insertSelective(TApp record);

    TApp selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(TApp record);

    int updateByPrimaryKey(TApp record);
}