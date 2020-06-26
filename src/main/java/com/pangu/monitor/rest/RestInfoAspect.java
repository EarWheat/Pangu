package com.pangu.monitor.rest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-23 14:32
 * @desc:@RestInfo注解切面类
 */
@Component
@Aspect
public class RestInfoAspect {

    private static final Logger logger = LoggerFactory.getLogger(RestInfoAspect.class);
    /**
     * @Pointcut声明了切点（这里的切点是我们自定义的注解类），
     */
    @Pointcut("@annotation(com.pangu.monitor.rest.RestInfo)")
    private void restInfoPointcut() {}

    @Around("restInfoPointcut()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        map.put("requestRemoteAddr",request.getRemoteAddr());
        map.put("requestUrl",request.getRequestURL().toString());
        map.put("requestMethod", request.getMethod());
        map.put("requestParam", Arrays.toString(pjp.getArgs()));
        map.put("requestCostTime", String.valueOf(System.currentTimeMillis() - start));
//        mailService.sendSimpleMail("554725722@qq.com","RestInfoMonitor",map.toString());
        Object result = pjp.proceed();
        System.out.println("requestCostTime:" + (System.currentTimeMillis() - start));
        logger.info("requestCostTime:" + (System.currentTimeMillis() - start));
        logger.info("============"+map.toString());
        return result;
    }

    @After("restInfoPointcut()")
    public void after(){
        System.out.println("方法之后执行...after.");
    }
}
