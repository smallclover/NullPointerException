package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 附件实体类
 * @Author: Amadeus
 * @Date: 2020/5/13 21:06
 */
@Data
public class Attach {
    private long id;
    private String name;
    private String desc;
    private String fileType;
    private String storagePath;
    private boolean deleteFlag;
    private Timestamp uploadTime;
}
