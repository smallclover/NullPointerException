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
//    OpenJDK 13
//    @Select("""
//            SELECT *
//            FROM article
//            """)
    @Select("SELECT * FROM article")
    @Results(id = "article",value = {
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "mdContent", column = "md_content"),
        @Result(property = "htmlContent", column = "html_content"),
        @Result(property = "contentView", column = "content_view"),
        @Result(property = "deleteFlag", column = "delete_flag")
    })
    @Cacheable(cacheNames = "articles")
    List<Article> getAllArticles();

    /**
     * 获取所有文章，根据创建时间降顺
     * @return
     */
    @Select("SELECT * FROM article ORDER BY create_time DESC")
    @ResultMap("article")
    List<Article> getAllArticlesOrderByCreateTime();

    /**
     * 根据指定的id来获得文章
     * @param id 文章id
     * @return 文章实体类
     */
    @Select("SELECT * FROM article WHERE id = #{id}")
    @ResultMap("article")// 通过引用Results的id直接使用之前声明过的Results
    @Cacheable(cacheNames = "article", key = "#id")
    Article getArticleById(@Param("id") long id);

    /**
     * 获取文章数量
     * @return 文章总数
     */
    @Select("SELECT count(*) FROM article")
    long getArticleCount();

    /**
     * 创建新文章
     * @param article
     * @return
     */
    @CacheEvict(cacheNames = "articles", allEntries = true)
    long insertArticle(Article article);

    @Update("UPDATE article SET delete_flag=#{deleteFlag} WHERE id = #{articleId}")
    @Caching(evict = {
            @CacheEvict(cacheNames = "article", key = "#articleId"),
            @CacheEvict(cacheNames = "articles", allEntries = true)
    })
    long deleteArticleById(long articleId,boolean deleteFlag);

    @Update("UPDATE article SET status=#{status},publish=#{publish} WHERE id = #{articleId}")
    long updateArticleById(long articleId, boolean publish, boolean status);

    List<Article> getArticlesByIds(List<Long> ids);
}
