package com.saasMode.service.initdb.impl;

import com.saasMode.service.initdb.InitCondition;
import com.saasMode.service.initdb.InitDataBase;
import com.saasMode.utils.InitDBUtil;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration("initDataBase")
@Conditional(InitCondition.class)
public class MysqlInitDBFile implements InitDataBase {

    @Override
    public boolean initDB(String mysqlUrl, String schema, String username, String password) throws Exception{
        System.out.println("mysql");
        return InitDBUtil.initDB(mysqlUrl,schema,username,password);
    }
}
