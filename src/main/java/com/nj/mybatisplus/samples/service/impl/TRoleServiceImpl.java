package com.nj.mybatisplus.samples.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.nj.mybatisplus.samples.entity.TRole;
import com.nj.mybatisplus.samples.dao.TRoleMapper;
import com.nj.mybatisplus.samples.service.TRoleService;
@Service
public class TRoleServiceImpl implements TRoleService{

    @Resource
    private TRoleMapper tRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long roleId) {
        return tRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(TRole record) {
        return tRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TRole record) {
        return tRoleMapper.insertSelective(record);
    }

    @Override
    public TRole selectByPrimaryKey(Long roleId) {
        return tRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        return tRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRole record) {
        return tRoleMapper.updateByPrimaryKey(record);
    }

}
