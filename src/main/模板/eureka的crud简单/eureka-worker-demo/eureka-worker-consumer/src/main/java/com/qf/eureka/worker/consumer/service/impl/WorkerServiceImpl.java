package com.qf.eureka.worker.consumer.service.impl;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.eureka.worker.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  20:12
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ResultModel getAll() {
        String url ="http://WORKER-PROVIDER/worker/getAll";
        ResultModel result = restTemplate.getForObject(url, ResultModel.class);
        return result;
    }

    @Override
    public ResultModel getWorkById(Long id) {
        String url ="http://WORKER-PROVIDER/worker/get/"+id;
        ResultModel result = restTemplate.getForObject(url, ResultModel.class);
        return result;
    }

    @Override
    public ResultModel deleteById(Long id) {
        String url ="http://WORKER-PROVIDER/worker/delete/"+id;
        ResultModel result = restTemplate.getForObject(url, ResultModel.class);
        return result;
    }
}
