package com.pangu.Redis;

import com.pangu.Http.request.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 下午5:16
 * @desc redis连接池
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisPoolContainer {
    private static final Logger logger = LoggerFactory.getLogger(RedisPoolContainer.class);

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public JedisPool redisPoolFactory(){
        JedisPool jedisPool = null;
        try {
            String host = redisProperties.getHost();
            int port = Integer.parseInt(redisProperties.getPort());
            int timeout = Integer.parseInt(redisProperties.getTimeout());
            String password = redisProperties.getPassword();
            Map<String, RedisProperties.JedisPoolConfiguration> map = redisProperties.getJedis();
            RedisProperties.JedisPoolConfiguration jedisPoolConfiguration = map.get("pool");
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(jedisPoolConfiguration.getMaxIdle());
            jedisPoolConfig.setMaxWaitMillis(jedisPoolConfiguration.getMaxWait());
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        } catch (Exception e) {
            logger.error("Jedis pool initialize error:" + e);
        }
        return jedisPool;
    }

}
