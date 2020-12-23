package com.ruban.pangu.springContext;

import com.ruban.pangu.Mq.consumer.MqMessageListenerConfig;
import org.junit.jupiter.api.Test;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-10 15:25
 * @desc:
 */
class SpringContextUtilTest {

    @Test
    void setApplicationContext() {
    }

    @Test
    void getApplicationContext() {
    }

    @Test
    void getBean() {
    }

    @Test
    void testGetBean() {
    }

    @Test
    void testGetBean1() {
    }

    private static void main(String[] args){
        System.out.println("hello application Text");
        Config config = (Config)SpringContextUtil.getBean("configDemoBean");
        System.out.println(config.getName());
        try {
            MqMessageListenerConfig mqMessageListenerConfig = Class.forName("com.ruban.pangu.Mq.consumer.MqMessageListenerConfig").getAnnotation(MqMessageListenerConfig.class);
            System.out.println(mqMessageListenerConfig.consumerGroup());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}