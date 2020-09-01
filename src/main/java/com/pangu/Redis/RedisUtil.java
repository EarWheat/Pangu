package com.pangu.Redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 16:38
 * @desc: redis读取辅助类
 */
@Component
public class RedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private RedisPool redisPool;

    private static Jedis jedis = null;

    RedisUtil(){
        jedis = redisPool.getJedis();
    }

    // redis读
    public static String get(String key){
//        return "hello";
        return jedis.get(key);
    }

    // redis写
    public static String set(String key, String value){
        new RedisUtil();
        return jedis.set(key,value);
    }
}
