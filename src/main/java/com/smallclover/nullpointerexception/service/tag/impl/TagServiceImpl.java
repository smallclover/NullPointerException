package com.smallclover.nullpointerexception.service.tag.impl;

import com.smallclover.nullpointerexception.dto.TagDto;
import com.smallclover.nullpointerexception.mapper.ArticleMapper;
import com.smallclover.nullpointerexception.mapper.TagArticleMapper;
import com.smallclover.nullpointerexception.mapper.TagMapper;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.ArticleTagCategory;
import com.smallclover.nullpointerexception.model.Tag;
import com.smallclover.nullpointerexception.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 标签相关处理
 * @Author: Amadeus
 * @Date: 2020/7/2 22:00
 */
@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private TagMapper tagMapper;
    private TagArticleMapper tagArticleMapper;
    private ArticleMapper articleMapper;
    public static final String DELIMITER = ",";

    /**
     * 获取所有标签
     * @return
     */
    @Override
    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }

    /**
     * 通过标签名获得拥有该标签的所有文章
     * @param tagName
     * @return
     */
    @Override
    public List<Article> getArticlesByTagName(String tagName) {
        return tagMapper.getArticlesByTagName(tagName);
    }

    /**
     * 插入标签
     * @param tags
     * @return
     */
    @Override
    public boolean insertTags(String tags) {
        String[] tagNames = StringUtils.split(tags,DELIMITER);
        long count = 0;

        var tagList = new ArrayList<Tag>();

        if (Objects.isNull(tagNames)){
            var tag = new Tag();
            tag.setTagName(tags);
            tag.setCreateTime(LocalDateTime.now());
            tag.setUpdateTime(LocalDateTime.now());
            tag.setDeleteFlag(false);
            tagList.add(tag);
        }else{
            for (String tagName: tagNames){
                var tag = new Tag();
                tag.setTagName(tagName);
                tag.setCreateTime(LocalDateTime.now());
                tag.setUpdateTime(LocalDateTime.now());
                tag.setDeleteFlag(false);
                tagList.add(tag);
            }
        }
        count = tagMapper.insertTags(tagList);

        return count > 0;
    }

    public static void main(String[] args) {
        String tags = "tag1,tag2";
        String[] tagNames = StringUtils.split(tags,DELIMITER);
        System.out.println(tagNames.length);
    }

    /**
     * 获得标签云数据
     * @return
     */
    @Override
    public List<TagDto> getTagCloud() {
        List<Tag> tags = getAllTags();
        var map = new HashMap<String, Integer>();

        // 标签名:权重
        for (Tag tag: tags){
            map.put(tag.getTagName(), map.getOrDefault(tag.getTagName(), 0) + 1);
        }

        var tagDtoList = new ArrayList<TagDto>();
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            var tagDTO = new TagDto();
            tagDTO.setWord(entry.getKey());
            tagDTO.setCount(entry.getValue());
            tagDtoList.add(tagDTO);
        }
        return tagDtoList;
    }
}
