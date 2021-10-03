package com.qf.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  16:57
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hello")
    @Secured({"ROLE_student"})
    public String hello(){

        return "hello Springecurity";
    }

}
