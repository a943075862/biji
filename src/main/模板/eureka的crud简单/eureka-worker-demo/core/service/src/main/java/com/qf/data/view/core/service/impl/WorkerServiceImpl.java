package com.qf.data.view.core.service.impl;

import com.qf.data.core.dal.dao.worker.WorkerMapper;
import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  12:26
 */

/**
 * 业务层，通过调用mapper实现对数据库的访问，持久层写入
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return workerMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insert(WorkerPO record) {
        return 0;
    }

    @Override
    public int insertSelective(WorkerPO record) {
        return  workerMapper.insert(record);
    }

    @Override
    public WorkerPO selectByPrimaryKey(Long id) {
        return workerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WorkerPO record) {
        return workerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WorkerPO record) {
        return workerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<WorkerPO> selectAll() {
        return  workerMapper.selectAll();
    }
}
