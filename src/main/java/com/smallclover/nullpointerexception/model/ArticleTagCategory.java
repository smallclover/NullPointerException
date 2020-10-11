package com.smallclover.nullpointerexception.model;

import lombok.Data;

/**
 * @Author: Amadeus
 * @Date: 2020/7/12 20:05
 */
@Data
public class ArticleTagCategory {

    private long articleId;
    private long tagId;
    private long categoryId;
    private String tagName;
    private String categoryName;
}
