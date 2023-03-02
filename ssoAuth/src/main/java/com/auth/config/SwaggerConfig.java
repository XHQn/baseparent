package com.auth.config;

import springfox.documentation.service.Parameter;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lichao
 * @Description: swagger配置
 * @Date 2022/03/07
 * @ClassName: SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(Environment environment) {
        //设置要显示Swagger的环境
        boolean isDisplay = true;
        String[] profiles = environment.getActiveProfiles();
        for (String profile : profiles) {
            System.out.println(profile);
            if("local".equals(profile)){
                isDisplay = true;
            }
        }

        //添加head参数配置start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        // Authorization，可以自定义名称-->token
        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add((Parameter) tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //不显示springboot的BasicErrorControllere类接口
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .enable(isDisplay)
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "",
                "",
                "API V1.0",
                "Terms of service",
                new Contact("zwzgame", "http://127.0.0.1:8888/doc.html", ""),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
