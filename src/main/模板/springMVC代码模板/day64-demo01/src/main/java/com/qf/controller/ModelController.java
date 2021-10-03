package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Controller
@RequestMapping("/model")
@SessionAttributes({"city"})
public class ModelController {
    /**
     * model数据模型，可以存取数据====转发
     *      默认会把数据赋值也存入request域中
     *          * model数据模型，可以存取数据====转发
     *      默认会把数据赋值也存入request域中
     *  可以使用注解把特定的内容放到session中
     *  @SessionAttributes({"city"})
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData01")
    public String getData01(Model model, User user){
        Model user1 = model.addAttribute("user", user);
        System.out.println("user1 = " + user1);
        System.out.println("ModelController====getdata01=====show03.jsp");
        return "forward:/show03.jsp";
    }

    /**
     *  model数据模型，可以存取数据====重定向  拿不到数据
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData02")
    public String getData02(Model model, User user){
        Model user1 = model.addAttribute("user", user);
        System.out.println("user1 = " + user1);
        System.out.println("ModelController====getdata02=====show03.jsp");
        return "redirect:/show03.jsp";
    }

    /**
     *  转发
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData03")
    public String getData03(Model model, User user,String city,String area){
        System.out.println("ModelController====getdata03=====show04.jsp");
        model.addAttribute("user",user);
        model.addAttribute("city",city);
        model.addAttribute("area",area);

        return "forward:/show04.jsp";
    }

     /**
     *  重定向
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/getData04")
    public String getData04(Model model, User user,String city,String area){
        System.out.println("ModelController====getdata04=====show04.jsp");
        model.addAttribute("user",user);
        model.addAttribute("city",city);
        model.addAttribute("area",area);

        return "redirect:/show04.jsp";
    }

    /**
     * 显示数据
     * @return
     */
    @RequestMapping("/getData05")
    public String getData05(){
        System.out.println("ModelController====getdata05=====show04.jsp");
        return "forward:/show04.jsp";
    }


    /**
     * 清除数据
     * @return
     */
    @RequestMapping("/getData06")
    public String getData06(SessionStatus status){
        System.out.println("ModelController====getdata06=====show04.jsp");
        status.setComplete();
        boolean complete = status.isComplete();
        System.out.println("complete = " + complete);
        return "redirect:/show04.jsp";
    }



}
