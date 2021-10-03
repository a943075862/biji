package com.qf.data.view.facade.service.worker;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.worker.WorkerService;
import com.qf.data.view.facade.api.WorkerFacade;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:18
 */

/**
 * 业务提供者所提供业务的方法
 */
@Service
public class WorkerFacadeImpl implements WorkerFacade {
    @Autowired
    private WorkerService workerService;

    /**
     * 通过工人id查找数据
     * @param request
     * @return
     */
    @Override
    public ResultModel<WorkerModelResponse> getWorkerById(WorkerModelRequest request) {
        //从数据库拿取数据
        WorkerPO workerPO = workerService.selectByPrimaryKey(request.getId());
        //创建一个工人返回结果对象
        WorkerResponse workerResponse = new WorkerResponse();
        //使用beanutils工具将workerpo赋值给workerresponse
        BeanUtils.copyProperties(workerPO,workerResponse);
        return ResultModel.success(workerResponse);
    }

    /**
     * 查询所有工人，无需参数
     * @return
     */
    @Override
    public ResultModel<List<WorkerModelResponse>> getWorkers() {
        //从数据库中取值
        List<WorkerPO> workerPOS = workerService.selectAll();
        //使用beanutils赋值
        //创建集合收参
        ArrayList<WorkerModelResponse> workerResponses = new ArrayList<WorkerModelResponse>();
        for (WorkerPO workerPO : workerPOS) {
            //创建一个工人返回结果对象
            WorkerModelResponse workerModelResponse = new WorkerModelResponse();
            BeanUtils.copyProperties(workerPO,workerModelResponse);
            //将转换的对象放入集合
            workerResponses.add(workerModelResponse);
        }
        //传递给业务消费者
        return ResultModel.success(workerResponses);
    }

    @Override
    public ResultModel<WorkerIntModelReponse> insertWorker(WorkerInsertRequest request) {
        //创建收参对象
        WorkerPO workerPO = new WorkerPO();
        //复制控制层传来的参数，将值传给新对象
        BeanUtils.copyProperties(request,workerPO);
        //从数据库取值
        int row = workerService.insertSelective(workerPO);
        //返回结果参数
        WorkerIntModelReponse workerIntModelReponse = new WorkerIntModelReponse();
        //将得到的行数存入给消费者都数据对象
        workerIntModelReponse.setRow(row);
        //返回给业务消费者
        return ResultModel.success(workerIntModelReponse);
    }

    @Override
    public ResultModel<WorkerIntModelReponse> deleteWorkerById(WorkerModelRequest request) {
        //从数据库访问
        int row = workerService.deleteByPrimaryKey(request.getId());
        //创建返回结果对象
        WorkerIntModelReponse workerIntModelReponse = new WorkerIntModelReponse();
        workerIntModelReponse.setRow(row);
        //传递对象给业务消费者
        return ResultModel.success(workerIntModelReponse);
    }

    @Override
    public ResultModel<WorkerIntModelReponse> updateWorker(WorkerUpdateRequest request) {
        //创建收参对象
        WorkerPO workerPO = new WorkerPO();
        //将消费者传来的对象赋值给新创建的对象
        BeanUtils.copyProperties(request,workerPO);
        //从数据库取值
        int row = workerService.updateByPrimaryKeySelective(workerPO);
        //返回结果参数
        WorkerIntModelReponse workerIntModelReponse = new WorkerIntModelReponse();
        workerIntModelReponse.setRow(row);
        //返回参数给消费者
        return ResultModel.success(workerIntModelReponse);
    }


}
