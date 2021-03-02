package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.DevelopLog;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章操作Mapper
 * @author Amadeus
 * @date 2019-11-25
 */
@Mapper
@Component//这里不将该mapper标记为bean的话intellij会报错，但实际不会有问题
public interface ArticleMapper {

    //TODO simplekey替换
    //TODO 缓存失效问题
    /**
     * 查找所有文章
     * @return 返回所有文章列表
     */
    @ResultMap("article")// 通过id来直接引用resultMap
    @Cacheable(cacheNames = "articles")
    List<Article> getAllArticles();

    /**
     * 根据指定的id来获得文章
     * @param id 文章id
     * @return 文章实体类
     */
    @ResultMap("article")
    @Cacheable(cacheNames = "article", key = "#id")
    Article getArticleById(@Param("id") long id);

    /**
     * 获取文章总数
     * @return 文章总数
     */
    long getArticleCount();

    /**
     * 创建新文章
     * @param article
     * @return
     */
    @CacheEvict(cacheNames = "articles", allEntries = true)
    long insertArticle(Article article);

    /**
     * 删除指定id的文章，同时更新缓存
     * 1.删除该id文章的缓存
     * 2.从文章列表的缓存中删除该id的文章
     * @param articleId
     * @param deleteFlag
     * @return
     */
    @Caching(evict = {
            @CacheEvict(cacheNames = "article", key = "#articleId"),
            @CacheEvict(cacheNames = "articles", allEntries = true)
    })
    long deleteArticleById(long articleId,boolean deleteFlag);

    /**
     * 更新文章的状态
     * 1.是否发布
     * 2.草稿还是已完成
     * @param articleId
     * @param publish
     * @param status
     * @return
     */
    long updateArticleStatusById(long articleId, boolean publish, boolean status);

    /**
     * 查找指定的id列表的文章列表
     * @param ids
     * @return
     */
    List<Article> getArticlesByIds(List<Long> ids);
}
