package com.nj.mybatisplus.samples.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nj.mybatisplus.samples.domain.User;
import com.nj.mybatisplus.samples.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TUserMapper extends BaseMapper<TUser>{
    int deleteByPrimaryKey(Long id);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser select(TUser record);
}