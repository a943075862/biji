package com.qf.data.view.facade.api;

import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:19
 */

/**
 * 业务层接口
 *      这里是服务提供者所提供业务的上层接口
 */
public interface WorkerFacade {

    ResultModel<WorkerModelResponse> getWorkerById(WorkerModelRequest request);

    ResultModel<List<WorkerModelResponse>> getWorkers();

    ResultModel<WorkerIntModelReponse> insertWorker(WorkerInsertRequest request);

    ResultModel<WorkerIntModelReponse> deleteWorkerById(WorkerModelRequest request);

    ResultModel<WorkerIntModelReponse> updateWorker(WorkerUpdateRequest request);

}
