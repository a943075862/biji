package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

/**
 * 测试默认是转发还是重定向
 *         默认是转发
 */
@Controller
@RequestMapping("/test01")
public class TestController {
    @RequestMapping("/test01")
    public String getTest(){
        return "redirect:/test02/test01";
    }
}
