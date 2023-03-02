package com.baseCommon.customCondition;

import com.baseCommon.readPropFile.PropertiesUtils;
import com.baseCommon.readPropFile.ReadProp;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.stereotype.Component;

public class DefaultLoadCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Boolean enbleDefult = true;
        try {
            ClassMetadata classMetadata = (ClassMetadata)metadata;
            String targetValue = ReadProp.getProp("my.custom." + classMetadata.getClassName());
            System.out.println("默认名称："+ "my.custom." + classMetadata.getClassName());
            if ("false".equals(targetValue)){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return enbleDefult;
        }
        System.out.println(enbleDefult);
        return enbleDefult;
    }
}