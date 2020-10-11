package com.smallclover.nullpointerexception.service.setting.impl;

import com.smallclover.nullpointerexception.dto.SettingDto;
import com.smallclover.nullpointerexception.mapper.SettingMapper;
import com.smallclover.nullpointerexception.model.Setting;
import com.smallclover.nullpointerexception.service.setting.SettingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Author: Amadeus
 * @Date: 2020/5/24 13:46
 */
@Service
@AllArgsConstructor
public class SettingServiceImpl implements SettingService {

    private SettingMapper settingMapper;

    @Override
    public SettingDto getAllSetting() {
        Setting setting = settingMapper.getSystemSetting();
        var settingDto = new SettingDto();
        BeanUtils.copyProperties(setting,settingDto);
        return settingDto;
    }

    @Override
    public boolean updateSystemSetting(SettingDto settingDto) {
        Setting setting = new Setting();
        setting.setId(settingDto.getId());
        BeanUtils.copyProperties(settingDto, setting);
        return settingMapper.updateSystemSetting(setting) > 0;
    }
}
