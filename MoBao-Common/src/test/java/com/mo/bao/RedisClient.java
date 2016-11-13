package com.mo.bao;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2016/11/7.
 */
public class RedisClient {

    private JedisPool jedisPool;//非切片连接池
    private ShardedJedisPool shardedJedisPool;//切片连接池

    private static RedisClient redisClient;


    private RedisClient() {
        initialPool();
        initialShardedPool();
    }

    public static RedisClient getRedisClient() {
        if (redisClient == null) {
            synchronized (RedisClient.class) {
                if (redisClient == null) redisClient = new RedisClient();
            }
        }
        return redisClient;
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public ShardedJedis getShardedJedis() {
        return shardedJedisPool.getResource();
    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, "192.168.1.123", 6379);
    }


    /**
     * 初始化切片池
     */
    private void initialShardedPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("192.168.1.123", 6379, "master"));
        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void Close() {
        jedisPool.close();
        shardedJedisPool.close();
    }

}
