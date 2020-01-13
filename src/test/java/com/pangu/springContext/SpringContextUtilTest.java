package com.pangu.springContext;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

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
            MqMessageListenerConfig mqMessageListenerConfig = Class.forName("com.pangu.springContext.MqMessageListenerConfig").getAnnotation(MqMessageListenerConfig.class);
            System.out.println(mqMessageListenerConfig.consumerGroup());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}