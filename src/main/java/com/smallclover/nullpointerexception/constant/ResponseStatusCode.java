package com.smallclover.nullpointerexception.constant;


/**
 * 响应状态码
 * @Author: Amadeus
 * @Date: 2020/6/20 9:35
 */
public enum ResponseStatusCode {
    SUCCESS(200, "SUCCESS"),
    FAILURE(400, "FAILURE"),
    USER_UNAUTHORIZED(402, "用户名或密码不正确"),
    NOT_FOUND(404, "请求资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    OTHERS(666, "未知错误");

    private int code;
    private String desc;

    ResponseStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
