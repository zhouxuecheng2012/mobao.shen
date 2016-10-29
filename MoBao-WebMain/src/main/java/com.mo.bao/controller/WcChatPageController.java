package com.mo.bao.controller;

import com.mo.bao.wechat.WeChatActionService;
import com.mo.bao.wechat.WeChatService;
import com.mo.bao.wechat.weixin.AccessToken;
import com.mo.bao.wechat.weixin.JsapiSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hadoop on 2016/10/22.
 */
@Controller
public class WcChatPageController {

    @Autowired
    private WeChatActionService chatActionService;

    @Autowired
    private WeChatService weChatService;

    @GetMapping(value = "/list")
    public String list(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURL().toString();
        System.out.println(url);
        String code = request.getParameter("code");
        System.out.println(code);

        String openId = chatActionService.getOpenId(code);
        System.out.println(openId);
        AccessToken jsApiToke  = chatActionService.getJsApiTicket();
        JsapiSign jsapiSign = weChatService.genJsapiSign(jsApiToke,request);
        System.out.println(jsapiSign);
        return "list";
    }

    @GetMapping(value = "/list1")
    public String list1(HttpServletRequest request, HttpServletResponse response) {

        String code = request.getParameter("code");
        System.out.println(code);


        String openId = chatActionService.getOpenId(code);
        System.out.println(openId);
        return "list1";
    }

    @GetMapping(value = "/list2")
    public String list2(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        System.out.println(code);

        String openId = chatActionService.getOpenId(code);
        System.out.println(openId);
        return "list2";
    }

}
