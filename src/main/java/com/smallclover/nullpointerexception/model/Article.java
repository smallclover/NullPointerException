package com.smallclover.nullpointerexception.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文章实体类
 * @author Amadeus
 * @date 2019-11-25
 */
@Data
public class Article implements Serializable {
    // 主键
    private Long id;
    // 标题
    private String title;
    // 文章的简单描述
    private String desc;
    // 文章内容(markdown)
    private String mdContent;
    // 文章内容(html)
    private String htmlContent;
    // 文章创建时间
    private Timestamp createTime;
    // 文章浏览量(点击量)
    private int contentView;
    // 是否开启评论
    private boolean comment;
    // 是否是草稿
    private boolean status;
    // 是否发布
    private boolean publish;
    // 删除标志
    private boolean deleteFlag;
}
/*
异常:Cannot serialize; nested exception is
org.springframework.core.serializer.support.SerializationFailedException:Failed
to serialize object using DefaultSerializer; nested exception is
java.io.NotSerializableException: xxx
解决方案:class xxx implements Serializable

 */