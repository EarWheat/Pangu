package com.pangu.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 16:38
 * @desc: redis读取辅助类
 */
@Component
public class RedisUtil {

//    private static final Jedis jedis = RedisPool.getJedis();

    RedisUtil(){
    }

    // redis读
    public static String get(String key){
        return "hello";
//        return jedis.get(key);
    }

    // redis写
    public static void set(String key, String value){
//        jedis.set(key,value);
    }
}
