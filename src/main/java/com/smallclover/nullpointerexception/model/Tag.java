package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/7/2 22:23
 */
@Data
public class Tag {
    // 提示 从 3.4.5 开始，MyBatis 默认支持 JSR-310（日期和时间 API） 。
    private long id;
    private String tagName;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    private boolean deleteFlag;
}
