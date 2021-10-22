package com.nj.mybatisplus.samples.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nj.mybatisplus.samples.domain.UserRole;
import com.nj.mybatisplus.samples.entity.TRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TRoleMapper extends BaseMapper<TRole> {
    int deleteByPrimaryKey(Long roleId);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

    List<TRole> selectUser();
}