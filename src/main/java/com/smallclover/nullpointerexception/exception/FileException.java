package com.smallclover.nullpointerexception.exception;

/**
 * 文件相关异常
 * @Author: Amadeus
 * @Date: 2020/5/10 17:57
 */
public class FileException extends BaseException {

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}
