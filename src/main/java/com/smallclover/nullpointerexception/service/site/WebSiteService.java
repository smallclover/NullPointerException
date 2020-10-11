package com.smallclover.nullpointerexception.service.site;

import com.smallclover.nullpointerexception.config.WebSiteConfig;

import java.util.List;

/**
 * @author Amadeus
 * @date 2019-12-07
 * 网站基本信息操作类
 */
public interface WebSiteService {
    /**
     * 获取网站基本信息
     * @return
     */
    WebSiteConfig getWebSiteConfig();
}
