package com.mo.bao.wechat.impl;

import com.mo.bao.wechat.WeChatService;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2016/10/22.
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    private String	token	= "MoBao";

    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {

        System.out.println("check signature");

        return false;
    }
}
