package com.esd.auth;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class AppRun {
    public static void main(String[] args) {
        try {
            /**
             *  log4j2异步日志全局配置，减小输出日志对性能的影响
             */
            System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
            SpringApplication.run(AppRun.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}