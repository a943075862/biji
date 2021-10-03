package com.qf.intertroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 模拟身份验证
 */
@Controller
@RequestMapping("/inter01")
@SessionAttributes({"isLogin"})
public class InterController01 {
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("isLogin",true);
        System.out.println("登录成功。。。。");
        return "redirect:/index.jsp";
    }
    @RequestMapping("/index")
    public String index(Model model){
        System.out.println("试图访问主页");
        Object isLogin = model.asMap().get("isLogin");
        if (isLogin!=null){
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
    @RequestMapping("/info")
    public String info(Model model){
        System.out.println("试图访问主页");
        Object isLogin = model.asMap().get("isLogin");
        if (isLogin!=null){
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }@RequestMapping("/menu")
    public String menu(Model model){
        System.out.println("试图访问主页");
        Object isLogin = model.asMap().get("isLogin");
        if (isLogin!=null){
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
