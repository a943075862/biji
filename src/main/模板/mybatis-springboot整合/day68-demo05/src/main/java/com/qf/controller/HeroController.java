package com.qf.controller;

import com.qf.pojo.Hero;
import com.qf.service.impl.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  15:02
 */
@Controller
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private HeroServiceImpl heroService;

    @RequestMapping("/show")
    public String showAll(Model model){
        List<Hero> heroes = heroService.selectAll();
        model.addAttribute("heros",heroes);
        return "hero";
    }

    @RequestMapping("/del")
    public String delById(Integer id,Model model){
        System.out.println("id = " + id);
        Integer delete = heroService.delete(id);
        return "forward:/hero/show";
    }
    @RequestMapping("/showById")
    public String showById(Integer id,Model model){
        System.out.println("id = " + id);
        Hero hero = heroService.selectOneById(id);
        model.addAttribute("hero",hero);
        return "hero-update";
    }

    @RequestMapping("/update")
    public String update(Hero hero,Model model){
        System.out.println("hero = " + hero);
        Integer update = heroService.update(hero);
        System.out.println("update = " + update);
        return "forward:/hero/show";
    }
    @RequestMapping("/insert")
    public String insert(Hero hero,Model model){
        System.out.println("hero = " + hero);
        Integer insert = heroService.insert(hero);
        System.out.println("insert = " + insert);
        return  "redirect:/hero/show";
    }
    @RequestMapping("/insert-show")
    public String insertShow(){

        return "hero-insert";
    }

}
