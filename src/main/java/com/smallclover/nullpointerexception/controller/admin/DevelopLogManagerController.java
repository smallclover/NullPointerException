package com.smallclover.nullpointerexception.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smallclover.nullpointerexception.dto.DevelopLogDto;
import com.smallclover.nullpointerexception.model.Comment;
import com.smallclover.nullpointerexception.model.DevelopLog;
import com.smallclover.nullpointerexception.service.developLog.DevelopLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/7 11:35
 * 开发日志管理
 */
@Controller
@RequestMapping("admin/develop-log/manager")
public class DevelopLogManagerController {

    private final DevelopLogService developLogService;

    public DevelopLogManagerController(DevelopLogService developLogService) {
        this.developLogService = developLogService;
    }

    /**
     * 日志管理首页
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("")
    public String index(@RequestParam(required = true, defaultValue = "1") Integer page,
                        @RequestParam(required = true, defaultValue = "10") Integer pageSize,
                        Model model){
        PageHelper.startPage(page, pageSize);
        List<DevelopLogDto> developLogDtoList = developLogService.getAllDevelopLogs();
        var pageInfo = new PageInfo<>(developLogDtoList);
        model.addAttribute("developLogs", developLogDtoList);
        model.addAttribute("pageInfo", pageInfo);
     return "/admin/develop_log_manager";
    }

}
