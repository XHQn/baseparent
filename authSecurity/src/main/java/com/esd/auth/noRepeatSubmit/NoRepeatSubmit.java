package com.esd.auth.noRepeatSubmit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Tzeao
 */
@Target(ElementType.METHOD) // 作用到方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface NoRepeatSubmit {
 
    //名称，如果不给就是要默认的
    long delaySeconds() default 0l;
}