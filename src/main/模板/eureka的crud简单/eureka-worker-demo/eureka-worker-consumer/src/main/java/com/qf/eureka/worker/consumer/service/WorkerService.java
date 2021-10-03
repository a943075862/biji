package com.qf.eureka.worker.consumer.service;

import com.qf.data.view.core.model.result.ResultModel;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  20:12
 */
public interface WorkerService {

    ResultModel getAll();

    ResultModel getWorkById(Long id);

    ResultModel deleteById(Long id);
}
