package com.smallclover.nullpointerexception.model;

import lombok.Data;

/**
 * 图片实体类
 * @author Amadeus
 * @date 2020-02-02
 */
@Data
public class Image {
    // 名字
    private String name;
    // 作者
    private String author;
    // 文字描述
    private String description;
    // 经度（35°57′64″）
    private String longitude;
    // 纬度（35°57′64″）
    private String latitude;
    // 经度转化为十进制数（35.12345）
    private String longitudeDecimal;
    // 纬度转化为十进制数（35.12345）
    private String latitudeDecimal;
    // 拍摄时间
    private String createTime;
}
