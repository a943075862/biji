package com.qf.service;

import com.qf.pojo.Hero;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

/**
 * HeroService
 */
public interface HeroService {

    Integer saveHero(Hero hero);

    Integer removeHero(Integer id);

    Integer modifyHero(Hero hero);

    Hero queryHeroById(Integer id);

    List<Hero> queryHeros();
}
