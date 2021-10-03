package com.qf.service.impl;

import com.qf.dao.HeroDao;
import com.qf.pojo.Hero;
import com.qf.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  14:18
 */
@Service
public class HeroServiceImpl  implements HeroService {
    @Autowired
    private HeroDao heroDao;
    @Override
    public List<Hero> selectAll() {
        return   heroDao.selectAll();
    }

    @Override
    public Integer insert(Hero hero) {

        return  heroDao.insert(hero);
    }

    @Override
    public Integer update(Hero hero) {
        return heroDao.update(hero);
    }

    @Override
    public Integer delete(Integer id) {
        return heroDao.delete(id);
    }

    @Override
    public Hero selectOneById(Integer id) {
        return heroDao.selectOneById(id);
    }
}
