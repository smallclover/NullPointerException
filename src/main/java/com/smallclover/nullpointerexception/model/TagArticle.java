package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/7/11 16:37
 */
@Data
public class TagArticle {
    private long id;
    private long tagId;
    private long articleId;
    private LocalDateTime createTime;
    private boolean deleteFlag;
}
