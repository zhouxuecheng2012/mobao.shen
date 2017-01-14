package com.mo.bao.demo;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hadoop on 2016/11/20.
 */
public class JedisPoolDemo {

    private static JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(1000);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        pool = new JedisPool(config, "192.168.1.123", 6379);
    }

    public static void main(String args[]) {



    }

}
