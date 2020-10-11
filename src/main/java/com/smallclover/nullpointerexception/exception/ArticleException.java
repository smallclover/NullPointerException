package com.smallclover.nullpointerexception.exception;

/**
 * 文章异常类
 * @Author: Amadeus
 * @Date: 2020/7/13 21:42
 */
public class ArticleException extends BaseException{

    public ArticleException(String message) {
        super(message);
    }

    public ArticleException(String message, Throwable cause) {
        super(message, cause);
    }
}
