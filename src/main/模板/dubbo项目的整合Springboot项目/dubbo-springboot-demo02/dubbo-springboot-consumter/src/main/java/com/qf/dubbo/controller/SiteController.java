package com.qf.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.dubbo.pojo.Site;
import com.qf.dubbo.service.SiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/12  17:28
 */
@RestController
@RequestMapping("/site")
public class SiteController {
    @Reference
    private SiteService siteService;

    @GetMapping("/select/{id}")
    public Site getSite(@PathVariable Long id){
        Site site = siteService.getSite(id);
        return site;
    }
}
