package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.ArticleTagCategory;
import com.smallclover.nullpointerexception.model.Category;
import com.smallclover.nullpointerexception.model.CategoryArticle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/7/9 21:45
 */
@Mapper
@Repository
public interface CategoryArticleMapper {
    long insertCategoryArticle(CategoryArticle categoryArticle);

    List<ArticleTagCategory> getCategoryByArticleIds(List<Long> articleIds);
}
