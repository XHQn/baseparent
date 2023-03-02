package com.esd.auth.util;

public class ProcessStringUtil {

    public boolean isNotNull(String str){
        if (str != null && !"".equals(str) && !"null".equals(str)){
            return true;
        }
        return false;
    }
}
