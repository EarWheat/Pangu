package com.pangu.monitor.rest;

import com.pangu.annotation.AnnotationDemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

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
    @Pointcut("@annotation(com.pangu.monitor.rest.RestCostTime)")
    private void annotationPointcut() {}

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        long start = System.currentTimeMillis();
        logger.info(method+" startTime:" + start);
        System.out.println(method+" startTime:" + start);
        startTime.set(start);
        System.out.println("方法执行前执行......before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<=====================================================");
        logger.info("请求来源： =》" + request.getRemoteAddr());
        logger.info("请求URL：" + request.getRequestURL().toString());
        logger.info("请求方式：" + request.getMethod());
        logger.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
        logger.info("------------------------------------------------------");
        startTime.set(System.currentTimeMillis());
    }

    @Around("annotationPointcut()")
    public void process(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is around");
        System.out.println("around time:" + System.currentTimeMillis());
        startTime.set(System.currentTimeMillis());
        pjp.proceed();
    }

    @AfterReturning("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        long endTime = System.currentTimeMillis();
        logger.info(method + " endTime:" + endTime);
        logger.info(method + " costTime:" + (endTime - startTime.get()));
        System.out.println(method + " endTime:" + endTime);
        System.out.println(method + " costTime:" + (endTime - startTime.get()));
    }


    @After("annotationPointcut()")
    public void after(){
        System.out.println("方法之后执行...after.");
    }

}
