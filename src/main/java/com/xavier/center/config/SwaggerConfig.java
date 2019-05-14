package com.xavier.center.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启用Swagger2
 *
 * @author NewGr8Player
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean
    public Docket openApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ElasticSearch")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis((input) -> input.isAnnotatedWith(ApiOperation.class))/* 注解了ApiOperation的方法 */
                .paths(PathSelectors.any())//过滤的接口
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * api信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("统一Id生成接口")
                .description("基于SpringBoot2开发,整合Redis。")
                .termsOfServiceUrl("https://newgr8player.github.io/")
                .contact(new Contact("NewGr8Player", "https://newgr8player.github.io/", ""))
                .version("0.0.1-RELEASE")
                .build();
    }
}
