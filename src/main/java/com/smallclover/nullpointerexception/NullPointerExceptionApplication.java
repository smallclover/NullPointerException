package com.smallclover.nullpointerexception;

import com.smallclover.nullpointerexception.property.NPEResourcesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// 这里不加扫描会出现springboot无法识别mapper情况无法自动注入
//@MapperScan("com.smallclover.nullpointerexception.mapper")
@EnableConfigurationProperties({NPEResourcesProperties.class})
// 如果要读取自定义的属性需要添加这个注解
@EnableAsync
public class NullPointerExceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(NullPointerExceptionApplication.class, args);
    }

}
