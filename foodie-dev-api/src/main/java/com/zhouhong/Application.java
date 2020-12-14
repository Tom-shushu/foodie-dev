package com.zhouhong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @ClassName: Application
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/7
 **/
@SpringBootApplication
//扫描 mybatis 通用 mapper 所需要的包
@MapperScan(basePackages = "com.zhouhong.mapper")
//扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.zhouhong","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
