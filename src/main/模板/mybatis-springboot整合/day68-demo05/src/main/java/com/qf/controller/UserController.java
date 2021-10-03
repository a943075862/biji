package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  11:52
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getInfo")
    public String getInfo(Model model){
        model.addAttribute("username","小宋");
        return "index";
    }

}
