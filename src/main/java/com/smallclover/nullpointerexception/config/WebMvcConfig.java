package com.smallclover.nullpointerexception.config;

import com.smallclover.nullpointerexception.interceptor.AccessRecordInterceptor;
import com.smallclover.nullpointerexception.interceptor.BaseInterceptor;
import com.smallclover.nullpointerexception.property.NPEResourcesProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC配置
 * @author Amadeus
 * @date 2020-05-05
 */
@Configuration
@Slf4j
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private BaseInterceptor baseInterceptor;
    private AccessRecordInterceptor accessRecordInterceptor;
    private NPEResourcesProperties NPEResourcesProperties;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(baseInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");

        registry.addInterceptor(accessRecordInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**",
                        "/admin/**",
                        "/plugins/**",
                        "/blog/css/**",
                        "/blog/js/**",
                        "/blog/img/**",
                        "/blog/vendor/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 上传文章图片的存储路径
        registry.addResourceHandler("/upload/article/img/**").addResourceLocations(
                "file:"+ NPEResourcesProperties.getArticleImgPath());
        // 旅行图片存储路径
        registry.addResourceHandler("/upload/journey/img/**").addResourceLocations(
                "file:"+NPEResourcesProperties.getJourneyImgPath());
        log.info("文章图片存储路径:{}", NPEResourcesProperties.getArticleImgPath());
        log.info("旅行图片存储路径:{}", NPEResourcesProperties.getJourneyImgPath());
    }
}
