package com.ruban.pangu.Mq.consumer;

import com.ruban.pangu.Util.PropertiesUtil;
import lombok.Data;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties(prefix = "kafka")
public class MqMessageProperties {

    // 获取配置文件
    private String topic;
    private String group;
    private String servers;
    private String autoCommit;
    private String autoCommitInterval;
    private String sessionTimeOut;
    private String autoOffsetReset;

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
