package com.qf.service.impl;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.feign.api.WorkerFeignAPI;
import com.qf.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  21:12
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerFeignAPI workerFeignAPI;
    @Override
    public ResultModel updateWorker(WorkerPO workerPO) {
        return workerFeignAPI.updateWorker(workerPO);
    }

    @Override
    public ResultModel insertWorker(WorkerPO workerPO) {
        return workerFeignAPI.insertWorker(workerPO);
    }
}
