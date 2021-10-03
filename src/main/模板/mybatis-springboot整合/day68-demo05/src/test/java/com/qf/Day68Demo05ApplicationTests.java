package com.qf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.HeroDao;
import com.qf.pojo.Hero;
import com.qf.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Day68Demo05ApplicationTests {

    @Autowired
    private HeroDao heroDao;
    @Autowired
    private HeroService heroService;

    @Test
    void getAll() {
        PageHelper.startPage(1,5);
        List<Hero> heroes = heroDao.selectAll();
        PageInfo<Hero> heroPageInfo = new PageInfo<>(heroes);
        for (Hero hero : heroPageInfo.getList()) {
            System.out.println("hero = " + hero);
        }
    }
    @Test
    void add(){
        Integer insert = heroDao.insert(new Hero());
        System.out.println("insert = " + insert);
    }
    @Test
    void delete(){
        Integer delete = heroDao.delete(17);
        System.out.println("delete = " + delete);
    }
    @Test
    void update(){
        Hero hero = new Hero();
        hero.setId(17);
        Integer update = heroDao.update(hero);
        System.out.println("update = " + update);
    }

    @Test
    void getById(){
        Hero hero = heroDao.selectOneById(1);
        System.out.println("hero = " + hero);
    }

    @Test
    void getAll2(){
        List<Hero> heroes = heroService.selectAll();
        for (Hero hero : heroes) {
            System.out.println("hero = " + hero);
        }
    }

}
