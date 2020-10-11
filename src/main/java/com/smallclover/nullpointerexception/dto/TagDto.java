package com.smallclover.nullpointerexception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签DTO
 * @Author: Amadeus
 * @Date: 2020/6/24 21:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {
    // 标签名
    private String word;
    // 该标签的数量
    private int count;
}
