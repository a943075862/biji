package com.qf.bigdata.view.web.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.bigdata.view.web.service.WorkerService;
import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.api.WorkerFacade;
import com.qf.data.view.facade.request.worker.WorkerInsertModelRequest;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.request.worker.WorkerUpdateModelRequest;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:07
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    //调用远程的业务方法实现类
    @Reference
    private WorkerFacade workerFacade;
    @Override
    public ResultModel<WorkerResponse> getWorkerById(Long id) {
        //封装对象
        WorkerModelRequest workerModelRequest = new WorkerModelRequest();
        workerModelRequest.setId(id);
        //调用dubbo对象的方法,获得结果模型对象
        ResultModel<WorkerModelResponse> workerById = workerFacade.getWorkerById(workerModelRequest);
        //解析结果
        if (Objects.nonNull(workerById)){
            //创建一个工人返回数据对象
            WorkerResponse workerResponse = new WorkerResponse();
            //使用beanutils工具将dubbo对象获取的对象提取中间数据，赋值给新的工人返回对象
            BeanUtils.copyProperties(workerById.getData(),workerResponse);
            //返回结果对象给controller
            return ResultModel.success(workerResponse);
        }
        //报错，返回给controller
        return ResultModel.error();
    }

    @Override
    public ResultModel<List<WorkerResponse>> getWorkerAll() {
        //无需传入对象，直接执行查询所有的方法
        ResultModel<List<WorkerModelResponse>> workers = workerFacade.getWorkers();
        List<WorkerModelResponse> workersData = workers.getData();
        //解析结果
        if (Objects.nonNull(workersData)){
            //创建一个工人返回对象
            ArrayList<WorkerResponse> workerResponses = new ArrayList<>();
            //遍历对象存到集合中
            for (WorkerModelResponse workersDatum : workersData) {
                WorkerResponse workerResponse = new WorkerResponse();
                //调用beanutils工具将获得结果赋值
                BeanUtils.copyProperties(workersDatum,workerResponse);
                //将赋完值的对象存到集合中
                workerResponses.add(workerResponse);
            }
            //返回给控制器
            return ResultModel.success(workerResponses);
        }
        //查询出错，返回err状态码
        return ResultModel.error();
    }

    @Override
    public ResultModel<WorkerIntModelReponse> insertWorker(WorkerInsertRequest request) {
        //封装一个对象,请求模型对象
        WorkerInsertModelRequest workerInsertModelRequest = new WorkerInsertModelRequest();
        BeanUtils.copyProperties(request,workerInsertModelRequest);
        //通过dubbo调用远程业务
        ResultModel<WorkerIntModelReponse> insertWorker=workerFacade.insertWorker(request);
        //判断得到的对象是否为空
        if (Objects.nonNull(insertWorker)){
           return insertWorker;
        }else {
            return ResultModel.error("服务器状态异常");
        }
    }

    @Override
    public ResultModel<WorkerIntModelReponse> deleteWorkerById(Long id) {
        //封装请求参数
        WorkerModelRequest workerModelRequest = new WorkerModelRequest();
        workerModelRequest.setId(id);
        //调用dubbo执行删除操作
        ResultModel<WorkerIntModelReponse> deleteWorkerById=workerFacade.deleteWorkerById(workerModelRequest);
        //得到返回结果，判断是否为空
        if (Objects.nonNull(deleteWorkerById)){
            return deleteWorkerById;
        }else {
            return ResultModel.error("服务器状态异常");
        }
    }

    @Override
    public ResultModel<WorkerIntModelReponse> updateWorker(WorkerUpdateRequest request) {
        //封装一个对象,请求模型对象
        WorkerUpdateModelRequest workerInsertModelRequest = new WorkerUpdateModelRequest();
        BeanUtils.copyProperties(request,workerInsertModelRequest);
        //调用业务方法得到返回结果
        ResultModel<WorkerIntModelReponse> updateWorker=workerFacade.updateWorker(request);
        //判断是否为空
        if (Objects.nonNull(updateWorker)){
            return updateWorker;
        }else {
            return ResultModel.error("服务器状态异常");
        }
    }




}
