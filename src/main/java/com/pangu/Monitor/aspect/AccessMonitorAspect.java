package com.pangu.Monitor.aspect;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Monitor.accessMonitor.AccessEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/8/17 4:13 下午
 * @desc 请求的切面监控
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Aspect
@Component
@Slf4j
public class AccessMonitorAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void annotationPointcut() {}

    @Around(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doAround(ProceedingJoinPoint point) throws Throwable {

        //获取到请求的属性
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //获取到请求对象
        HttpServletRequest request = attributes.getRequest();

        // 开始时间
        long startTime = System.currentTimeMillis();
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();
        long latency = endTime - startTime;
          AccessEntity.builder()
                .uri(request.getRequestURI())
                .url(request.getRequestURL().toString())
                .from(request.getRemoteAddr())
                .args(point.getArgs())
                .resp(result)
                .latency(latency).build();
    }
}
