package com.mo.bao.controller;

import com.mo.bao.wechat.WeChatMessageService;
import com.mo.bao.wechat.WeChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hadoop on 2016/10/22.
 */
@RestController
public class WeChatController {

    @Autowired
    private WeChatService weChatService;
    @Autowired
    private WeChatMessageService weChatMessageService;

    private static final String WE_CHAT_GET = "GET";

    private static final String WE_CHAT_POST = "POST";

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET, RequestMethod.POST})
    String home(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String resultStr = null;

        String method =  request.getMethod();

        if ( WE_CHAT_GET.equals(method) ){
            // 微信加密签名
            String signature = request.getParameter("signature");

            // 时间戳
            String timestamp = request.getParameter("timestamp");

            // 随机数
            String nonce = request.getParameter("nonce");

            // 随机字符串
            String echostr = request.getParameter("echostr");

            if (StringUtils.isNotEmpty(signature)  && StringUtils.isNotEmpty(timestamp)
                    && StringUtils.isNotEmpty(nonce) && weChatService.checkSignature(signature,timestamp,nonce)) {
                resultStr = echostr;
                System.out.println("[RESPONSE]");
                System.out.println(echostr);
            }
        } else if (WE_CHAT_POST.equals(method)){

            // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
            request.setCharacterEncoding("UTF-8");

            StringBuilder sb = new StringBuilder();

            BufferedReader br = request.getReader();

            String line = br.readLine();

            while (line != null) {
                sb.append(line);

                line = br.readLine();
            }

            System.out.println("[POST]");
            System.out.println(sb.toString());

            response.setContentType("text/html;charset=UTF-8");

            // 调用核心业务类接收消息、处理消息
            String responseStr = weChatMessageService.processRequest(sb.toString(), true);

            // 响应消息
            PrintWriter out = response.getWriter();

            out.print(responseStr);

            out.close();
            out = null;

            System.out.println("[RESPONSE]");
            System.out.println(responseStr);

        }

        return resultStr;
    }






}
