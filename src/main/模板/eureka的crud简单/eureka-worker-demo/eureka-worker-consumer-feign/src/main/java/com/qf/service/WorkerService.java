package com.qf.service;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.result.ResultModel;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  21:11
 */
public interface WorkerService {
    ResultModel updateWorker(WorkerPO workerPO);

    ResultModel insertWorker(WorkerPO workerPO);
}
