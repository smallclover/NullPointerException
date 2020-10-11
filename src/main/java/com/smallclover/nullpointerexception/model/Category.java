package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Amadeus
 * @Date: 2020/7/9 21:41
 */
@Data
public class Category {
    private long id;
    private String categoryName;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
    private boolean deleteFlag;
}
