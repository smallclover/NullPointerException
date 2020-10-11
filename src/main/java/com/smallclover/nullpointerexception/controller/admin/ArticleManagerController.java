package com.smallclover.nullpointerexception.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smallclover.nullpointerexception.api.rep.ApiResponse;
import com.smallclover.nullpointerexception.constant.ResponseStatusCode;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文章管理
 * @author Amadeus
 * @date 2020-01-23
 */
@RequestMapping("/admin/article/manager")
@RestController
@AllArgsConstructor
public class ArticleManagerController {

    private final ArticleService articleService;
    //TODO 预览
    /**
     * 文章管理首页
     * @return
     */
    @GetMapping("")
    public ModelAndView index(@RequestParam(required = true, defaultValue = "1") Integer page,
                              @RequestParam(required = true, defaultValue = "10") Integer pageSize){
        // 只有执行mapper时才会使用pageHelper进行分页
        PageHelper.startPage(page, pageSize);
        var articleList = articleService.getAllArticles();
        var pageInfo = new PageInfo<>(articleList);
        var mv = new ModelAndView();
        mv.setViewName("/admin/article_manager");
        mv.addObject("articles", articleList);
        mv.addObject("pageInfo", pageInfo);
        return mv;
    }

    /**
     * 更新指定文章
     * @param articleId
     * @return
     */
    @GetMapping("edit/{articleId}")
    public ModelAndView updateArticle(@PathVariable long articleId){
        var article = articleService.getArticleById(articleId);
        var mv = new ModelAndView();
        mv.setViewName("/admin/article_publish");
        mv.addObject("updateArticle", article);
        return mv;
    }

    /**
     * 删除指定文章
     * @param articleId
     * @return
     */
    @PostMapping("delete")
    public ApiResponse deleteArticle(@RequestParam long articleId){
        boolean result = articleService.deleteArticleById(articleId);
        if (result){
            return ApiResponse.ok();
        }else{
            return ApiResponse.fail(ResponseStatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 将指定的文章发布
     * @param articleId
     * @return
     */
    @PostMapping("publish")
    public ApiResponse publishArticle(@RequestParam long articleId){
        boolean result = articleService.publishArticle(articleId);
        if (result){
            return ApiResponse.ok();
        }else{
            return ApiResponse.fail(ResponseStatusCode.INTERNAL_SERVER_ERROR);
        }
    }
}
