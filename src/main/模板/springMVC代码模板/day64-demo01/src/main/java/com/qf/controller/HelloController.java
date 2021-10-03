package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hi")
    public String hi(){
        System.out.println("hello====>hi");
        return "index";
    }
    @RequestMapping("/hi02")
    public String hi02(Integer id,String name){
        System.out.println("hello====>hi02");
        System.out.println("id = " + id);
        System.out.println("name = " + name);

        return "forward:/index.jsp";
    }
    @RequestMapping("/hi03")
    public String hi03(Integer id,String name){
        System.out.println("hello====>hi03");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "redirect:/index.jsp";
    }




}
