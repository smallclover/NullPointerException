package com.smallclover.nullpointerexception.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * file.upload-path属性绑定
 * @Author: Amadeus
 * @Date: 2020/5/10 17:38
 */
@ConfigurationProperties(prefix = "npe.resources")
@Data
public class NPEResourcesProperties {

    // 上传文件存储的路径
    // linux与windows环境的路径不同
    private String articleImgPath;
    // 旅行图片存储路径
    private String journeyImgPath;
    // 附件存储路径
    private String attachPath;
    // 日志路径
    private String logPath;

}
