package com.qf.feign.consumer.service.impl;

import com.qf.feign.consumer.api.WorkerFeignAPI;
import com.qf.feign.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  18:05
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerFeignAPI workerFeignAPI;
    @Override
    public String getWorker(Long id) {
        return workerFeignAPI.getWorker(id);

    }

    @Override
    public String postgetWithCookie1(Worker worker) {
        return workerFeignAPI.postGetWithCookie1(worker);
    }
}
