package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.config.WebSiteConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Amadeus
 * @date 2019-12-07
 * 网站信息操作mapper
 */
@Mapper
@Repository
public interface WebSiteMapper {

    /**
     * 查找网站信息
     * @return 网站信息配置类
     */
//    JDK13 text blocks
//    @Select("""
//            SELECT *
//            FROM website
//            """)
    @Select("SELECT * FROM website")
    @Results({
            @Result(property = "copyright", column = "copy_right"),
            @Result(property = "poweredBy", column = "powered_by"),
            @Result(property = "poweredByUrl", column = "powered_by_url")
    })
    WebSiteConfig getWebSiteConfig();
}
