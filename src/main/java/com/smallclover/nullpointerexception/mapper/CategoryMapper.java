package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.ArticleTagCategory;
import com.smallclover.nullpointerexception.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/7/9 21:45
 */
@Mapper
@Repository
public interface CategoryMapper {

    @Select("SELECT * FROM category")
    @Results(id = "category", value = {
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "deleteFlag", column = "delete_flag")
    })
    List<Category> selectAllCategories();

    @Insert("INSERT INTO category (category_name, update_time, create_time, delete_flag)" +
            "VALUE(#{categoryName}, #{updateTime}, #{createTime}, #{deleteFlag})")
    long insertCategory(Category category);

    @Select("SELECT * FROM category WHERE category_name = #{categoryName}")
    @ResultMap("category")
    Category getCategoryByCategoryName(String categoryName);
}
