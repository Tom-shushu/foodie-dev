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
                .paths(PathSelectors.any())                 //为任何接口生成API文档
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Tom-shushu 的项目接口api")  //文档标题
                .contact(new Contact("周红",  //作者
                        "www.zhouhong.icu",
                        "15249239025@163.com")) //联系人
                .description("Tom-shushu 的项目api接口")//详细信息
                .version("1.0.0")//文档版本号
                .termsOfServiceUrl("www.zhouhong.icu")//网站地址
                .build();
    }
    /**
     * 1、为任何接口生成API文档，这种方式不必在接口方法上加任何注解，方便的同时也会因为没有添加任何注解所以生成的API文档也没有注释，可读性不高。
     * @Bean
     *     public Docket createRestApi(){
     *         return new Docket(DocumentationType.SWAGGER_2)
     *                 .apiInfo(apiInfo())
     *                 .select()
     *                 //为任何接口生成API文档
     *                 .apis(RequestHandlerSelectors.any())
     *                 .paths(PathSelectors.any())
     *                 .build();
     *     }
     * 2、为当前配置的包下controller生成API文档
     * .apis(RequestHandlerSelectors.basePackage("com.troila"))
     * 3、为有@Api注解的Controller生成API文档
     * .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
     * 4、为有@ApiOperation注解的方法生成API文档
     * .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
     *
     * @Api：修饰整个类，描述Controller的作用
     * @ApiOperation：描述一个类的一个方法，或者说一个接口
     * @ApiParam：单个参数描述
     * @ApiModel：用对象实体来作为入参
     * @ApiProperty：用对象接实体收参数时，描述对象的一个字段
     * @ApiResponse：HTTP响应其中1个描述
     * @ApiResponses：HTTP响应整体描述
     * @ApiIgnore：使用该注解忽略这个API
     * @ApiError ：发生错误返回的信息
     * @ApiImplicitParam：一个请求参数
     * @ApiImplicitParams： 多个请求参数
     */


}
