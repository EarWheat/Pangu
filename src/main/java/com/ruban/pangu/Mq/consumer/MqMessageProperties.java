package com.ruban.pangu.Mq.consumer;

import com.ruban.pangu.Util.PropertiesUtil;
import lombok.Data;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 14:51
 * @desc mq配置类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@Component
public class MqMessageProperties {

    @Resource
    private PropertiesUtil propertiesUtil;
    // 获取配置文件
    private String servers;
    private String autoCommit;
    private String autoCommitInterval;
    private String sessionTimeOut;
    private String autoOffsetReset;

    MqMessageProperties(){
        servers = propertiesUtil.getPropertiesValue("kafka.bootstrap.servers");
//        StringBuilder temp = new StringBuilder("${").append("kafka.bootstrap.servers").append("}");
//        servers = stringValueResolver.resolveStringValue(temp.toString());
//        temp.delete(0,temp.length());
//        temp = new StringBuilder("${").append("kafka.enable.auto.commit").append("}");
//        autoCommit = stringValueResolver.resolveStringValue(temp.toString());
        System.out.println("=====bootstrap.servers:"+servers);
//        System.out.println("=====enable.auto.commit:"+servers);
    }

//    public String getPropertiesValue(String key) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000");
//        props.put("auto.offset.reset", "earliest");
//        props.put("key.deserializer", StringDeserializer.class.getName());
//        props.put("value.deserializer", StringDeserializer.class.getName());
//    }
}
