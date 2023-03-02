package com.saasMode.config;

import com.saasMode.service.initdb.InitDataBase;
import com.saasMode.service.initdb.impl.OracleInitDBFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *如果需要创建其他数据库时，以配置对应的实现类
 */
@Configuration
public class InitDBConfig {

//    @Bean
//    public InitDataBase initDataBase(){
//        return new OracleInitDBFile();
//    }

}
