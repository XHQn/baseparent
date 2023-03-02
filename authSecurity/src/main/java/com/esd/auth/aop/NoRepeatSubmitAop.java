package com.esd.auth.aop;

import com.esd.auth.noRepeatSubmit.NoRepeatSubmit;
import com.esd.auth.noRepeatSubmit.RedisService;
import com.esd.auth.vo.RespBean;
import com.esd.auth.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author 张亚洋
 */
@Aspect
@Component
@Slf4j
public class NoRepeatSubmitAop {
 
    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.esd.auth.noRepeatSubmit.NoRepeatSubmit)")
    public void pt() {
    }
 
    @Around("pt()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object object;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        NoRepeatSubmit annotation = method.getAnnotation(NoRepeatSubmit.class);
        long delaySeconds = annotation.delaySeconds();
        if(attributes == null){
            return RespBean.error(RespBeanEnum.ACCESS_LIMIT_REACHED);
        }
        //这里是唯一标识 根据情况而定
        HttpServletRequest request = attributes.getRequest();
        String only_key = request.getServletPath();
        only_key = only_key + request.getHeader("cookie");
        only_key = only_key + request.getHeader("x-forwarded-for");
        only_key = only_key +request.getHeader("Proxy-Client-IP");
        only_key = only_key +request.getHeader("WL-Proxy-Client-IP");
        only_key = only_key +request.getRemoteAddr();
        // 如果缓存中有这个url视为重复提交
        if (!haskey(only_key)) {
            //通过，执行下一步
            Object o = joinPoint.proceed();
            //然后存入redis 并且设置15s倒计时
            redisService.setCacheObject(only_key, "0", delaySeconds, TimeUnit.MILLISECONDS);
            //返回结果
            object = o;
        } else {
            return RespBean.error(RespBeanEnum.ACCESS_LIMIT_REACHED);
        }
        return object;
    }

    public boolean haskey(String only_key){
        String lockKey = "repeatedSubmission";
        Lock lock = redisLockRegistry.obtain(lockKey);  //获取锁资源
        try {
            lock.lock();   //加锁
            return redisService.haskey(only_key);
        } finally {
            lock.unlock();   //释放锁
        }
    }
}