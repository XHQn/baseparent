package com.saasMode.utils;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InitDBUtil {
    private static final String jdbcurlTemplate = "jdbc:mysql://#{mysqlUrl}/mysql?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
    private static final String driverClass = "com.mysql.jdbc.Driver";
    private static final String dropSchemaSqlTemplate = "drop database if exists #{schema}";
    private static final String createSchemaSqlTemplate = "CREATE DATABASE #{schema} DEFAULT CHARSET utf8 COLLATE utf8_general_ci";
    private static final String useSchemaSqlTemplate = "use #{schema}";

    public static boolean initDB(String mysqlUrl,String schema,String username,String password) throws Exception{
        Connection connection = null;
        Class.forName(driverClass);
        connection = DriverManager.getConnection(jdbcurlTemplate.replace("#{mysqlUrl}", mysqlUrl ), username, password);
        Statement statement = connection.createStatement();
        statement.execute(dropSchemaSqlTemplate.replace("#{schema}",schema));
        statement.execute(createSchemaSqlTemplate.replace("#{schema}",schema));
        statement.execute(useSchemaSqlTemplate.replace("#{schema}",schema));

        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setStopOnError(true);

        ClassPathResource classPathResource = new ClassPathResource("templatesql.sql");
        InputStream inputStream = classPathResource.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        scriptRunner.runScript(isr);
        return true;

    }
}
