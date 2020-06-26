package com.pangu.monitor.scheduled.annotation;

import com.pangu.monitor.rest.RestInfoAnnotation;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-23 20:09
 * @desc:
 */
@Target({ElementType.TYPE,  ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented


@Import({MonitorAnnotation.class})
public @interface Monitor {
    String pattern() default "";
}
