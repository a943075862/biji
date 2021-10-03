package com.qf.eureka.consumer.controller;

import pojo.Worker;
import com.qf.eureka.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  12:42
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/get/{id}")
    public String getWorker(@PathVariable Long id){
        return workerService.getWorker(id);
    }
    @GetMapping("/getForProject/{id}/{name}")
    public String getForProject(@PathVariable Long id,@PathVariable String name){
        return workerService.getForProject(id,name);
    }
    @PostMapping("/postget")
    public String postGet(@RequestBody Worker worker){
        return workerService.postGet(worker);
    }
    @PostMapping("/postgetWithCookie")
    public String postGetWithCookie(@RequestBody Worker worker, @CookieValue(name = "login_token") String cookie){
        return workerService.postGetWithCookie(worker,cookie);
    }
}
