package com.smallclover.nullpointerexception.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Amadeus
 * @date 2019-12-07
 * 网站信息配置类
 */
//@Component
//@PropertySource("classpath:/config/website-config.properties")
//@ConfigurationProperties("website")
@Data
public class WebSiteConfig {

    // 网站名称
    private String name;
    // 网站描述
    private String desc;
    // 网站logo
    private String logo;
    // 网站图标
    private String icon;
    // 网站相关
    private String about;
    // 网站备案信息
    private String icp;
    // 网站copyright
    private String copyright;
    // 网站基于
    private String poweredBy;
    // 网站基于Url
    private String poweredByUrl;
    
}
