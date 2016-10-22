package com.mo.bao.wechat;

/**
 * Created by hadoop on 2016/10/22.
 */
public interface WeChatMessageService {

    public String processRequest(String requestStr, boolean sync);

}
