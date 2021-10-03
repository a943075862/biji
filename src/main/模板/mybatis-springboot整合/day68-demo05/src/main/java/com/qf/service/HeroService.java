package com.qf.service;

import com.qf.pojo.Hero;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  14:17
 */
public interface HeroService {
    List<Hero> selectAll();

    Integer insert(Hero hero);

    Integer update(Hero hero);

    Integer delete(Integer id);

    Hero selectOneById(Integer id);
}
