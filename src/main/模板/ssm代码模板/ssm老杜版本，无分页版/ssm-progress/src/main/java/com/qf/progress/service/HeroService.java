package com.qf.progress.service;

import com.qf.progress.pojo.Hero;

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
