package com.saasMode.service.initdb;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class InitCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            System.out.println(metadata.getAnnotations());

            String [] arry = context.getRegistry().getBeanDefinitionNames();
            for (String s : arry) {
                System.out.println(s);
            }
            Object object =context.getBeanFactory().getBean("initDataBase");
            System.out.println("=========");
            return false;
        }catch (Exception e){
//            e.printStackTrace();
            return true;
        }

    }
}