package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 旅行日志实体类
 * @Author: Amadeus
 * @Date: 2020/5/14 17:27
 */
@Data
public class Journey {
    private long id;
    // 经度longitude
    private String longitude;
    // 纬度latitude
    private String latitude;
    // 拍摄时间
    private String makeTime;
    // 描述
    private String desc;
    // 图片地址
    private String picPath;
    // 图片标题
    private String title;
    // 删除flag
    private boolean deleteFlag;
}
