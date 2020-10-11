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

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.getAllTags();
    }

    @Override
    public List<Article> getArticlesByTagName(String tagName) {

        var tag = tagMapper.getTagIdByTagName(tagName);
        var articleIds = tagArticleMapper.getAllArticleIdByTagId(tag.getId());
        return articleMapper.getArticlesByIds(articleIds);
    }

    @Override
    public List<Tag> getTagsByTagNames(List<String> tagNames) {
        return tagMapper.getTagsByTagNames(tagNames);
    }

    @Override
    public Map<Long, String> getTagsByArticleIds(List<Long> articleIds) {

        List<ArticleTagCategory> articleTagCategories = tagMapper.getTagsByArticleIds(articleIds);

        var articleIdAndTagsMap = new HashMap<Long, String>();
        for (ArticleTagCategory atc: articleTagCategories){
            String tags = atc.getTagName() + "," + articleIdAndTagsMap.getOrDefault(atc.getArticleId(), "");
            articleIdAndTagsMap.put(atc.getArticleId(), tags);
        }


        return articleIdAndTagsMap;
    }

    @Override
    public boolean insertTags(String tags) {
        String[] tagNames = StringUtils.split(tags,DELIMITER);
        long count = 0;
        if (Objects.isNull(tagNames)){
            var tag = new Tag();
            tag.setTagName(tags);
            tag.setCreateTime(LocalDateTime.now());
            tag.setUpdateTime(LocalDateTime.now());
            tag.setDeleteFlag(false);
            count = tagMapper.insertTag(tag);
        }else{
            var tagList = new ArrayList<Tag>();
            for (String tagName: tagNames){
                var tag = new Tag();
                tag.setTagName(tagName);
                tag.setCreateTime(LocalDateTime.now());
                tag.setUpdateTime(LocalDateTime.now());
                tag.setDeleteFlag(false);
                tagList.add(tag);
            }
            count = tagMapper.insertTags(tagList);
        }

        return count > 0;
    }

    @Override
    public List<TagDto> getTagCloud() {
        List<String> tagNames = getAllTags()
                .stream()
                .map(Tag::getTagName)
                .collect(Collectors.toList());
        List<Tag> tags = getTagsByTagNames(tagNames);
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

    public static void main(String[] args) {
        String tags = "hello,hi";
        String[] strs = StringUtils.split(tags,DELIMITER);
        Arrays.asList(strs).forEach(System.out::println);
    }
}
