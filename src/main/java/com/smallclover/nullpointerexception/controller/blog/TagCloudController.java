package com.smallclover.nullpointerexception.controller.blog;

import com.smallclover.nullpointerexception.dto.TagDto;
import com.smallclover.nullpointerexception.model.Tag;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import com.smallclover.nullpointerexception.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 标签云
 * @Author: Amadeus
 * @Date: 2020/6/23 21:36
 */
@RequestMapping("/blog/tags-cloud")
@Controller
@AllArgsConstructor
public class TagCloudController {

    private TagService tagService;

    @RequestMapping(value = {"/",""})
    public String index()
    {
        return "/blog/tags_cloud";
    }

    /**
     * 获取标签云
     * @return
     */
    @RequestMapping("/json")
    public ResponseEntity<List<TagDto>> tagCloud(){
        List<TagDto> tagDtoList = tagService.getTagCloud();
        return ResponseEntity.ok(tagDtoList);
    }

    /**
     * 根据标签名字，取得该标签名下所有的文章
     * @param tagName
     * @param model
     * @return
     */
    @RequestMapping("/{tag_name}")
    public String getTagNameHoldArticles(@PathVariable("tag_name") String tagName, Model model){

        var articles = tagService.getArticlesByTagName(tagName);
        model.addAttribute("articles", articles);
        return "/blog/tag_hold_articles";
    }
}
