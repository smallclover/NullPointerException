package com.smallclover.nullpointerexception.dto;

import lombok.Data;

/**
 * @Author: Amadeus
 * @Date: 2020/08/03 22:00
 */
@Data
public class SettingDto {
    private long id;
    private String appVersion;
    private String siteName;
    private String siteDesc;
    private String github;
}
