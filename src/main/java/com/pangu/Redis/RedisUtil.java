package com.pangu.Redis;

import com.pangu.Base.Context.PanguApplicationContext;
import com.pangu.PanguApplication;
import redis.clients.jedis.Jedis;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 16:38
 * @desc: redis读取辅助类
 */
public class RedisUtil {

    private static Jedis jedis = PanguApplicationContext.getBean("jedisResource");

    public static void set(String key, String value) {
        jedis.set(key,value);
    }

    public static String get(String key){
        return jedis.get(key);
    }

}
