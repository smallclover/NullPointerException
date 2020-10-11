package com.smallclover.nullpointerexception.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: Amadeus
 * @Date: 2020/09/10 0:08
 */
@Component
@ConfigurationProperties(prefix = "swagger")
@PropertySource(value = "classpath:/config/swagger.yml", factory = YamlPropertySourceFactory.class)
@Data
public class SwaggerConfigProperties {
    private String basePackage;
    private String antPath;
    private String title;
    private String description;
    private String version;
    private Boolean enable;
    private String contactName;
    private String contactEmail;
    private String contactUrl;
    private String license;
    private String licenseUrl;
}
