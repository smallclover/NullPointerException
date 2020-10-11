package com.smallclover.nullpointerexception.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 评论实体类
 * @author Amadeus
 * @date 2019-11-25
 */
@Data
public class Comment implements Serializable {
    // 主键
    private long id;

    // 评论内容
    //@NotBlank//非空且字符串长度必须大于0 不可以是whitespace
    //@NotEmpty//非空且字符串长度必须大于0 可以是whitespace
    private String content;
    // 评论的文章Id
    //@NotNull
    private long articleId;
    // 评论是否通过审核
    private boolean passAudit;
    // 评论者id
    private String userId;
    // 评论者昵称
    //@NotBlank
    private String nickname;
    // 邮箱
    //@Email
    private String email;
    // 评论所属的一级评论id
    private String commentParentId;
    // 回复者id
    private String replyUserId;
    // 回复者昵称
    private String replyUserNickname;
    // 评论创建时间
    private Timestamp createTime;
    // 删除flag
    private boolean deleteFlag;
}
