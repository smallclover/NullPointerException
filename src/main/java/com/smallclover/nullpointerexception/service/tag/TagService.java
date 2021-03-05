package com.smallclover.nullpointerexception.service.tag;

import com.smallclover.nullpointerexception.dto.TagDto;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Tag;

import java.util.List;
import java.util.Map;

/**
 * 标签处理
 * @Author: Amadeus
 * @Date: 2020/7/2 22:00
 */
public interface TagService {
    /**
     * 获取所有标签
     * @return
     */
    List<Tag> getAllTags();

    /**
     * 根据标签名取得该标签所拥有的所有文章
     * @param tagName
     * @return
     */
    List<Article> getArticlesByTagName(String tagName);

    /**
     * 插入标签
     * @param tags
     * @return
     */
    boolean insertTags(String tags);

    /**
     * 获取标签云
     * @return
     */
    List<TagDto> getTagCloud();
}
