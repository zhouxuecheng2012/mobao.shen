package com.mo.bao.wechat;

import com.mo.bao.wechat.weixin.AccessToken;
import com.mo.bao.wechat.weixin.JsapiSign;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hadoop on 2016/10/22.
 */
public interface WeChatService {

   boolean checkSignature(String signature, String timestamp, String nonce);

   JsapiSign genJsapiSign(AccessToken jsapi_ticket, HttpServletRequest request);

}
