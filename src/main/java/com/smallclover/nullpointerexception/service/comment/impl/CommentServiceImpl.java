package com.smallclover.nullpointerexception.service.comment.impl;

import com.smallclover.nullpointerexception.dto.CommentDto;
import com.smallclover.nullpointerexception.mapper.CommentMapper;
import com.smallclover.nullpointerexception.model.Comment;
import com.smallclover.nullpointerexception.service.comment.CommentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 评论服务层
 * @Author: Amadeus
 * @Date: 2020/3/28 10:36
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;


    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentMapper.getAllComments();
    }

    @Override
    public long getCommentCount() {
        return commentMapper.getCommentCount();
    }

    @Override
    public boolean updateAuditStatus(long commentId) {
        long count = commentMapper.updateCommentAuditByCommentId(commentId, true);
        return count == 1;
    }

    @Override
    public boolean insertComment(CommentDto commentDto) {
        var comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        comment.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        comment.setDeleteFlag(false);
        comment.setPassAudit(false);

        //生成唯一id 替换uuid中的"-"
        String userId= UUID.randomUUID().toString().replace("-", "");
        comment.setUserId(userId);

        long count = commentMapper.insertComment(comment);
        return count == 1 ;
    }

    @Override
    public Comment getCommentByCommentId(long commentId) {
        return commentMapper.getCommentByCommentId(commentId);
    }

    /**
     * 获取文章的评论
     * @param articleId
     * @return 文章的所有评论
     */
    @Override
    public List<CommentDto> getCommentsByArticleId(long articleId) {
        List<CommentDto> commentDTOList = new ArrayList<>();
        // 该篇文章的所有评论
        List<Comment> comments = commentMapper.getCommentsByArticleId(articleId);

        // 没有评论的时候直接返回
        if (CollectionUtils.isEmpty(comments)){
            return commentDTOList;
        }

        // 父评论和子评论设置
        List<Comment> topComments = comments.stream()
                .filter( comment -> Objects.isNull(comment.getCommentParentId()))
                .collect(Collectors.toList());

        for (Comment comment: topComments){
            CommentDto commentDTO = new CommentDto();
            BeanUtils.copyProperties(comment, commentDTO);

            List<Comment> childCommentList = comments.stream()
                    .filter(tmp -> comment.getUserId().equals(tmp.getCommentParentId()))
                    .collect(Collectors.toList());

            commentDTO.setChildComments(childCommentList);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }

}
