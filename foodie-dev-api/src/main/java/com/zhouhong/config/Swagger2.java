package com.zhouhong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: Swagger2
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/15
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    //   http://localhost:8088/swagger-ui.html  原路径
    //   http://localhost:8088/doc.html  原路径
    //配置swagger2核心配置
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) //指定api类型位swagger2
            .apiInfo(apiInfo())                        //用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors
                        .basePackage("com.zhouhong.controller")) //指定controller
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Tom-shushu 电商平台接口api")  //文档标题
                .contact(new Contact("周红",  //作者
                        "www.zhouhong.icu",
                        "15249239025@163.com")) //联系人
                .description("Tom-shushu 的电商平台api接口")//详细信息
                .version("1.0.0")//文档版本号
                .termsOfServiceUrl("www.zhouhong.icu")//网站地址
                .build();
    }
}
