package com.smallclover.nullpointerexception.dto;

import lombok.Data;

/**
 * 访问统计
 * @Author: Amadeus
 * @Date: 2020/6/3 21:18
 */
@Data
public class VisitReqDto {

    // 应用区分
    private String app;
    // 访问者ip
    private String ip;
    // 访问的uri
    private String uri;
}
