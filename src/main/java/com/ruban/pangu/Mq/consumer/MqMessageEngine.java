package com.ruban.pangu.Mq.consumer;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

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
@Component
public class MqMessageEngine{

    // 获取配置文件
    private StringValueResolver stringValueResolver;

    MqMessageEngine() {
//        MqMessageProperties mqMessageProperties = new MqMessageProperties();
//        System.out.println("=====" + mqMessageProperties.toString());
    }


}
