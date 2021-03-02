package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/3/28 10:49
 */
@Mapper
@Repository
public interface CommentMapper {

    List<Comment> getCommentsByArticleId(long articleId);

    /**
     * 查询所有评论
     * @return
     */
    @Select("SELECT * FROM comment")
    @Results(id = "comment",value = {
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "commentParentId", column = "comment_parent_id"),
            @Result(property = "replyUserId", column = "reply_user_id"),
            @Result(property = "replyUserNickname", column = "reply_user_nickname"),
            @Result(property = "passAudit", column = "pass_audit"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<Comment> getAllComments();

    /**
     * 查询评论数量
     * @return
     */
    @Select("SELECT COUNT(*) FROM comment")
    long getCommentCount();

    @Update("UPDATE comment SET pass_audit=#{passAuditFlag} WHERE id = #{commentId}")
    long updateCommentAuditByCommentId(long commentId, boolean passAuditFlag);

    /**
     * 创建新评论
     * @param comment
     * @return
     */
    long insertComment(Comment comment);
    @Select("SELECT * FROM comment WHERE id=#{commonId}")
    Comment getCommentByCommentId(long commonId);
}
