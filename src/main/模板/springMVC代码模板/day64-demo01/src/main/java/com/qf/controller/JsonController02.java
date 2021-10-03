package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */

@RequestMapping("/json02")
@RestController
public class JsonController02 {
    /**
     * {key:value,key:value}
     * [{},
     * {},
     * {}]
     *  fastjson    阿里巴巴
     *  jackson     springmvc 默认使用
     */
      @RequestMapping("/getJson01")
    public User getJson01(){
          User user = new User(1002,"李贵","xiaokuikui",new Date());
           return user;
      }

      @RequestMapping(value = "/getJson02",produces = "text/html;charset=utf-8")
    public String getJson02(){
          User user = new User(1002,"李贵","xiaokuikui",new Date());
           return "静夜思";
      }

      @RequestMapping(value = "/getJson03",produces = "text/html;charset=utf-8")
    public String getJson03(){
          User user = new User(1002,"李贵","xiaokuikui",new Date());
           return "静夜思";  // /静夜思.jsp
      }

    @RequestMapping(value = "/getJson04")
    public User getJson04(@RequestBody User user){
         user.setUsername("李四");
         user.setPassword("sili");
           return user;
      }






}
