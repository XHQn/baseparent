package com.init;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com/saasMode/mapper")
@ComponentScan("com.saasMode")
public class InitConfig {

}
