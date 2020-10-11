package com.smallclover.nullpointerexception.controller.blog;

import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 归档
 * @Author: Amadeus
 * @Date: 2020/7/1 21:11
 */
@Controller
@RequestMapping("/blog/archive")
@AllArgsConstructor
public class ArchiveController {

    private ArticleService articleService;

    @RequestMapping("")
    public String index(Model model){
        // TODO 前台blog分页共通
        // TODO 如何根据年份来分
        // TODO 开发日志页面显示问题，后台提交提示问题
        List<Article> articles = articleService.getArticlesOrderByCreateTime();
        model.addAttribute("articles", articles);
        return "/blog/archive";
    }
}
