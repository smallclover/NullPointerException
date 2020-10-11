package com.smallclover.nullpointerexception.interceptor;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import com.smallclover.nullpointerexception.dto.SiteAccessDto;
import com.smallclover.nullpointerexception.service.visit.VisitService;
import com.smallclover.nullpointerexception.util.IPAddressUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/6/9 20:57
 */
@Component
@Slf4j
@AllArgsConstructor
public class AccessRecordInterceptor implements HandlerInterceptor {

    private VisitService visitService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //TODO 改进redis存储的格式
        String userAgent = request.getHeader("User-Agent");
        String ip = IPAddressUtils.getIpAddress(request);
        String uri = request.getRequestURI();
        LocalDateTime today = LocalDateTime.now();
        var siteAccessDto = new SiteAccessDto(ip, uri, today);
        visitService.addVisitRecord(siteAccessDto);
        return true;
    }

}
