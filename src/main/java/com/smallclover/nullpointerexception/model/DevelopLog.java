package com.smallclover.nullpointerexception.model;

import lombok.Data;

/**
 * 网站开发日志
 *
 * @author Amadeus
 * @date 2020-01-19
 */
@Data
public class DevelopLog {

    // 主键
    private long id;
    // 修复内容
    private String content;
    // 问题修复时间
    private String createTime;
    // bug类型
    private String bugType;
    // 修复者
    private String author;
}
