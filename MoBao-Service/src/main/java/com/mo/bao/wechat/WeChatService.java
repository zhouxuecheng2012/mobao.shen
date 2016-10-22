package com.mo.bao.wechat;

/**
 * Created by hadoop on 2016/10/22.
 */
public interface WeChatService {

   boolean checkSignature(String signature, String timestamp, String nonce);

}
