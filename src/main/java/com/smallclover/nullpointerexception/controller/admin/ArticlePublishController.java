package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.dto.ArticleDto;
import com.smallclover.nullpointerexception.model.Article;
import com.smallclover.nullpointerexception.model.Category;
import com.smallclover.nullpointerexception.service.article.ArticleService;
import com.smallclover.nullpointerexception.service.article.FileService;
import com.smallclover.nullpointerexception.service.category.CategoryService;
import com.smallclover.nullpointerexception.service.tag.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章发布
 * @author Amadeus
 * @date 2020-04-04
 */
@RequestMapping("/admin/article")
@RestController
@Slf4j
@AllArgsConstructor
public class ArticlePublishController {

    private ArticleService articleService;
    private FileService fileService;
    private TagService tagService;
    private CategoryService categoryService;

    public static final String ARTICLE_IMG_URL = "/upload/article/img/";


    @GetMapping("/publish")
    public ModelAndView articlePublish(){
        var mv = new ModelAndView();
        List<Category> categoryList = categoryService.selectAllCategories();
        mv.addObject("categorys", categoryList);
        mv.setViewName("/admin/article_publish");
        return mv;
    }

    /**
     * 上传文章
     * @param
     * @return
     */
    @PostMapping("/add/content")
    public ResponseEntity addArticle(@Valid @RequestBody ArticleDto articleDTO){
        boolean result = articleService.insertArticle(articleDTO);
        if (result){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    /**
     * 上传文章里插入的图片
     * @param pic 图片
     * @return 上传结果
     */
    @PostMapping("/add/content/image")
    public Map<String, Object> addArticleImage(
            @RequestParam(value = "editormd-image-file", required = false) MultipartFile pic){
        var map = new HashMap<String, Object>();
        fileService.storeFile(pic);
        map.put("success", 1);
        map.put("message", "test");
        map.put("url", ARTICLE_IMG_URL + pic.getOriginalFilename());
        return map;
    }
}
