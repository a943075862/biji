package com.qf.eureka.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import pojo.Worker;
import com.qf.eureka.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  12:43
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "getWorker1")
    @Override
    public String getWorker(Long id) {
        String url="http://WORKER-PROVIDER/worker/get/"+id;;
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
    public String getWorker1(Long id) {
        return "网络异常";
    }

    @Override
    public String getForProject(Long id,String name) {
        //方法1
        /*String url ="http://WORKER-PROVIDER/worker/getForProject?id="+id+"&name="+name;
        return restTemplate.getForObject(url,String.class);*/
        //方法2
        /*String url ="http://WORKER-PROVIDER/worker/getForProject?id={1}&name={2}";
        return restTemplate.getForObject(url,String.class,new Object[]{id,name});*/
        //方法3
       /* String url ="http://WORKER-PROVIDER/worker/getForProject?id={id}&name={name}“";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        return restTemplate.getForObject(url,String.class,map);*/
       //方法4getentity
        String url ="http://WORKER-PROVIDER/worker/getForProject?id={id}&name={name}“";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, map);
        System.out.println("forEntity = " + forEntity);
        return forEntity.getBody();
    }

    @Override
    public String postGet(Worker worker) {
        //方法1
        /*String url ="http://WORKER-PROVIDER/worker/postget";
        ResponseEntity<String> result = restTemplate.postForEntity(url, worker, String.class);*/
        //方法2
        String url ="http://WORKER-PROVIDER/worker/postget";
       /* LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
         map.add("id",worker.getId());
         map.add("name",worker.getName());
        map.add("worker",worker);*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(worker,headers);
        ResponseEntity<String> result = restTemplate.postForEntity(url, entity, String.class);
        return result.getBody();
    }

    @Override
    public String postGetWithCookie(Worker worker, String cookie) {
        String url ="http://WORKER-PROVIDER/worker/postgetWithCookie";
        ArrayList<String> list = new ArrayList<>();
        list.add("login_token="+cookie);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.put("cookie",list);
        HttpEntity httpEntity = new HttpEntity(worker,headers);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        return stringResponseEntity.getBody();
    }


}
