package com.smallclover.nullpointerexception.dto;

import com.smallclover.nullpointerexception.model.Comment;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/21 18:39
 */
@Data
public class CommentDto implements Serializable {
    // 主键
    private long id;
    // 评论内容
    @NotBlank(message = "评论内容不能为空(*^_^*)")
    private String content;
    // 评论的文章Id
    @NotNull
    private long articleId;
    // 评论是否通过审核
    private boolean passAudit;
    // 评论者id
    private String userId;
    // 评论者昵称
    @NotBlank(message = "填上你的称呼(*^_^*)")
    private String nickname;
    // 邮箱
    @NotBlank(message = "邮箱不能为空(*^_^*)")
    @Email(message = "邮箱格式不正确(*^_^*)")
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

    List<Comment> childComments;
}
