package com.qf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Hero;
import com.qf.service.impl.HeroServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SsmSpringBootDemo01ApplicationTests {

    @Autowired
    private HeroServiceImpl heroService;
    @Test
    void contextLoads() {
        PageHelper.startPage(1,5);
        List<Hero> heroes = heroService.queryHeros();
        PageInfo<Hero> heroPageInfo = new PageInfo<>(heroes);
        System.out.println("heroPageInfo = " + heroPageInfo);

    }

}
