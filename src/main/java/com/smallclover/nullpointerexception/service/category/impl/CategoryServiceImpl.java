package com.smallclover.nullpointerexception.service.category.impl;

import com.smallclover.nullpointerexception.mapper.CategoryArticleMapper;
import com.smallclover.nullpointerexception.mapper.CategoryMapper;
import com.smallclover.nullpointerexception.model.ArticleTagCategory;
import com.smallclover.nullpointerexception.model.Category;
import com.smallclover.nullpointerexception.service.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类实现
 * @Author: Amadeus
 * @Date: 2020/7/9 21:47
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryArticleMapper categoryArticleMapper;

    public List<Category> selectAllCategories(){
        return categoryMapper.selectAllCategories();
    }

    @Override
    public boolean insertCategory(String categoryName) {
        var category = new Category();
        category.setCategoryName(categoryName);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setDeleteFlag(false);
        long count =categoryMapper.insertCategory(category);
        return count >= 0;
    }


    @Override
    public Map<Long, String> getCategoryByArticleIds(List<Long> articleIds) {
        List<ArticleTagCategory> articleTagCategories = categoryArticleMapper.getCategoryByArticleIds(articleIds);
        var articleIdAndCategoryMap = new HashMap<Long, String>();
        for (ArticleTagCategory atc: articleTagCategories){
            articleIdAndCategoryMap.put(atc.getArticleId(), atc.getCategoryName());
        }
        return articleIdAndCategoryMap;
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return categoryMapper.getCategoryByCategoryName(categoryName);
    }
}
