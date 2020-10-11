package com.smallclover.nullpointerexception.service.article;

import com.smallclover.nullpointerexception.dto.ArticleDto;
import com.smallclover.nullpointerexception.model.Article;

import java.util.List;

/**
 * 文章操作 服务层
 * @author Amadeus
 * @date 2019-11-25
 */
public interface ArticleService {
    /**
     * 取得所有文章包括分类
     * @return 文章实体类列表
     */
    List<ArticleDto> getAllArticles();

    /**
     * 取得所有文章不包括分类
     * @return 文章实体类列表
     */
    List<Article> getAllArticleNoCategory();

    /**
     * 通过文章id来获取文章
     * @return 文章实体类
     */
    Article getArticleById(long id);

    /**
     * 获取文章数
     * @return 文章总数s
     */
    long getArticleCount();

    /**
     * 根据入力Id删除文章
     * @return
     */
    boolean deleteArticleById(long articleId);

    /**
     * 上传一篇新的文章
     * @param articleDto
     * @return
     */
    boolean insertArticle(ArticleDto articleDto);

    boolean publishArticle(long articleId);

    List<Article> getArticlesByIds(List<Long> articleIds);

    List<Article> getArticlesOrderByCreateTime();
}
