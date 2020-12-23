package com.ruban.pangu.Mq.consumer;

import com.ruban.pangu.Util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 14:47
 * @desc mq引擎类，执行mq消费
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MqMessageEngine{

    @Autowired
    private PropertiesUtil propertiesUtil;

    MqMessageEngine(MqMessageProperties mqMessageProperties) {
        System.out.println("=====mqMessageProperties:" + mqMessageProperties.toString());
    }

    @Bean
    public MqMessageProperties mqMessageProperties(){
        return new MqMessageProperties();
    }



}
