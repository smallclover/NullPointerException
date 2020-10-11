package com.smallclover.nullpointerexception.config;

import com.smallclover.nullpointerexception.property.SwaggerConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: Amadeus
 * @Date: 2020/09/08 22:07
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    private final SwaggerConfigProperties swaggerInfo;

    public SwaggerConfig(SwaggerConfigProperties swaggerInfo) {
        this.swaggerInfo = swaggerInfo;
    }

    @Bean
    public Docket createSwaggerDoc(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .description(swaggerInfo.getDescription())
                .contact(new Contact(swaggerInfo.getContactName(), swaggerInfo.getContactUrl(), swaggerInfo.getContactEmail()))
                .version(swaggerInfo.getVersion())
                .build();
    }
}
