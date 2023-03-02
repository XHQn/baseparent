package com.esd.auth.exception;

import com.esd.auth.StartHandler;
import com.esd.auth.vo.RespBean;
import com.esd.auth.vo.RespBeanEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理类
 *
 * @author: LC
 * @date 2022/3/2 5:33 下午
 * @ClassName: GlobalExceptionHandler
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(StartHandler.class);
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return RespBean.error(exception.getRespBeanEnum());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常：" + bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        e.printStackTrace();
        System.out.println("异常信息" + e);
        LOG.error("异常信息" + e);
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
