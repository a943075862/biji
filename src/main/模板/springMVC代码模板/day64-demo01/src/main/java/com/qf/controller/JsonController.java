package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.pojo.User;
import com.qf.pojo.User2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@RestController
@RequestMapping("/json")
public class JsonController {
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

    /**
     * 上面是之前一天讲的
     * @return
     */
    /**
     *
     * @return
     */
    @RequestMapping("/getJson05")
      public User getJson05(){
          User user = new User(1001,"zhangsan","sanzhang",new Date());
          return user;
      }

      @RequestMapping("/getJson06")
      public String getJson06(@RequestBody User user){
//          User user = new User(1001,"zhangsan","sanzhang",new Date());
          System.out.println("user = " + user);
          String string = JSON.toJSONString("success");
          return string;
      }

    @RequestMapping("/getJson07")
    public User2 getJson07(){
        User2 user2 = new User2();
        user2.setId(12355);
        user2.setUsername("lsidid");
        user2.setHobby(new ArrayList<>());
        return user2;
    }
    @RequestMapping("/getJson08")
    public User2 getJson08(){
        User2 user2 = new User2();
        user2.setId(12355);
        user2.setSalary(251.21578);
        user2.setUsername("lsidid");
        return user2;
    }

    





}
