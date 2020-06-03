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

    /**
     * @Pointcut声明了切点（这里的切点是我们自定义的注解类），
     */
    @Pointcut("@annotation(com.pangu.monitor.rest.RestCostTime)")
    private void annotationPointcut() {}


    @Around("annotationPointcut()")
    public Object process(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is around");
        long start = System.currentTimeMillis();
        System.out.println("around time:" + start);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("<=====================================================");
        logger.info("请求来源： =》" + request.getRemoteAddr());
        logger.info("请求URL：" + request.getRequestURL().toString());
        logger.info("请求方式：" + request.getMethod());
        logger.info("响应方法：" + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        logger.info("请求参数：" + Arrays.toString(pjp.getArgs()));
        logger.info("------------------------------------------------------");
        // 3.获取方法相关信息
        MethodSignature methodSignature =  (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String methodStr = pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
        logger.info("请求方法: " + methodStr);
        Object result = pjp.proceed();
        logger.info("请求结束,耗时{}毫秒，响应参数：{}",System.currentTimeMillis() - start,result);
        return result;
    }

    @After("annotationPointcut()")
    public void after(){
        System.out.println("方法之后执行...after.");
    }

}
