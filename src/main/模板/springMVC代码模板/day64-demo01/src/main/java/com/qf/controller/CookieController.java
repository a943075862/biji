package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */

/**
 * cookie传对象
 */
@Controller
@RequestMapping("/cook")
public class CookieController {
    @RequestMapping("/getData01")
    public String getData01(HttpServletRequest request, HttpServletResponse response){
        //创建两个cookie对象
        Cookie cookie01 = new Cookie("username","lisi");
        Cookie cookie02 = new Cookie("password","sili");
        System.out.println("CookieController====getdata01=====show05.jsp");
        //将cookie对象存入到域对象中
        response.addCookie(cookie01);
        response.addCookie(cookie02);
        //转发到前端
        return "forward:/show05.jsp";

    }
    @RequestMapping("/getData02")
    public String getData02(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName()+"======="+cookie.getValue());
        }
        return "forward:/show05.jsp";

    }

}
