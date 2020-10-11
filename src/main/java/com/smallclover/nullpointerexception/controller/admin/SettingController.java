package com.smallclover.nullpointerexception.controller.admin;

import com.smallclover.nullpointerexception.dto.SettingDto;
import com.smallclover.nullpointerexception.model.Setting;
import com.smallclover.nullpointerexception.service.setting.SettingService;
import com.smallclover.nullpointerexception.service.site.SiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 系统设置
 * @author Amadeus
 * @date 2020-05-05
 */
@Controller
@RequestMapping("/admin/setting")
@Slf4j
@AllArgsConstructor
public class SettingController {

    SettingService settingService;

    @GetMapping(value = {"", "/"})
    public String index(Model model){
        SettingDto settingDto = settingService.getAllSetting();
        model.addAttribute("setting", settingDto);
        return "/admin/setting";
    }

    /**
     * 系统设置更新
     * @param settingDto
     * @return
     */
    @PostMapping("/update")
    public @ResponseBody ResponseEntity update(@RequestBody SettingDto settingDto){
        boolean result = settingService.updateSystemSetting(settingDto);
        if(result){
            return ResponseEntity.ok().body("success");
        }
        return ResponseEntity.badRequest().body("error");
    }
}
