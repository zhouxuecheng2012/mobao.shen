package com.mo.bao;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hadoop on 2016/10/23.
 */
public class WeChatTest {

    private static String getResponse(String urlStr, String param) {
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
            in.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void createMenu(String accessToken){
       // String accessToken = "o2ZD8IhFU-aaM7xJCtY05QgLFE1CyPTULSo_V2t5vXDDQl1zdsDDu-CK8okHJdQNXpvyUu865s8eeJk0mXCUqSDw14mefQKJzeYXLsGs9jFxLxumOkaGzAYnbdellmqbDFPjAJAPRB";


        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken + "";

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject subJsonObject = new JSONObject();
        subJsonObject.put("type","view");
        subJsonObject.put("name","唯分期申请");
        subJsonObject.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");

        jsonArray.add(subJsonObject);

        subJsonObject = new JSONObject();

        subJsonObject.put("type","view");
        subJsonObject.put("name","唯分期账单");
        subJsonObject.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");

        jsonArray.add(subJsonObject);

        subJsonObject = new JSONObject();

        subJsonObject.put("type","view");
        subJsonObject.put("name","唯分期步骤");
        subJsonObject.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list2&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");

        jsonArray.add(subJsonObject);

        jsonObject.put("button",jsonArray);

        String menuJson = jsonObject.toJSONString();
        System.out.println(menuJson);
        String response = getResponse(url, menuJson);

        System.out.println(response);
    }

    private static void sendAllMsg(String accessToken){
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=" + accessToken + "";

        String response = getResponse(url, "{\n" +
                "   \"touser\":[\n" +
                "    \"oTOBVwYHudSt1O3hOYjHEmLQaaGk\",\n" +
                "    \"oTOBVwUlV300yJqEUXS_pqLZUm0g\"\n" +
                "   ],\n" +
                "    \"msgtype\": \"text\",\n" +
                "    \"text\": { \"content\": \"公众号发送消息\"}\n" +
                "}");

        System.out.println(response);
    }


    private static void createTemplate(String accessToken){


        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken + "";

        String response = getResponse(url, "{\n" +
                "           \"touser\":\"oTOBVwYHudSt1O3hOYjHEmLQaaGk\",\n" +
                "           \"template_id\":\"mtVxHMerDzp8NKd037nsczOMEynJrR_MpOMoRGC3v-8\",\n" +
                "           \"url\":\"http://smwechat.s1.natapp.cc/list?core=5\",            \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"恭喜你购买成功！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote1\":{\n" +
                "                       \"value\":\"巧克力\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote2\": {\n" +
                "                       \"value\":\"39.8元\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keynote3\": {\n" +
                "                       \"value\":\"2014年9月22日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }");

        System.out.println(response);
    }

    private static final String appID = "wx0672e57188e245a5";
    private static final String appsecret = "7f2ba0e49870d080dabac46d7a19fc42";

    private static String getAccessToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret+"";

        String response = getResponse(url,"");
        System.out.println(response);

        return response;
    }

    private static String accessToken_all ;

    public static void main(String[] args) throws InterruptedException {
         //String accessToken = "gAX77s4YdITQnZF5chkpR8KpO8FQoZaSH5F4J-NnSKqMMSF5eBe08CGkjtnemQ1z1XXqUJf1Db9yutctNe-Sw9Jn8onGMI13JPdodmU2ob5_NEWNfhAjHuHqyIrCcfpeDNVfACAVFN";
         //String accessToken = "UMH4nOp2JUEdRe7dI-CYib0seC1XpYKFEeyDzawSq8UKDLheTkXzmQ5a3IgFQ-lOOjLclJfy2fMJH0GdP7cmTbOzK5CZMirtn85JK_qRCYAVQKfAAAKFZ";
          String accessToken = getAccessToken();
         //Thread.sleep(60000);
         //createTemplate(accessToken);
          //sendAllMsg(accessToken);
    }

}
