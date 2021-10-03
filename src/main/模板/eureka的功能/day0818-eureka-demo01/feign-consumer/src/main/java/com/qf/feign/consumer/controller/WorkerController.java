package com.qf.feign.consumer.controller;

import com.qf.feign.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  18:09
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @RequestMapping("/get/{id}")
    public String get(@PathVariable Long id){
        return workerService.getWorker(id);
    }

    @RequestMapping("/postgetWithCookie1")
    public String postgetWithCookie1(@RequestBody Worker worker,@CookieValue(name = "login_token",required = false)String token){
        return workerService.postgetWithCookie1(worker)+token;
    }

}
