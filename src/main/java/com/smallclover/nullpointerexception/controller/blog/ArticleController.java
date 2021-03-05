package com.smallclover.nullpointerexception.controller.blog;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smallclover.nullpointerexception.constant.ResponseStatusCode;
import com.smallclover.nullpointerexception.api.rep.ApiResponse;
import com.smallclover.nullpointerexception.dto.ArticleDto;
import com.smallclover.nullpointerexception.dto.CommentDto;
import com.smallclover.nullpointerexception.exception.ArticleException;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Comment;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import com.smallclover.nullpointerexception.service.comment.CommentService;
import com.smallclover.nullpointerexception.service.mail.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 文章内容编辑
 * 文章管理
 */
@Slf4j//引入lombok日志注解，默认的的日志对象名是log
@RestController
@RequestMapping("/blog/article")
@AllArgsConstructor
public class ArticleController{

    // 文章相关服务层
    private ArticleService articleService;
    // 评论相关服务层
    private CommentService commentService;
    // 发送邮件通知
    private MailService mailService;


    //TODO 缓存的引入

    /**
     * 文章详细
     * @param articleId
     * @return
     */
    @GetMapping("/detail/{id}")
    public ModelAndView articleDetail(@PathVariable("id") long articleId){

        ArticleDto articleDto = articleService.getArticleById(articleId);
        List<CommentDto> comments = commentService.getCommentsByArticleId(articleId);

        var mv = new ModelAndView();
        mv.addObject("article", articleDto);
        mv.addObject("comments", comments);
        mv.setViewName("/blog/article_detail");
        return mv;
    }

    /**
     * 文章列表
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = {"/list", "/", ""})
    public ModelAndView articleList(
            @RequestParam(required = true, defaultValue = "1") Integer page,
            @RequestParam(required = true, defaultValue = "10") Integer pageSize){
        PageHelper.startPage(page, pageSize);
        var articles = articleService.getAllArticles();
        var pageInfo = new PageInfo<>(articles);
        var mv = new ModelAndView();
        mv.addObject("articles", articles);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("/blog/article_list");
        return mv;
    }

    /**
     * 提交评论
     * @param commentDTO
     * @return
     */
    @PostMapping("/comment")
    public ApiResponse commentPost(@Valid @RequestBody CommentDto commentDTO){

            boolean result = commentService.insertComment(commentDTO);

            if (result){
                return ApiResponse.ok();
            }
            return ApiResponse.fail(ResponseStatusCode.INTERNAL_SERVER_ERROR);
    }

}
