package com.auth;

import com.commonTool.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.auth.mapper")
public class TokenApplication {
    public static void main(String[] args) {
        try{
            SpringApplication.run(TokenApplication.class,args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
