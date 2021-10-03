package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    /**
     * 传递数据--session---转发
     *      数据在转发过程可以共享
     *          session的生命周期是一次会话
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(HttpSession session, User user){
    session.setAttribute("user",user);
    System.out.println("SessionController=======getdata01======show02.jsp");
        return "forward:/show02.jsp";
    }

    /**
     * 传递数据--session---重定向
     *      数据在重定向过程可以共享
     *           session的生命周期是一次会话
     * @param session
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(HttpSession session, User user){
    session.setAttribute("user",user);
    System.out.println("SessionController=======getdata02======show02.jsp");
        return "redirect:/show02.jsp";
    }


}
