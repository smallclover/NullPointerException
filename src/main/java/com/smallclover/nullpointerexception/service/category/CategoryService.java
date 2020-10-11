package com.smallclover.nullpointerexception.service.category;

import com.smallclover.nullpointerexception.model.Category;

import java.util.List;
import java.util.Map;

/**
 * 分类接口
 * @Author: Amadeus
 * @Date: 2020/7/9 21:47
 */
public interface CategoryService {
    /**
     * 查找所有的分类
     * @return
     */
    List<Category> selectAllCategories();

    /**
     * 插入一个新的分类
     * @param categoryName
     * @return
     */
    boolean insertCategory(String categoryName);

    /**
     * 根据传入的文章id列表获取对应的分类
     * @param articleIds
     * @return
     */
    Map<Long, String> getCategoryByArticleIds(List<Long> articleIds);

    Category getCategoryByCategoryName(String categoryName);
}
