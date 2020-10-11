package com.smallclover.nullpointerexception.controller.blog;

import com.smallclover.nullpointerexception.dto.AboutDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 关于页面
 * @Author: Amadeus
 * @Date: 2020/7/15 21:21
 */
@RequestMapping("/blog/about")
@Controller
public class AboutController {
    /**
     * 跳转到关于页面
     * @return 关于视图
     */
    @GetMapping(value = {"","/"})
    public String about(Model model){
        List<String> techStack = Arrays.asList(
                "语言: Java(主力), Python",
                "框架: SpringBoot, MyBaits",
                "前端模板引擎: Thymeleaf",
                "数据库: MySQL, PostgreSQL",
                "版本控制工具: Git, SVN",
                "自动构建工具: Gradle, Maven",
                "数据迁移工具: Flyway"
        );
        var desc = "描述:一个喜欢瞎搞的魔法师";
        var address = "现居地: 日本, 东京";
        var favourite = "喜欢的事物: 动漫, 编程, 篮球, 读书, 游戏, 历史古迹";
        var character = " 性格: 热情, 温和, 冲动, 谨慎, 心理活动复杂";
        var future = "期待: 拥有属于自己的书房";
        var wellKnown = "座右铭: 谨言慎行";
        var aboutDTO = new AboutDto();
        aboutDTO.setTechStack(techStack);
        aboutDTO.setDesc(desc);
        aboutDTO.setAddress(address);
        aboutDTO.setFavourite(favourite);
        aboutDTO.setCharacter(character);
        aboutDTO.setFuture(future);
        aboutDTO.setWellKnown(wellKnown);
        model.addAttribute("about",aboutDTO);
        return "/blog/about";
    }
}
