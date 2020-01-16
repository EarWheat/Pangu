package com.pangu.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-16 16:03
 * @desc:注解切面
 */
@Aspect
@Component
public class AnnotationAspect {

    @Pointcut("@annotation(AnnotationDemo)")
    public void annotationPointcut() {
    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AnnotationDemo annotation = method.getAnnotation(AnnotationDemo.class);
        String value = annotation.value();
        System.out.println("准备"+value);
    }

    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AnnotationDemo annotation = method.getAnnotation(AnnotationDemo.class);
        String value = annotation.value();
        System.out.println("结束"+value);
    }
}
