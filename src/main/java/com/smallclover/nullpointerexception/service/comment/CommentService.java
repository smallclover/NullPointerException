package com.smallclover.nullpointerexception.service.comment;

import com.smallclover.nullpointerexception.dto.CommentDto;
import com.smallclover.nullpointerexception.model.Comment;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/3/28 10:08
 */
 public interface CommentService {

     List<Comment> getTopComment(long articleId);

     List<Comment> getTopChildComment(long articleId, String commentParentId);

     List<Comment> getAllComments();

     long getCommentCount();

     boolean updateAuditStatus(long commentId);

     boolean insertComment(CommentDto commentDto);
    
     Comment getCommentByCommentId(long commentId);

    List<CommentDto> getCommentsByArticleId(long articleId);
}
