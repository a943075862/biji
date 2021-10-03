package com.qf.progress.service.impl;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

import com.qf.progress.dao.HeroDao;
import com.qf.progress.pojo.Hero;
import com.qf.progress.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * HeroServiceImpl
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroDao heroDao;

    @Override
    public Integer saveHero(Hero hero) {
        Integer row = heroDao.insertHero(hero);
        return row;
    }

    @Override
    @Transactional
    public Integer removeHero(Integer id) {
        Integer row = heroDao.deleteHero(id);
//        System.out.println(10/0);
        return row;
    }

    @Override
    public Integer modifyHero(Hero hero) {
        Integer row = heroDao.updateHero(hero);
        return row;
    }

    @Override
    public Hero queryHeroById(Integer id) {
        Hero hero = heroDao.selectHeroById(id);
        return hero;
    }

    @Override
    public List<Hero> queryHeros() {
        List<Hero> heroes = heroDao.selectHeros();
        return heroes;
    }
}
