package com.qf.controller;

import com.qf.dao.HeroDao;
import com.qf.pojo.Hero;
import com.qf.service.impl.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  14:26
 */
@Controller
@RequestMapping("hi")
public class ThymeleafController {
    @Autowired
    private HeroServiceImpl heroService;
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("user","zhangsan");
        model.addAttribute("age",18);
        model.addAttribute("msg","<h3>这是一个标签</h3>");
        model.addAttribute("now",new Date());
        return "success";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Hero> heroes = heroService.selectAll();
        model.addAttribute("heros",heroes);
        return "hero-list";
    }
    @RequestMapping("/del")
    public String del(Integer id){
        System.out.println("id = " + id);
        return "hero-list";
    }

}
