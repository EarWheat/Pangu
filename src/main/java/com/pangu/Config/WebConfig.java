package com.pangu.Config;

import com.pangu.Annotation.RequestCostTime.RequestCostTime;
import com.pangu.Annotation.RequestCostTime.RequestCostTimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/6/20 下午5:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
//  @Resource
//  private StopWatchReqHandlerInterceptor stopWatchReqHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器,添加拦截路径和排除拦截路径
        registry.addInterceptor(requestCostTimeInterceptor()).addPathPatterns("/**");

    }


    @Bean
    public RequestCostTimeInterceptor requestCostTimeInterceptor() {
        return new RequestCostTimeInterceptor();
    }
}
