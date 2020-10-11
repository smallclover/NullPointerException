package com.smallclover.nullpointerexception.dto;

import lombok.Data;

/**
 * @author Amadeus
 * @date 2020-01-19
 * 后台统计数据DTO
 */
@Data
public class StatisticDto {

    // 已经发表的文章总数
    private long articles;
    // 评论总数
    private long comments;
    // 友链总数
    private long developLogs;
    // 已经上传的附件总数
    private long attaches;

}
