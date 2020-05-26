package com.pangu.monitor.rest;

import com.pangu.annotation.AnnotationDemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 16:34
 * @desc:
 */
@Component
@Aspect
public class RestCostTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(RestCostTimeAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * @Pointcut声明了切点（这里的切点是我们自定义的注解类），
     */
    @Pointcut("@annotation(RestCostTime)")
    private void restCostTimePointcut() {}

    @Before("restCostTimePointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        long start = System.currentTimeMillis();
        logger.info(method+" startTime:" + start);
        System.out.println(method+" startTime:" + start);
        startTime.set(start);
    }

    @After("restCostTimePointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        long endTime = System.currentTimeMillis();
        logger.info(method + " endTime:" + endTime);
        logger.info(method + " costTime:" + (endTime - startTime.get()));
        System.out.println(method + " endTime:" + endTime);
        System.out.println(method + " costTime:" + (endTime - startTime.get()));
    }
}
