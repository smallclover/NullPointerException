package com.smallclover.nullpointerexception.api.rep;


import com.smallclover.nullpointerexception.constant.ResponseStatusCode;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;

/**
 * api响应结果
 * @Author: Amadeus
 * @Date: 2020/6/20 9:21
 */
@Data
public class ApiResponse<T> {
    /**
     * 响应码
     */
    private int code;
    /**
     * 响应消息内容
      */
    private String message;

    /**
     * 响应数据(T指定类型的数据)
     */
    private T data;

    public static ApiResponse fail(ResponseStatusCode responseStatusCode){
        return new ApiResponse(responseStatusCode.getCode(), responseStatusCode.getDesc(), null);
    }
    public static <T> ApiResponse fail(ResponseStatusCode responseStatusCode, T data){
        return new ApiResponse(responseStatusCode.getCode(), responseStatusCode.getDesc(), data);
    }

    public static <T> ApiResponse fail(int code, String message, T data){
        // HttpStatus
        return new ApiResponse(code, message, data);
    }

    public static ApiResponse fail(int code, String message){
        // HttpStatus
        return new ApiResponse(code, message, null);
    }

    /**
     * 响应成功使用默认的状态码和消息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ApiResponse ok(T data){
        return new ApiResponse(ResponseStatusCode.SUCCESS.getCode(), ResponseStatusCode.SUCCESS.getDesc(), data);
    }
    /**
     * 响应成功使用默认的状态码和消息,没有数据体
     * @return
     */
    public static ApiResponse ok(){
        return new ApiResponse(ResponseStatusCode.SUCCESS.getCode(), ResponseStatusCode.SUCCESS.getDesc(), null);
    }

    /**
     * 响应成功，但是自定义状态码和响应消息
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ApiResponse ok(int code, String message, T data){
        return new ApiResponse(ResponseStatusCode.SUCCESS.getCode(), ResponseStatusCode.SUCCESS.getDesc(), data);
    }


    private ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
