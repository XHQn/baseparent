package com.baseCommon.readPropFile;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class ReadProp {

    public static String getProp(String targetKey) throws Exception{
        Properties properties = null;
        properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
        String apolloMeta = properties.getProperty("apollo.meta");

        if (apolloMeta != null && !"".equals(apolloMeta)){
            return PropertiesUtils.getValue(targetKey);
        }
        return properties.getProperty(targetKey);
    }
}
