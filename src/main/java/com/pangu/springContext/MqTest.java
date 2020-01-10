package com.pangu.springContext;

import org.springframework.context.ApplicationContext;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-10 17:17
 * @desc:
 */
public class MqTest {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        applicationContext.getBean("MqMessageListenerConfig");
        System.out.println(applicationContext.toString());
    }
}
