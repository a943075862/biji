package com.qf.data.core.dal.dao.worker;


import com.qf.data.core.dal.po.worker.WorkerPO;

import java.util.List;

public interface WorkerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkerPO record);

    int insertSelective(WorkerPO record);

    WorkerPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkerPO record);

    int updateByPrimaryKey(WorkerPO record);

    List<WorkerPO> selectAll();
}