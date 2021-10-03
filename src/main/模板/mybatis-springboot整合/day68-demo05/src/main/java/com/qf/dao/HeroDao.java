package com.qf.dao;

import com.qf.pojo.Hero;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  11:14
 */
@Repository
public interface HeroDao {
    List<Hero> selectAll();

    Integer insert(Hero hero);

    Integer update(Hero hero);

    Integer delete(Integer id);

    Hero selectOneById(Integer id);
}
