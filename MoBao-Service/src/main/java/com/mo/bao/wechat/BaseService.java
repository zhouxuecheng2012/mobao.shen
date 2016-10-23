package com.mo.bao.wechat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hadoop on 2016/10/23.
 */
public class BaseService {

    protected String getResponse(String urlStr, String param) {
        try {
            BufferedReader in = null;
            String result = "";
            URL url = new URL(urlStr);

            // 打开和URL之间的连接
            URLConnection conn = url.openConnection();

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.getOutputStream().write(param.getBytes());
            conn.getOutputStream().flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;

            while ((line = in.readLine()) != null) {
                result += line;
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
