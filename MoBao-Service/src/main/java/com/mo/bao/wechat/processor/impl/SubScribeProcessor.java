package com.mo.bao.wechat.processor.impl;


import com.mo.bao.wechat.WeChatActionService;
import com.mo.bao.wechat.processor.Processor;
import com.mo.bao.wechat.request.event.RequestEventSubscribe;
import com.mo.bao.wechat.response.ResponseText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubScribeProcessor implements Processor<RequestEventSubscribe> {

    @Autowired
    private WeChatActionService chatActionService;

    @Override
    public String doProcess(RequestEventSubscribe request) {
        String userBindUrl = "http://dwz.cn/1KTZKx";
        String downloadUrl = "http://dwz.cn/1KU12W";
        String listCtxUrl = "http://dwz.cn/1KTYQ2";
        String writeMatchUrl = "http://dwz.cn/2aOV1V";
        String testUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";

        StringBuilder sb = new StringBuilder();

        sb.append("Hi，唯分期感谢您的关注！/:rose/:rose请投上您宝贵的一票：");
        sb.append("\n\n");
        sb.append("第1步：点击【<a href=\"" + testUrl + "\">绑定公众号</a>】");
        sb.append("\n\n");
        sb.append("第2步：点击【<a href=\"" + testUrl + "\">参加抽奖</a>】，即可抽奖");

        ResponseText response = new ResponseText();

        response.setToUserName(request.getFromUserName());
        response.setFromUserName(request.getToUserName());
        response.setCreateTime(System.currentTimeMillis());
        response.setContent(sb.toString());

        chatActionService.getWeChatUserInfo(request.getFromUserName());

        return response.toXmlString();
    }
}
