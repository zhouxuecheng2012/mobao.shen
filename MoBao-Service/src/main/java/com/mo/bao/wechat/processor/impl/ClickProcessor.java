package com.mo.bao.wechat.processor.impl;


import com.mo.bao.wechat.processor.Processor;
import com.mo.bao.wechat.request.event.RequestEventClick;
import com.mo.bao.wechat.response.ResponseText;
import org.springframework.stereotype.Service;

@Service
public class ClickProcessor implements Processor<RequestEventClick> {
	@Override
	public String doProcess(RequestEventClick request) {
		System.out.println("CLICK:");
		System.out.println("from:" + request.getFromUserName());
		System.out.println("to:" + request.getToUserName());
		System.out.println("time:" + request.getCreateTime());
		System.out.println("msgtype:" + request.getMsgType());
		System.out.println("event:" + request.getEvent());
		System.out.println("key:" + request.getEventKey());

		ResponseText response = new ResponseText();

		response.setToUserName(request.getFromUserName());
		response.setFromUserName(request.getToUserName());
		response.setCreateTime(System.currentTimeMillis());
		response.setContent("openid:" + request.getFromUserName());

		return response.toXmlString();
	}

}
