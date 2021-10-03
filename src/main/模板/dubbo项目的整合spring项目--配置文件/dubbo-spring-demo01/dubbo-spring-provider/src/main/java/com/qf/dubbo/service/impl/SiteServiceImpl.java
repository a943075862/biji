package com.qf.dubbo.service.impl;

import com.qf.dubbo.pojo.Site;
import com.qf.dubbo.service.SiteService;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/12  16:40
 */
public class SiteServiceImpl implements SiteService {
    @Override
    public Site getSite(Long id) {
        Site site = new Site();
        site.setId(id);
        site.setName("工地1");
        return site;
    }

}
