package com.qf.front.regist.demo.mapper;

import com.qf.front.regist.demo.entity.po.TbDevice;

public interface TbDeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbDevice record);

    int insertSelective(TbDevice record);

    TbDevice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbDevice record);

    int updateByPrimaryKey(TbDevice record);
}