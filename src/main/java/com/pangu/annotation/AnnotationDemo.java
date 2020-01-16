package com.pangu.annotation;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-16 16:02
 * @desc:自定义注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationDemo {
    String value() default "";
}
