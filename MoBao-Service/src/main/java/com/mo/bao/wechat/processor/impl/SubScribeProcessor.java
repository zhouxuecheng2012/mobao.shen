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
        String testUrl1 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        String testUrl2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0672e57188e245a5&redirect_uri=http://smwechat.s1.natapp.cc/list2&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
        StringBuilder sb = new StringBuilder();

        sb.append("终于等到您了，欢迎您关注VIP消费贷VIP消费贷是唯品会旗下唯品金融产品" +
                "旨在为个人消费者提供小额分期及纯现金贷款服务。");
        sb.append("\n\n");
        sb.append("如果您想分期，请选择：<a href=\"" + testUrl + "\"> 分期申请！</a>");
        sb.append("如果您想查询当前的申请进度，请选择：<a href=\"" + testUrl1 + "\">进度查询</a>");
        sb.append("如果您已经是唯分期客户，想要查看分期账单，请选择：<a href=\"" + testUrl2 + "\"> 账单服务</a>");

        ResponseText response = new ResponseText();

        response.setToUserName(request.getFromUserName());
        response.setFromUserName(request.getToUserName());
        response.setCreateTime(System.currentTimeMillis());
        response.setContent(sb.toString());

        chatActionService.getWeChatUserInfo(request.getFromUserName());

        return response.toXmlString();
    }

}
