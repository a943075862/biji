package com.qf.test;

import com.qf.progress.dao.HeroDao;
import com.qf.progress.pojo.Hero;
import com.qf.progress.service.HeroService;
import com.qf.progress.service.impl.HeroServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class HeroTest {
    @Autowired
    private HeroDao heroDao;

    @Test
    public void getHero01(){
        Hero hero = heroDao.selectHeroById(1);
        System.out.println("hero = " + hero);
    }


    @Autowired
    private HeroService heroService;

    @Test
    public void getHero02(){
        List<Hero> heroes = heroService.queryHeros();
        for (Hero hero : heroes) {
            System.out.println("hero = " + hero);
        }
    }
    @Test
    public void getHero03Test(){
        Hero hero = new Hero(100,"张三爷",80,"中国","三爷");
        Integer integer = heroService.saveHero(hero);
        System.out.println("integer = " + integer);
    }
    @Test
    public void deleteHeroTest(){
        Integer integer = heroService.removeHero(8);
        System.out.println("integer = " + integer);
    }
    @Test
    public void updateHeroTest(){
        Hero hero = new Hero(20,"张三",90,"中国","三爷");
        for (int i = 5; i <=24; i++) {
            hero.setId(i);
            Integer integer = heroService.modifyHero(hero);
        }

//        System.out.println("integer = " + integer);
    }


}
