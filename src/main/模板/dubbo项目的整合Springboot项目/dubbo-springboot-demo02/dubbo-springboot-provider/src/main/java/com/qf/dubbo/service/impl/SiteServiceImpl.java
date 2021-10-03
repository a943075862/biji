package com.qf.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dubbo.pojo.Site;
import com.qf.dubbo.service.SiteService;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/12  17:21
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Override
    public Site getSite(Long id) {
        Site site = new Site();
        site.setId(id);
        return site;
    }
}
