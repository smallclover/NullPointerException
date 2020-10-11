package com.smallclover.nullpointerexception.controller.blog;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * @author Amadeus
 * @date 2019-12-16
 */
@Api(tags = "博客首页")
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    /**
     * 跳转到首页
     * @return 首页视图
     */
    @ApiOperation("首页")
    @GetMapping(value = {"/", "/index", "/blog/index"})
    public String index(){
        return "/blog/index";
    }

}
