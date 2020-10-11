package com.smallclover.nullpointerexception.service.site;

import com.smallclover.nullpointerexception.dto.StatisticDto;

/**
 * @author Amadeus
 * @date 2020-01-19
 * 获取网站相关的信息
 */
public interface SiteService {

    /**
     * 获取网站后台统计数据
     * @return 统计数据实体类
     */
    StatisticDto getStatistics();
}
