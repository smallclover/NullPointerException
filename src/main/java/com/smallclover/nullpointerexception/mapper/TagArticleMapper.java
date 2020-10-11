package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Tag;
import com.smallclover.nullpointerexception.model.TagArticle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/7/11 16:36
 */
@Mapper
@Repository
public interface TagArticleMapper {

    @Select("SELECT article_id FROM tag_article WHERE tag_id=#{tagId}")
    List<Long> getAllArticleIdByTagId(long tagId);

    @Select("SELECT * FROM tag_article WHERE article_id=#{articleId}")
    @Results(id = "tagArticle",value = {
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "tagId", column = "tag_id"),
            @Result(property = "articleId", column = "article_id"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<TagArticle> getAllTagByArticleId(long articleId);

    long insertTagArticles(List<TagArticle> tagArticleList);
}
