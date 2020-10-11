package com.smallclover.nullpointerexception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallclover.nullpointerexception.constant.ResponseStatusCode;
import com.smallclover.nullpointerexception.api.rep.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 * @Author: Amadeus
 * @Date: 2020/6/19 22:35
 */
@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ApiResponse apiResponse;
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException){
            apiResponse = ApiResponse.fail(ResponseStatusCode.USER_UNAUTHORIZED.getCode(),
                    ResponseStatusCode.USER_UNAUTHORIZED.getDesc());
        }else{
            apiResponse = ApiResponse.fail(ResponseStatusCode.OTHERS.getCode(), ResponseStatusCode.OTHERS.getDesc());
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
