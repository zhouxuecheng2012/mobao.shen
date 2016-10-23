package com.mo.bao.wechat;

import com.mo.bao.wechat.weixin.AccessToken;
import com.mo.bao.wechat.weixin.WeChatUserInfo;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by hadoop on 2016/10/23.
 */
public interface WeChatActionService extends InitializingBean {

    /**
     * 查询当前AccessToken
     *
     * @return AccessToken
     */
    public AccessToken getAccessToken();

    /**
     * 查询当前JsapiTicket
     *
     * @return JsapiTicket
     */
    public AccessToken getJsApiTicket();

    WeChatUserInfo getWeChatUserInfo(String openId);




}
