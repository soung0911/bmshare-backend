package com.bmshare.config;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ADMIN")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bmshare.controller.admin"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList())
                .globalResponseMessage(RequestMethod.POST, newArrayList())
                .globalResponseMessage(RequestMethod.PUT, newArrayList())
                .globalResponseMessage(RequestMethod.DELETE, newArrayList());
    }
    
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("USER")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bmshare.controller.user"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList())
                .globalResponseMessage(RequestMethod.POST, newArrayList())
                .globalResponseMessage(RequestMethod.PUT, newArrayList())
                .globalResponseMessage(RequestMethod.DELETE, newArrayList());
    }
}