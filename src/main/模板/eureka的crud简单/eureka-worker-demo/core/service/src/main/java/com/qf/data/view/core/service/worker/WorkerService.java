package com.qf.data.view.core.service.worker;

import com.qf.data.core.dal.po.worker.WorkerPO;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  12:25
 */

/**
 * 业务接口，执行业务所要调用的接口，即向业务提供层提供服务方法，也想业务消费者提供方法
 */
public interface WorkerService {
    int deleteByPrimaryKey(Long id);

    int insert(WorkerPO record);

    int insertSelective(WorkerPO record);

    WorkerPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkerPO record);

    int updateByPrimaryKey(WorkerPO record);

    List<WorkerPO> selectAll();
}
