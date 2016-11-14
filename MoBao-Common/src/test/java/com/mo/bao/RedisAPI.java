package com.mo.bao;

import redis.clients.jedis.Jedis;

/**
 * Created by hadoop on 2016/11/8.
 */
public class RedisAPI {

    public static void main(String[] args) {
//	      //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.1.123", 6379);
        System.out.println("Connection to server sucessfully");
        //查看服务是否运行
        //System.out.println("Server is running: "+jedis.ping());
        System.out.println("增加key111:" + jedis.set("key111", "hello world"));
        System.out.println("输出key111:" + jedis.get("key111"));
        //System.out.println(RedisClient.getRedisClient().getShardedJedis());
        //System.out.println(RedisClient.getRedisClient().getJedis());

    }

}
