package com.smallclover.nullpointerexception.controller.common;

import com.smallclover.nullpointerexception.api.rep.ApiResponse;
import com.smallclover.nullpointerexception.exception.ArticleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * BaseException 处理
 * @Author: Amadeus
 * @Date: 2020/7/13 21:49
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionControllerAdvice {

    @ExceptionHandler(value = {ArticleException.class})
    public ApiResponse handleBaseException(HttpServletResponse response, RuntimeException e){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return ApiResponse.fail(400 , e.getMessage());
    }
}
