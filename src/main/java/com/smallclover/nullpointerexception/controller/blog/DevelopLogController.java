package com.smallclover.nullpointerexception.controller.blog;

import com.smallclover.nullpointerexception.dto.DevelopLogDto;
import com.smallclover.nullpointerexception.service.developLog.DevelopLogService;
import com.smallclover.nullpointerexception.util.TimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 开发日志
 * @Author: Amadeus
 * @Date: 2020/7/15 21:17
 */
@RequestMapping("/blog/develop-log")
@Controller("blog-develop-log")
@AllArgsConstructor
public class DevelopLogController {

    private DevelopLogService developLogService;

    //TODO 页面显示问题
    /**
     * 跳转到开发日志页面
     * @return 开发日志视图
     */
    @GetMapping(value = {"", "/"})
    public String index(Model model){
        List<DevelopLogDto> developLogDtoList = developLogService.getAllDevelopLogs();
        model.addAttribute("developLogs", developLogDtoList);
        return "/blog/develop_log";
    }
}
