package com.fanhf.javastudy.mybatistest.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanhf
 * @Description TODO
 * @date 2021-02-02 10:05
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(setSwaggerResource("基金管理接口服务", "/java-study/v1/api-doc", "1.0"));
        return resources;
    }

    private SwaggerResource setSwaggerResource(String name,String url,String swaggerVersion){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setSwaggerVersion(swaggerVersion);
        swaggerResource.setUrl(url);
        return swaggerResource;
    }
}
