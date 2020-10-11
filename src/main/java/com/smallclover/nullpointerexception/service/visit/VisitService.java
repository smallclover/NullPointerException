package com.smallclover.nullpointerexception.service.visit;


import com.smallclover.nullpointerexception.dto.SiteAccessDto;
import com.smallclover.nullpointerexception.dto.UserAgentDto;

/**
 * 访客记录
 * @Author: Amadeus
 * @Date: 2020/6/3 21:34
 */
public interface VisitService {

    void addVisitRecord(SiteAccessDto siteAccessDto);
    UserAgentDto getUserAgent(String userAgent);
}
