package com.mo.bao.wechat.processor.impl;


import com.mo.bao.wechat.processor.Processor;
import com.mo.bao.wechat.request.RequestText;
import com.mo.bao.wechat.response.ResponseText;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class TextProcessor implements Processor<RequestText> {


    @Override
    public String doProcess(RequestText request) {
        String userBindUrl = "http://dwz.cn/1KTZKx";
        String downloadUrl = "http://dwz.cn/1KU12W";
        String listMkActUrl = "http://weixin.kuailezhiliao.com/weixin/ShowMkActList.do";

        ResponseText response = new ResponseText();

        response.setToUserName(request.getFromUserName());
        response.setFromUserName(request.getToUserName());
        response.setCreateTime(System.currentTimeMillis());
        response.setContent("/:rose<a href=\"" + downloadUrl + "\">感谢亲支持【TEST】！</a>");

        String openId = request.getFromUserName();
        String content = request.getContent();

        content = content.replaceAll(" ", "");

        // 活动列表
        if (content.toUpperCase().equals("ACTS")) {
            response.setContent("<a href=\"" + listMkActUrl + "\">点击查看活动列表</a>");

            return response.toXmlString();
        }


        return response.toXmlString();
    }
}
