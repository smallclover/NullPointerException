package com.smallclover.nullpointerexception.model;

import lombok.Data;

/**
 * 网站系统设置
 * @Author: Amadeus
 * @Date: 2020/5/24 12:44
 */
@Data
public class Setting {
    private long id;
    private String siteName;
    private String siteDesc;
    private String appVersion;
    private String github;
}
