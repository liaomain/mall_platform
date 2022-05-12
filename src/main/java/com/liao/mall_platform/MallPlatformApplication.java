package com.liao.mall_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity         //开启SpringSecurity 安全框架
@SpringBootApplication
public class MallPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPlatformApplication.class, args);
    }

}
