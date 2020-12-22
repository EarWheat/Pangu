package com.ruban.pangu.controller;

import com.ruban.pangu.Mq.MqMessageListener;
import com.ruban.pangu.Mq.MqMessageListenerConfig;
import com.ruban.pangu.http.response.RestResult;
import org.springframework.stereotype.Component;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-21 19:41
 * @desc mq消费测试类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@MqMessageListenerConfig(topic = "pangu", consumerGroup = "zero")
@Component
public class MqListenerController implements MqMessageListener {

    public RestResult consumer(Object object){
        return RestResult.successResult();
    }

    @Override
    public Boolean exec() {
        return null;
    }
}
