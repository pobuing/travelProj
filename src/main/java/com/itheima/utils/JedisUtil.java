package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author wangxin
 * @date 2019/12/1 00:40
 * @description: TODO
 * GOOD LUCK！
 * Jredis工具类
 */
public class JedisUtil {
    static {
        //创建配置JedisConfig
        JedisPoolConfig config = new JedisPoolConfig();
        //配置最大连接数
        config.setMaxTotal(100);
        config.setMaxIdle(50);//设置最大空闲连接数
        config.setMinIdle(20);//设置最小连接数
        //创建JedisPool
        jedisPool = new JedisPool(config, "localhost", 6379);

    }

    private static JedisPool jedisPool;

    /**
     * 获取Jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
