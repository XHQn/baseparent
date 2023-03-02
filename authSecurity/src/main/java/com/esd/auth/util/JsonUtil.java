package com.esd.auth.util;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {


    public Long getLong(JSONObject jsonObject,String key){
        if (jsonObject != null && jsonObject.containsKey(key)){
            return jsonObject.getLong(key);
        }
        return 9999l;
    }

}
