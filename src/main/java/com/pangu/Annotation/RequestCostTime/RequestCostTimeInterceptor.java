package com.pangu.Annotation.RequestCostTime;

import com.pangu.Annotation.Idempotent.ApiIdempotent;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/18 下午6:41
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class RequestCostTimeInterceptor implements HandlerInterceptor {

    ThreadLocal<Long> time = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===============================");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        RequestCostTime requestCostTime = handlerMethod.getMethod().getAnnotation(RequestCostTime.class);
        if (requestCostTime != null) {
            time.set(System.currentTimeMillis());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long endTime = System.currentTimeMillis();
        if(handler instanceof HandlerMethod){
            System.out.println(((HandlerMethod) handler).getMethod().getName() + "cost time:" + (endTime - time.get()));
        }
    }
}
