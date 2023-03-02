package com.baseCommon.readPropFile;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
 
import java.util.Properties;
 
/**
 * Created by Tiger on 2018/10/10.
 * 读取公共apollo配置
 */
public class PropertiesUtils {
    private static final String COMMON = "application";
    public static Properties properties = new Properties();

    public static String getValue(String targetKey){
        String targetValue = "";
        Config commonConfig = ConfigService.getConfig(COMMON);
        if (commonConfig != null) {
            targetValue = commonConfig.getProperty(targetKey,null);
            for (String key : commonConfig.getPropertyNames()) {
                properties.setProperty(key, commonConfig.getProperty(key, null));
            }
        }
        return targetValue;
    }

}