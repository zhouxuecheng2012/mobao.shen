package com.mo.bao.wechat.impl;

import com.mo.bao.wechat.BaseService;
import com.mo.bao.wechat.WeChatActionService;
import com.mo.bao.wechat.weixin.AccessToken;
import com.mo.bao.wechat.weixin.WeChatUserInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 2016/10/23.
 */
@Service
public class WeChatActionServiceImpl extends BaseService implements WeChatActionService {

    public static final String APP_ID = "wx0672e57188e245a5";
    public static final String APP_SECRET = "7f2ba0e49870d080dabac46d7a19fc42";

    private String access_token_key = "MicroMsgAccessToken";
    private String jsapi_ticket_key = "MicroMsgJsapiTicket";

    @Autowired
    private RedisTemplate<String, AccessToken> objectRedisTemplate;


    @Override
    public AccessToken getAccessToken() {
        AccessToken accessToken = objectRedisTemplate.opsForValue().get(access_token_key);

        boolean fetch = false;

        if (accessToken == null ){
            fetch = true;
        } else {
            if (accessToken.getExpire().longValue() < System.currentTimeMillis()) {
                fetch = true;
            }
        }

        if (fetch) {
            accessToken = fetchAccessToken();

            if (accessToken != null) {

                objectRedisTemplate.opsForValue().set(access_token_key,accessToken);
            }

        }

        return accessToken;
    }


    private AccessToken fetchAccessToken() {
        System.out.println("fetchAccessToken:");

        String urlstr = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;

        String response = getResponse(urlstr, "");

        if (response == null) {
            return null;
        }

        JSONObject jso = JSONObject.fromObject(response);

        if (!jso.containsKey("access_token")) {
            int errorcode = jso.getInt("errcode");
            String errormsg = jso.getString("errmsg");

            System.out.println("error(" + errorcode + "):" + errormsg);

            return null;
        }

        AccessToken token = new AccessToken();

        token.setAccessToken(jso.getString("access_token"));
        token.setExpire(System.currentTimeMillis() + jso.getInt("expires_in") * 1000L);
        token.setAppId(APP_ID);

        System.out.println("token:" + token.getAccessToken() + ",expire:" + token.getExpire());

        return token;
    }


    @Override
    public AccessToken getJsApiTicket() {
        AccessToken accessToken = objectRedisTemplate.opsForValue().get(jsapi_ticket_key);

        boolean fetch = false;

        if (accessToken == null ){
            fetch = true;
        } else {
            if (accessToken.getExpire().longValue() < System.currentTimeMillis()) {
                fetch = true;
            }
        }

        if (fetch) {
            accessToken = fetchJsapiTicket();

            if (accessToken != null) {

                objectRedisTemplate.opsForValue().set(jsapi_ticket_key,accessToken);
            }

        }

        return accessToken;
    }

    @Override
    public WeChatUserInfo getWeChatUserInfo(String openId) {

        WeChatUserInfo chatUserInfo = new WeChatUserInfo();
        AccessToken token = getAccessToken();
        String urlstr = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+token.getAccessToken()+"&openid="+openId+"&lang=zh_CN ";
        String response = getResponse(urlstr, "");

        System.out.println(response);

        return chatUserInfo;
    }

    private AccessToken fetchJsapiTicket() {
        System.out.println("fetchJsapiTicket:");

        AccessToken accessToken = getAccessToken();

        if (accessToken == null) {
            System.out.println("can't find access token");

            return null;
        }

        String urlstr = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken.getAccessToken() + "&type=jsapi";

        String response = getResponse(urlstr, "");

        if (response == null) {
            return null;
        }

        JSONObject jso = JSONObject.fromObject(response);

        try {
            int errorcode = jso.getInt("errcode");
            String errormsg = jso.getString("errmsg");
            String ticket = jso.getString("ticket");
            int expire = jso.getInt("expires_in");

            if (errorcode == 0) {
                AccessToken token = new AccessToken();

                token.setAccessToken(ticket);
                token.setExpire(System.currentTimeMillis() + expire * 1000L);
                token.setAppId(APP_ID);

                System.out.println("ticket:" + token.getAccessToken() + ",expire:" + token.getExpire());

                return token;
            } else {
                System.out.println("error(" + errorcode + "):" + errormsg);

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        String k1 = "k1";
        String v1 = "v1";

        AccessToken accessToken = new AccessToken();
        accessToken.setAppId("11");
        accessToken.setAccessToken("asfafasf");

        objectRedisTemplate.opsForValue().set(k1, accessToken);

        AccessToken result_v2 = (AccessToken) objectRedisTemplate.opsForValue().get(k1);
        System.out.println(result_v2);

    }

}