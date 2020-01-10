package com.pangu;

import com.pangu.springContext.Config;
import com.pangu.springContext.MqMessageListenerConfig;
import com.pangu.springContext.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-26 19:27
 * @desc:
 */
@SpringBootApplication
public class PanguApplication {
    public static void main(String[] args) throws ClassNotFoundException {
        // 注入上下文信息
        ApplicationContext context = SpringApplication.run(PanguApplication.class, args);
        SpringContextUtil.setApplicationContext(context);
        Config config = (Config)context.getBean("configDemoBean");
        System.out.println(config.getName());
        context.getEnvironment();
        context.getApplicationName();
        MqMessageListenerConfig mqMessageListenerConfig = Class.forName("com.pangu.springContext.MqMessageListenerConfig").getAnnotation(MqMessageListenerConfig.class);
        System.out.println(mqMessageListenerConfig.consumerGroup());
    }
}
