package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  8:18
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/login")
    public String login(){
        return "redirect:/templates/index.html";
    }

}
