package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.model.DevelopLog;
import com.smallclover.nullpointerexception.service.developLog.DevelopLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 开发日志
 * @author Amadeus
 * @date 2020-01-20
 */
@Controller
@RequestMapping("/admin/develop-log")
public class DevelopLogController {

    // 站点开发日志Service
    private DevelopLogService developLogService;

    public DevelopLogController(DevelopLogService developLogService) {
        this.developLogService = developLogService;
    }

    /**
     * 返回开发日志页面
     * @return
     */
    @RequestMapping("/add")
    public String addSiteLog(){
        return "/admin/add_develop_log";
    }

    @RequestMapping("/add/do")
    public @ResponseBody ResponseEntity addSiteLogDo(
            @RequestParam("name") String name,
            @RequestParam("desc") String desc,
            @RequestParam("status") String status,
            @RequestParam("author") String author){
        var developLog = new DevelopLog();
        developLog.setContent(desc);
        developLog.setBugType(status);
        developLog.setAuthor(author);

        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        developLog.setCreateTime(currentTime);

        boolean result = developLogService.insertDevelopLog(developLog);

        if(result){
            return ResponseEntity.ok().body("success");
        }
        return ResponseEntity.badRequest().body("error");
    }
}
