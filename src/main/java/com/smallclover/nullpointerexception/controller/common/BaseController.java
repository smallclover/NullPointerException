package com.smallclover.nullpointerexception.controller.common;

import com.smallclover.nullpointerexception.dto.SettingDto;
import com.smallclover.nullpointerexception.service.setting.SettingService;
import com.smallclover.nullpointerexception.service.visit.VisitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

/**
 * @author Amadeus
 * @date 2019-12-07
 * 共通控制器用于处理一些共通业务
 */
@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class BaseController {

    // 网站的设置信息
    private final SettingService settingService;


    @ModelAttribute
    public void webSiteConfig(Model model){
        SettingDto settingDto = settingService.getAllSetting();
        model.addAttribute("settingDto", settingDto);
    }
}
