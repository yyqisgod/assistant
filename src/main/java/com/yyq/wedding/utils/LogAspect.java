package com.yyq.wedding.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 日志切面
 * by yangliu
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectError error;

    @Pointcut("execution(* com.yyq.wedding.wechat..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();
        logger.debug("-------------------用户发起请求-----------------");
        logger.debug("IP : " + request.getRemoteAddr());
        logger.debug("请求方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());


    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        logger.debug("------------------请求结束------------------");
    }


}
