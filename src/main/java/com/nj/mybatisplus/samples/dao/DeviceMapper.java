package com.nj.mybatisplus.samples.dao;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.nj.mybatisplus.samples.entity.Device;

@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(Long deviceid);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long deviceid);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> findByDevicecodeOrCompcodeOrderByAddress(@Param("devicecode") String devicecode, @Param("compcode") String compcode);

    int updateDevicecodeAndCompcodeByDevicecodeInAndCompcode(@Param("updatedDevicecode") String updatedDevicecode, @Param("updatedCompcode") String updatedCompcode, @Param("devicecodeCollection") Collection<String> devicecodeCollection, @Param("compcode") String compcode);

    int deleteByCompcodeAndDevicecodeIn(@Param("compcode") String compcode, @Param("devicecodes") List<String> devicecodes);

    Integer countByDevicecodeInAndCompcodeIsNotNullAndAddressAfter(@Param("devicecodeCollection")Collection<String> devicecodeCollection,@Param("minAddress")String minAddress);

    List<Device> findByDevicecodeBetweenAndDevicecodeIn(@Param("minDevicecode")String minDevicecode,@Param("maxDevicecode")String maxDevicecode,@Param("devicecodeCollection")Collection<String> devicecodeCollection);

    List<Device> findByAll(Device device);

    int insertList(@Param("list")List<Device> list);

    List<Device> findAllByAddressOrderByAddress(@Param("address")String address);

}