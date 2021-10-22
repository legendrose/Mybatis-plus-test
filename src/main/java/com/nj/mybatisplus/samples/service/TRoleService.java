package com.nj.mybatisplus.samples.service;

import com.nj.mybatisplus.samples.entity.TRole;
public interface TRoleService{


    int deleteByPrimaryKey(Long roleId);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

}
