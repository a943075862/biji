package com.qf.bigdata.view.web.controller.api;

import com.qf.bigdata.view.web.service.WorkerService;
import com.qf.data.view.core.model.exception.ViewException;
import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerSelectRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:05
 */
@RestController
@RequestMapping("/worker")
public class WorkerAPIController {
    //调用业务对象
   @Autowired
    private WorkerService workerService;

    @PostMapping("/get")
    public ResultModel<WorkerResponse> getWorkerById(@RequestBody WorkerSelectRequest request){
        try {
            //兜底，判断传入值是否为空
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                //抛出错误
                throw new ViewException("参数有误");
            }
        } catch (ViewException e) {
            //捕捉错误，传给前端
            return ResultModel.error(e.getMessage());
        }
        //调用业务，获取结果对象，传回前端
        ResultModel<WorkerResponse> workerById = workerService.getWorkerById(request.getId());
        return workerById;
    }
    @GetMapping("/getAll")
    public ResultModel<List<WorkerResponse>> getWorkers(){
        //无需收参，直接返回结果
        try {
            //调用业务，得到结果对象，传给前端
            ResultModel<List<WorkerResponse>> workers = workerService.getWorkerAll();
            return workers;
        } catch (Exception e) {
            return ResultModel.error("服务器异常");
        }
    }
    @PostMapping("/insert")
    public ResultModel insertWorker(@RequestBody WorkerInsertRequest request){
        try {
            //兜底，判断传入值是否为空
            if (Objects.isNull(request)){
                //抛出错误
                throw new ViewException("参数错误");
            }
        } catch (ViewException e) {
            //捕捉错误，传给前端
            return ResultModel.error(e.getMessage());
        }
        //调用业务查到结果对象
        ResultModel<WorkerIntModelReponse> row =workerService.insertWorker(request);
        //判断修改行数
        if (row.getData().getRow()!=0){
            return ResultModel.success("添加成功");
        }else {
            //未修改成功，返回错误状态给前端
            return ResultModel.error("添加失败，请检查重试");
        }
    }

    @PostMapping("/delete")
    public ResultModel deleteWorkerById(@RequestBody WorkerModelRequest request){
        try {
            //兜底，判断传入值是否为空
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                //抛出错误
                throw new ViewException("参数错误");
            }
        } catch (ViewException e) {
            //返回错误信息
            return ResultModel.error(e.getMessage());
        }
        //从提供者获取服务
        ResultModel<WorkerIntModelReponse> row=workerService.deleteWorkerById(request.getId());
        //判断最后修改的行数
        if (row.getData().getRow()!=0){
            //传递成功状态给前端
            return ResultModel.success("删除成功");
        }else {
            //传递错误状态给前端
            return ResultModel.error("删除失败，请检查重试");
        }
    }

    /**
     * 修改工人信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    public ResultModel updateWorker(@RequestBody WorkerUpdateRequest request){
        try {
            //兜底，判断传入值是否为空
            if (Objects.isNull(request)||Objects.isNull(request.getId())){
                //抛出错误
                throw new ViewException("参数设置错误");
            }
        } catch (ViewException e) {
            //捕捉错误，传给前端
            return ResultModel.error(e.getMessage());
        }
        //从提供者获取服务
        ResultModel<WorkerIntModelReponse> row=workerService.updateWorker(request);
        if (row.getData().getRow()!=0){
            //传递成功状态给前端
            return ResultModel.success("修改成功");
        }else {
            //传递错误状态给前端
            return ResultModel.error("修改失败，请检查重试");
        }
    }


}
