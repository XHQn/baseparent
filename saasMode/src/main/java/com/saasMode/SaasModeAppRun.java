package com.saasMode;

import com.commonTool.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SaasModeAppRun {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SaasModeAppRun.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
