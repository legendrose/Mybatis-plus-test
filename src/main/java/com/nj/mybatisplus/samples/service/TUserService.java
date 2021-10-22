package com.nj.mybatisplus.samples.service;

import com.nj.mybatisplus.samples.entity.TUser;
public interface TUserService{


    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

}
