package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/23  9:35
 */
@Controller
@RequestMapping("/test1")
public class TestController {
    @ResponseBody
    @RequestMapping("/get01")
    public String test01(){

        return "hello world";
    }
}
