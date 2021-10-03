package com.qf.bigdata.view.web.service;

import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:07
 */

/**
 * 业务消费者的业务接口
 */
public interface WorkerService {

    ResultModel<WorkerResponse> getWorkerById(Long id);

    ResultModel<List<WorkerResponse>> getWorkerAll();

    ResultModel<WorkerIntModelReponse> insertWorker(WorkerInsertRequest request);

    ResultModel<WorkerIntModelReponse> deleteWorkerById(Long id);

    ResultModel<WorkerIntModelReponse> updateWorker(WorkerUpdateRequest request);




}
