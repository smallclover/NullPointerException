package com.smallclover.nullpointerexception.service.article.impl;

import com.smallclover.nullpointerexception.dto.ArticleDto;
import com.smallclover.nullpointerexception.mapper.CategoryArticleMapper;
import com.smallclover.nullpointerexception.mapper.TagArticleMapper;
import com.smallclover.nullpointerexception.mapper.TagMapper;
import com.smallclover.nullpointerexception.model.*;
import com.smallclover.nullpointerexception.mapper.ArticleMapper;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import com.smallclover.nullpointerexception.service.category.CategoryService;
import com.smallclover.nullpointerexception.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 文章操作实现
 * @author Amadeus
 * @date 2019-11-25
 */
@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    // 文章Mapper
    private ArticleMapper articleMapper;
    private TagService tagService;
    private CategoryService categoryService;
    private TagArticleMapper tagArticleMapper;
    private CategoryArticleMapper categoryArticleMapper;
    private TagMapper tagMapper;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleMapper.getAllArticles();
        List<Long> articleIds = articles.stream().map(Article::getId).collect(Collectors.toList());
        var articleIdAndCategoryMap = categoryService.getCategoryByArticleIds(articleIds);
        var articleIdAndTagsMap = tagService.getTagsByArticleIds(articleIds);

        var articleDTOs = new ArrayList<ArticleDto>();
        for(Article article: articles){
            ArticleDto articleDTO = new ArticleDto();
            BeanUtils.copyProperties(article, articleDTO);
            articleDTO.setTags(articleIdAndTagsMap.get(article.getId()));
            articleDTO.setCategory(articleIdAndCategoryMap.get(article.getId()));
            articleDTOs.add(articleDTO);
        }
        return articleDTOs;
    }

    @Override
    public List<Article> getAllArticleNoCategory() {
        return articleMapper.getAllArticles();
    }

    @Override
    public Article getArticleById(long id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public long getArticleCount() {
        return articleMapper.getArticleCount();
    }

    @Override
    public boolean deleteArticleById(long articleId) {
        return articleMapper.deleteArticleById(articleId, true) > 0;
    }

    @Transactional
    @Override
    public boolean insertArticle(ArticleDto articleDto) {
        // 同时插入多张表tag,category,article,tag_article, category_article所以需要事务
        tagService.insertTags(articleDto.getTags());
        String[] tagNames = StringUtils.split(articleDto.getTags(),",");
        List<String> tags;
        if (Objects.isNull(tagNames)){
            tags = new ArrayList<>();
            tags.add(articleDto.getTags());
        }else {
            tags= Arrays.asList(tagNames);
        }

//        categoryService.insertCategory(articleDto.getCategory());
        var article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        // 浏览量
        article.setContentView(0);
        // 文章创建时间
        article.setCreateTime(new Timestamp(System.currentTimeMillis()));
        long count = articleMapper.insertArticle(article);

        List<Tag> tagList = tagMapper.getTagsFormTagByTagNames(tags);
        Category category = categoryService.getCategoryByCategoryName(articleDto.getCategory());

        List<TagArticle> tagArticleList = new ArrayList<>();
        for (Tag tag: tagList){
            TagArticle tagArticle = new TagArticle();
            tagArticle.setArticleId(article.getId());
            tagArticle.setCreateTime(LocalDateTime.now());
            tagArticle.setTagId(tag.getId());
            tagArticle.setDeleteFlag(false);
            tagArticleList.add(tagArticle);
        }

        tagArticleMapper.insertTagArticles(tagArticleList);

        CategoryArticle categoryArticle = new CategoryArticle();
        categoryArticle.setArticleId(article.getId());
        categoryArticle.setCategoryId(category.getId());
        categoryArticle.setCreateTime(LocalDateTime.now());
        categoryArticle.setDeleteFlag(false);

        categoryArticleMapper.insertCategoryArticle(categoryArticle);

        return count != 0 ;
    }

    @Override
    public boolean publishArticle(long articleId) {
        long count = articleMapper.updateArticleById(articleId, true, false);
        return count >= 0;
    }

    @Override
    public List<Article> getArticlesByIds(List<Long> articleIds) {
        return articleMapper.getArticlesByIds(articleIds);
    }

    @Override
    public List<Article> getArticlesOrderByCreateTime() {
        return articleMapper.getAllArticlesOrderByCreateTime();
    }
}
