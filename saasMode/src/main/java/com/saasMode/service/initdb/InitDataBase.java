package com.saasMode.service.initdb;

import org.springframework.stereotype.Component;

public interface InitDataBase {

    /**
     * 初始化数据库接口
     * @param mysqlUrl
     * @param schema
     * @param username
     * @param password
     * @return
     */
    boolean initDB(String mysqlUrl,String schema,String username,String password)  throws Exception;

}
