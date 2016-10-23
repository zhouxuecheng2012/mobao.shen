package com.mo.bao.wechat.impl;

import com.mo.bao.wechat.WeChatActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2016/10/23.
 */
@Service
public class WeChatActionServiceImpl implements WeChatActionService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void afterPropertiesSet() throws Exception {
        String k1 = "k1";
        String v1 = "v1";

        redisTemplate.opsForValue().set(k1,v1);

        String result_v1 = (String) redisTemplate.opsForValue().get(k1);
        System.out.println(result_v1);

    }
}
