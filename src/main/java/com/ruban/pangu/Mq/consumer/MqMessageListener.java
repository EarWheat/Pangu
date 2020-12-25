package com.ruban.pangu.Mq.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-18 18:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface MqMessageListener {
    Object exec(ConsumerRecord<String, String> record);
}
