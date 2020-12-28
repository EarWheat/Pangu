package com.pangu.Redis;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-26 15:59
 * @desc: redis连接池
 */
//@Component
//public class RedisPool {
//
//    private static final Logger logger = LoggerFactory.getLogger(RedisPool.class);
//
//    @Value("${spring.redis.from}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private Integer port;
//
//    @Value("${spring.redis.timeout}")
//    private Integer timeout;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    private static JedisPool jedisPool; // jedis池
//    private static int maxTotal = 20;  // 最大连接数
//    private static int maxIdle = 10;   // 最大空闲连接数
//    private static int minIdle = 5;    // 最小空闲连接数
//    private static boolean testOnBorrow = true;     //在取连接时测试连接的可用性
//    private static boolean testOnReturn = false;    //再还连接时不测试连接的可用性
//    RedisPool() {
//        initPool();     //初始化连接池
//    }
//
//    public Jedis getJedis(){
//        initPool();
//        return jedisPool.getResource();
//    }
//
//    public void close(Jedis jedis){
//        jedis.close();
//    }
//
//    private void initPool(){
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(maxTotal);
//        config.setMaxIdle(maxIdle);
//        config.setMinIdle(minIdle);
//        config.setTestOnBorrow(testOnBorrow);
//        config.setTestOnReturn(testOnReturn);
//        config.setBlockWhenExhausted(true);
//        logger.info("host:" + host);
//        logger.info("port:" + port);
//        logger.info("password:" + password);
//        jedisPool = new JedisPool(config, host, port, timeout, password);
//    }
//}
