package com.ruban.pangu.Mq;

import com.alibaba.fastjson.JSONObject;
import com.ruban.pangu.springContext.Config;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-21 19:34
 * @desc Mq容器类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class MqMessageListenerContainer implements ApplicationContextAware {

    // mq消费容器
    private static Map<String, Map<String, MqMessageListener>> mqMessageListenerMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 找到所有MqMessageListener的类及其子类
        Map<String, MqMessageListener> mqMessageListenerMap = applicationContext.getBeansOfType(MqMessageListener.class);
        if (MapUtils.isEmpty(mqMessageListenerMap)) {
            return;
        }
//        Map<String,Object> annotations = applicationContext.getBeansWithAnnotation(MqMessageListenerConfig.class);
        System.out.println("=====ApplicationContext:"+ mqMessageListenerMap.toString());
        for(Map.Entry mqMessageListenerClazz : mqMessageListenerMap.entrySet()){
            Object clazz = mqMessageListenerClazz.getValue();
            MqMessageListenerConfig mqMessageListenerConfig = AnnotationUtils.findAnnotation(clazz.getClass(),MqMessageListenerConfig.class);
            if(mqMessageListenerConfig != null){
                System.out.println("=======topic:" + mqMessageListenerConfig.topic());
                System.out.println("=======group:" + mqMessageListenerConfig.consumerGroup());
            }
        }
    }
}
