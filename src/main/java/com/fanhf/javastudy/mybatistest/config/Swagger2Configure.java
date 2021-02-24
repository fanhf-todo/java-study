package com.fanhf.javastudy.mybatistest.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-01-30 22:38
 */

@Configuration
@EnableSwagger2
@Profile({"dev"})
@ConditionalOnClass(DocumentationType.class)
public class Swagger2Configure {
    @Bean
    public Docket createDocket(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fanhf.javastudy.mybatistest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("基金管理接口服务")
                .description("基金管理服务列表")
                .termsOfServiceUrl("http://localhost:8885")
                .version("1.0")
                .build();
    }
}   
