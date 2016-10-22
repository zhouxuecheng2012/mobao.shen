package com.mo.bao.wechat.impl;

import com.mo.bao.wechat.WeChatService;
import com.mo.bao.wechat.weixin.AccessToken;
import com.mo.bao.wechat.weixin.JsapiSign;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by hadoop on 2016/10/22.
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    // 与接口配置信息中的Token要一致
    private String	token	= "MoBaoTest";

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] { token, timestamp, nonce };

        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);

        StringBuilder content = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }

        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");

            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());

            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        content = null;

        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private String byteToStr(byte[] byteArray) {
        String strDigest = "";

        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }

        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);

        return s;
    }

    /**
     * 生成jsapi签名
     *
     * @param jsapi_ticket
     *            jsapi_ticket
     * @param url
     *            页面url
     * @return jsapi签名
     */
    private Map<String, String> signJsapi(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        // 注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
        System.out.println(string1);

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    /**
     * 生成jsapi签名
     *
     * @param jsapi_ticket
     *            jsapi_ticket
     * @param request
     *            HttpServletRequest
     *
     * @return jsapi签名
     */
    public JsapiSign genJsapiSign(AccessToken jsapi_ticket, HttpServletRequest request) {
        String url = request.getRequestURL().toString();

        if (request.getQueryString() != null) {
            url += ("?" + request.getQueryString());
        }

        return genJsapiSign(jsapi_ticket, url);
    }

    /**
     * 生成jsapi签名
     *
     * @param jsapi_ticket
     *            jsapi_ticket
     * @param url
     *            分享url
     *
     * @return jsapi签名
     */
    public JsapiSign genJsapiSign(AccessToken jsapi_ticket, String url) {
        JsapiSign sign = new JsapiSign();

        try {
            Map<String, String> signResult = signJsapi(jsapi_ticket.getAccessToken(), url);

            sign.setAppId(jsapi_ticket.getAppId());
            sign.setTimestamp(signResult.get("timestamp"));
            sign.setNonceStr(signResult.get("nonceStr"));
            sign.setSignature(signResult.get("signature"));
            sign.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sign;
    }

    /**
     * 字节数组转十六进制字符串
     *
     * @param hash
     *            字节数组
     * @return 十六进制字符串
     */
    private String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 生成随机字符串
     *
     * @return 随机字符串
     */
    private String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成时间戳
     *
     * @return 时间戳
     */
    private String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
