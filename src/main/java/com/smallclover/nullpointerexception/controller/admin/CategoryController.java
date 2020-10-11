package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.service.category.CategoryService;
import com.smallclover.nullpointerexception.service.tag.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Amadeus
 * @Date: 2020/7/8 21:10
 */
@Controller
@RequestMapping("/admin/category")
@AllArgsConstructor
public class CategoryController {

    private TagService tagService;
    private CategoryService categoryService;
    //TODO redis 开发跟生产分开
    @RequestMapping("/manager")
    public String index(Model model){
        var tags = tagService.getAllTags();
        var categories = categoryService.selectAllCategories();
        model.addAttribute("tags", tags);
        model.addAttribute("categories", categories);
        return "admin/category";
    }

}
