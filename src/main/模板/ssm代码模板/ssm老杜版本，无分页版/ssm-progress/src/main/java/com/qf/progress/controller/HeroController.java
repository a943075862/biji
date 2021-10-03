package com.qf.progress.controller;

import com.qf.progress.pojo.Hero;
import com.qf.progress.service.impl.HeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    HeroServiceImpl heroService;

    @ResponseBody
    @RequestMapping("/heros/{id}")
    public Hero getHeroById(@PathVariable Integer id, Model model){
        Hero hero = heroService.queryHeroById(id);
        model.addAttribute("hero",hero);
        return hero;
    }

    @ResponseBody
    @RequestMapping("/heros")
    public ModelAndView getHeros(){
        List<Hero> heros = heroService.queryHeros();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("heros",heros);
        modelAndView.setViewName("forward:/showHeros.jsp");
        return modelAndView;
    }
    @ResponseBody
    @DeleteMapping("/heros/{id}")
    public String removeHero(@PathVariable Integer id){
        Integer row = heroService.removeHero(id);
        if (row>0){
            return "success";
        }
        return "false";
    }

    @ResponseBody
    @RequestMapping("/showById/{id}")
    public ModelAndView showById(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Hero hero = heroService.queryHeroById(id);
        modelAndView.addObject("hero",hero);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/update")
    public ModelAndView updayeHero(Hero hero){
        ModelAndView modelAndView = new ModelAndView();
        Integer integer = heroService.modifyHero(hero);
        if (integer>0){
            modelAndView.setViewName("redirect:/hero/heros");
        }else {
            modelAndView.addObject("hero",hero);
            modelAndView.setViewName("update");
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/save")
    public ModelAndView saveHero(Hero hero){
        ModelAndView modelAndView = new ModelAndView();
        Integer row = heroService.saveHero(hero);
        if (row>0){
            modelAndView.setViewName("redirect:/hero/heros");
        }else {
            modelAndView.setViewName("save");
        }
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/showById/{id}/{name}")
    public ModelAndView showById2(@PathVariable Integer id,@PathVariable String name){
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }





}
