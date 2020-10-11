package com.smallclover.nullpointerexception.interceptor;

import com.smallclover.nullpointerexception.util.IPAddressUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/5/9 21:09
 */
@Component
@Slf4j
@AllArgsConstructor
public class BaseInterceptor implements HandlerInterceptor {

    // logback 具体的日志实现，与之同一个级别的，比如log4j
    // slf4j 日志的抽象框架，为不同的日志实现提供统一的抽象方法

    private static final String USER_AGENT = "User-Agent";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        // 返回的是完整的url，包括Http协议，端口号，servlet名字和映射路径，但它不包含请求参数。
        StringBuffer url = request.getRequestURL();


        String userAgent = request.getHeader(USER_AGENT);
        String address = IPAddressUtils.getIpAddress(request);

        // 记录访客日志
        log.info("User-Agent:{}", userAgent);
        log.info("User Access Url:{}",uri);
        log.info("Via IP Address:{}", address);
        log.info("Request Time:{}", LocalDateTime.now());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
