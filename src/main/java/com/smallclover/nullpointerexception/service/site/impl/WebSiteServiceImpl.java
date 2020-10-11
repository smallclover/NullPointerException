package com.smallclover.nullpointerexception.service.site.impl;

import com.smallclover.nullpointerexception.config.WebSiteConfig;
import com.smallclover.nullpointerexception.mapper.WebSiteMapper;
import com.smallclover.nullpointerexception.service.site.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amadeus
 * @date 2019-12-07
 * 获取网站基本信息实现类
 */
@Service
public class WebSiteServiceImpl implements WebSiteService {

    private WebSiteMapper webSiteMapper;

    @Autowired
    public void setWebSiteMapper(WebSiteMapper webSiteMapper) {

        this.webSiteMapper = webSiteMapper;
    }

    @Override
    public WebSiteConfig getWebSiteConfig() {
        return webSiteMapper.getWebSiteConfig();
    }
}
