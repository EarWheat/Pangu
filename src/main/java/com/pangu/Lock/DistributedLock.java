package com.pangu.Lock;

import com.pangu.Redis.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/12 下午4:31
 * @desc 基于lua和Redis实现的分布式锁
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class DistributedLock {
    private static final Logger logger = LoggerFactory.getLogger(DistributedLock.class);
    private static final Long RELEASE_SUCCESS = 1L;
    private static final Long LOCK_EXPIRED = -1L;
    private static final String LOCK_PREFIX = "PANGU_DISTRIBUTED_LOCK_";

    /**
     * 加分布式锁
     * @param key               Key
     * @param timeout           过期时间(ms)
     * @param tryIntervalMillis 轮询的时间间隔(ms)
     * @param retryTimes        重试次数
     * @return
     */
    public static boolean lock(String key, int timeout, long tryIntervalMillis, int retryTimes){
        try{
            final String redisKey = getRedisKey(key);
            Boolean success = RedisUtil.setIfAbsent(redisKey, timeout, "");
            if(success){
                return true;
            } else {
                logger.info("try to get lock {}",redisKey);
                // 重试
                if(retryTimes == 0){
                    return false;
                }
                while (retryTimes > 0){
                    TimeUnit.MILLISECONDS.sleep(tryIntervalMillis);
                    success = RedisUtil.setIfAbsent(redisKey, timeout, "");
                    if(success){
                        return true;
                    }
                    retryTimes--;
                }
                logger.info("get lock error {}", redisKey);
            }
        } catch (Exception e){

        }
        return false;
    }

    /**
     * 解分布式锁
     * @param key
     * @return
     */
    public static boolean unlock(String key){
        try {
            final String redisKey = getRedisKey(key);
            Boolean success = RedisUtil.delKey(redisKey);
            if(success){
                return true;
            }
        } catch (Exception e){
            logger.error("unlock key error: {}", e.toString());
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 获取RedisKey
     *
     * @param key 原始KEY,如果为空,自动生成随机KEY
     * @return
     */
    private static String getRedisKey(String key) {
        //如果都是空那就抛出异常
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("key is null");
        }
        return LOCK_PREFIX + key;
    }

}
