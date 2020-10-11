package com.smallclover.nullpointerexception.mapper;

import com.smallclover.nullpointerexception.model.Setting;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author: Amadeus
 * @Date: 2020/5/24 12:41
 */
@Mapper
@Repository
public interface SettingMapper {


    /**
     * 获得所有系统设置
     * @return
     */
    @Select("SELECT * FROM setting")
    @Results(id = "setting",value = {
            @Result(property = "siteName", column = "site_name"),
            @Result(property = "siteDesc", column = "site_desc"),
            @Result(property = "appVersion", column = "app_version")
    })
    Setting getSystemSetting();


    long updateSystemSetting(Setting setting);
}
