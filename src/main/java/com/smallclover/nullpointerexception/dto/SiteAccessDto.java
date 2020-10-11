package com.smallclover.nullpointerexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/07/28 21:40
 */
@Data
@AllArgsConstructor
public class SiteAccessDto {
    // 访问者ip
    private String ip;
    // 访问地址
    private String url;
    // 请求时间
    private LocalDateTime date;
}
