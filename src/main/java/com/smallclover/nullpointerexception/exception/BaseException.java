package com.smallclover.nullpointerexception.exception;

/**
 * 异常基础类
 * @Author: Amadeus
 * @Date: 2020/7/13 21:43
 */
public class BaseException extends RuntimeException{

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
