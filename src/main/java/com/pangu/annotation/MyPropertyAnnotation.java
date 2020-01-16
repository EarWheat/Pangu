package com.pangu.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-16 17:09
 * @desc: 自定义注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Import({MyBeanDefinitionRegistrar.class})
public @interface MyPropertyAnnotation {

    String name() default "";
    int age()  default 0;
}
