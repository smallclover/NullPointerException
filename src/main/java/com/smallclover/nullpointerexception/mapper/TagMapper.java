package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.ArticleTagCategory;
import com.smallclover.nullpointerexception.model.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/7/2 22:20
 */
@Mapper
@Repository
public interface TagMapper {

    @Select("SELECT * FROM tag")
    @Results(id = "tag",value = {
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "tagName", column = "tag_name"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<Tag> getAllTags();

    List<Tag> getTagsByTagNames(List<String> tagNames);

    long insertTags(List<Tag> tags);

    List<Article> getArticlesByTagName(String tagName);
}
