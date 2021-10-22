package com.nj.mybatisplus.samples.service.impl;

import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.nj.mybatisplus.samples.entity.TUser;
import com.nj.mybatisplus.samples.dao.TUserMapper;
import com.nj.mybatisplus.samples.service.TUserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TUserServiceImpl implements TUserService{
    @Resource
    private TUserMapper tUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUser record) {
        return tUserMapper.insert(record);
    }

    @Override
    public int insertSelective(TUser record) {
        return tUserMapper.insertSelective(record);
    }

    @Override
    public TUser selectByPrimaryKey(Long id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        return tUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return tUserMapper.updateByPrimaryKey(record);
    }

}
