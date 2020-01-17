package com.pangu.mq;

import com.pangu.springContext.MqMessageListenerConfig;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-17 16:52
 * @desc:
 */
@MqMessageListenerConfig(topic = "mqTopic", consumerGroup = "mqGroup")
public class MqConfig {
}
