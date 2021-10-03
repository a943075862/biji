package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

@Controller
@RequestMapping("/origin")
@CrossOrigin({"http://127.0.0.1:8899","http://localhost:8899"})
public class OriginController {

    @RequestMapping("/getData01")
    public String getData01(){
        System.out.println("OriginController ==> getData01...");
        return "index";
    }

    @RequestMapping("/getData02")
    public String getData02(HttpSession session, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.println("OriginController ==> getData02...");
        session.setAttribute("data","Hello Origin");
        return "index";
    }

    @RequestMapping("/getData03")
    public String getData03(HttpSession session,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Credentials","true");
        System.out.println("OriginController ==> getData03...");
        Object data = session.getAttribute("data");
        System.out.println("data==>" + data);
        return "index";
    }
}
