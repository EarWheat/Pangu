package com.pangu.monitor.rest;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-04 20:49
 * @desc:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented


@Import({RestInfoAnnotation.class})
public @interface RestInfo {
}
