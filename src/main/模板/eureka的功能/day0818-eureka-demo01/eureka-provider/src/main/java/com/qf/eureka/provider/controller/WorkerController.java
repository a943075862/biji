package com.qf.eureka.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  12:30
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Value("${server.port}")
    private String servicePort;

    @RequestMapping("/get/{id}")
    public String getWorker(@PathVariable Long id) throws InterruptedException {
      /*  if (id!=null){
            throw new RuntimeException("测试熔断器");
        }*/
//      Thread.sleep(2000);
        return "servicePort:"+servicePort+",worker"+id;
    }
    @RequestMapping("/getForProject")
    public String getForProject(Long id,String name){
        return String.format("id: %d ,name: %s",id,name);
    }

    @PostMapping("/postget")
    public String postget(@RequestBody Worker worker){
        return String.format("id: %d ,name: %s",worker.getId(),worker.getName());
    }

    @PostMapping("/postgetWithCookie")
    public String postGetWithCookie(@RequestBody Worker worker, @CookieValue(name = "login_token") String cookie){
        return String.format("id: %d ,name: %s cookie: %s",worker.getId(),worker.getName(),cookie);
    }
    @PostMapping("/postgetWithCookie1")
    public String postGetWithCookie1(@RequestBody Worker worker, @CookieValue(name = "login_token",required = false) String cookie){
        return String.format("id: %d ,name: %s cookie: %s ",worker.getId(),worker.getName(),cookie);
    }


}
