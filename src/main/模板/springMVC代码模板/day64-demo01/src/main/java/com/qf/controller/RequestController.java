package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Controller
@RequestMapping("/req")
public class RequestController {
    /**
     * 传递数据--request---转发
     *      数据在转发过程可以共享
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(HttpServletRequest request, User user){
        request.setAttribute("user",user);
        System.out.println("RequestController=======getdata01======show01.jsp");
        return "forward:/show01.jsp";
    }

    /**
     * 传递数据--request --重定向
     *      数据在重定向过程中不可以共享
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(HttpServletRequest request, User user){
        request.setAttribute("user",user);
        System.out.println("RequestController=======getdata02======show01.jsp");
        return "redirect:/show01.jsp";
    }




}
