package com.qf.controller;

import com.qf.pojo.User3;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@RestController
@RequestMapping("/json03")
public class JsonController03 {
    /**
     * {key:value,key:value}
     * [{},
     * {},
     * {}]
     *  fastjson    阿里巴巴
     *  jackson     springmvc 默认使用
     */
    /**
     * 使用fastjson获取值
     * @return
     */
      @RequestMapping("/getJson01")
    public User3 getJson01(){
          User3 user3 = new User3();
          user3.setId(1021);
          user3.setUsername("zhangsan");
          user3.setPassword("sanzhang");
          user3.setSalary(1021.21215);
          user3.setRegisterTime(new Date());
          return user3;
      }





}
