package com.smallclover.nullpointerexception.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * 文章DTO
 * @author Amadeus
 * @date 2020-05-04
 */
@Data
public class ArticleDto {
    // id
    private long id;
    // 标题
    @NotBlank(message = "标题不能为空")
    private String title;
    // 描述
    @NotBlank(message = "描述不能为空")
    private String desc;
    // html内容
    @NotBlank(message = "内容不能为空")
    private String htmlContent;
    // markdown 内容
    @NotBlank(message = "内容不能为空")
    private String mdContent;
    // 分类
    @NotBlank(message = "分类不能为空")
    private String category;
    // 标签
    @NotBlank(message = "标签不能为空")
    private String tags;
    // 文章浏览量(点击量)
    private int contentView;
    // 是否开启评论
    private boolean comment;
    // 是否是草稿
    private boolean status;
    // 是否发布
    private boolean publish;
    // 文章创建时间
    private Timestamp createTime;
    // 删除标志
    private boolean deleteFlag;
}
