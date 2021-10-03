package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Hero;
import com.qf.service.impl.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */
@RequestMapping("/hero")
@Controller
public class HeroController {
    @Autowired
    private HeroServiceImpl heroService;

    @RequestMapping("/show")
    public String showAll(@RequestParam(defaultValue = "1")Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Hero> heroes = heroService.queryHeros();
        PageInfo<Hero> pageInfo = new PageInfo<>(heroes);
        System.out.println("pageInfo = " + pageInfo);
        model.addAttribute("heros",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "show";
    }

    @RequestMapping("/delete")
    public String delById(Integer id,Model model){
        System.out.println("id = " + id);
        Integer delete = heroService.removeHero(id);
        return "redirect:/hero/show";
    }
    @RequestMapping("/showById")
    public String showById(Integer id,Model model){
        System.out.println("id = " + id);
        Hero hero = heroService.queryHeroById(id);
        model.addAttribute("hero",hero);
        return "hero-update";
    }

    @RequestMapping("/update")
    public String update(Hero hero,Model model){
        System.out.println("hero = " + hero);
        Integer forceValue = hero.getForceValue();
        if (forceValue==null){
            hero.setForceValue(0);
        }
        Integer update = heroService.modifyHero(hero);
        System.out.println("update = " + update);
        return "redirect:/hero/show";
    }
    @RequestMapping("/insert")
    public String insert(Hero hero,Model model){
        System.out.println("hero = " + hero);
        Integer forceValue = hero.getForceValue();
        if (forceValue==null){
            hero.setForceValue(0);
        }
        Integer insert = heroService.saveHero(hero);
        System.out.println("insert = " + insert);
        return  "redirect:/hero/show";
    }
    @RequestMapping("/insert-show")
    public String insertShow(){
        return "hero-insert";
    }

}
