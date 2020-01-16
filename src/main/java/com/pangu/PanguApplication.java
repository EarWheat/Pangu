package com.pangu;

import com.pangu.springContext.Config;
import com.pangu.springContext.MqMessageListenerConfig;
import com.pangu.springContext.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;

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
        System.out.println("hello application Text");
        Config config = (Config)SpringContextUtil.getBean("configDemoBean");
        System.out.println(config.getName());
        try {
            Field[] fields = config.getClass().getDeclaredFields();
            for(Field field : fields){
                //判断属性是否标注了@ProductAnnotation注解
                boolean fieldHasAnno = field.isAnnotationPresent(MqMessageListenerConfig.class);
                if(fieldHasAnno){
                    //获取@ProductAnnotation注解
                    MqMessageListenerConfig mqMessageListenerConfig = field.getAnnotation(MqMessageListenerConfig.class);
                    //获取@ProductAnnotation注解 参数值
                    String topic = mqMessageListenerConfig.topic();
                    String consumerGroup = mqMessageListenerConfig.consumerGroup();
                    System.out.println(topic);
                    System.out.println(consumerGroup);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
