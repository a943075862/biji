package com.qf.dao;

import com.qf.pojo.Hero;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

/**
 * heroDao
 */
@Repository
public interface HeroDao {
    //添加
    Integer insertHero(Hero hero);

    Integer deleteHero(Integer id);

    Integer updateHero(Hero hero);

    Hero selectHeroById(Integer id);

    List<Hero> selectHeros();

}
