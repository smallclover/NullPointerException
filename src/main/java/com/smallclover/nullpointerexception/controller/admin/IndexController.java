package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.dto.BrowserDto;
import com.smallclover.nullpointerexception.dto.DataSet;
import com.smallclover.nullpointerexception.dto.StatisticDto;
import com.smallclover.nullpointerexception.service.site.SiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 管理后台首页
 * @author Amadeus
 * @date 2020-01-19
 */
@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class IndexController {

    /**
     * 这里出现了一个问题，如果出现名字相同的Controller，即使包名不一样，也会报错，出现无法注入的问题。
     * 这里使用@Controller("名字")来解决这个问题，或者使用不同的名字。
     */

    // 获取网站相关信息
    private final SiteService siteService;

    @RequestMapping(value = {"", "/index"})
    public String index(HttpServletRequest request){
        StatisticDto statisticDTO = siteService.getStatistics();
        request.setAttribute("statistics", statisticDTO);
        var browserDto = new BrowserDto();
        browserDto.setLabels(Arrays.asList(
                "Chrome",
                "IE",
                "FireFox",
                "Safari",
                "Opera",
                "Navigator"));
        DataSet dataSet = new DataSet();
        dataSet.setBackgroundColor(Arrays.asList("#f56954", "#00a65a", "#f39c12", "#00c0ef", "#3c8dbc", "#d2d6de"));
        dataSet.setData(Arrays.asList(700,500,400,600,300,100));
        browserDto.setDataSet(dataSet);
        request.setAttribute("browser", browserDto);
        return "/admin/index";
    }

    /**
     * 日历页面
     * @return
     */
    @RequestMapping("/calendar")
    public String calendar(){
        return "/admin/calendar";
    }
}
