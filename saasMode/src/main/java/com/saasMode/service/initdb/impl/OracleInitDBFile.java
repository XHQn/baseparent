package com.saasMode.service.initdb.impl;

import com.saasMode.service.initdb.InitCondition;
import com.saasMode.service.initdb.InitDataBase;
import com.saasMode.utils.InitDBUtil;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class OracleInitDBFile implements InitDataBase {

    @Override
    public boolean initDB(String mysqlUrl, String schema, String username, String password) throws Exception{
        System.out.println("oracle1111");
        return InitDBUtil.initDB(mysqlUrl,schema,username,password);
    }
}
