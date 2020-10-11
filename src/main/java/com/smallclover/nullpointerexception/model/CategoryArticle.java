package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/7/11 16:37
 */
@Data
public class CategoryArticle {
    private long id;
    private long categoryId;
    private long articleId;
    private LocalDateTime createTime;
    private boolean deleteFlag;
}
