package com.mo.bao.wechat.processor.impl;


import com.mo.bao.wechat.processor.Processor;
import com.mo.bao.wechat.request.event.RequestEventView;
import org.springframework.stereotype.Service;

@Service
public class ViewProcessor implements Processor<RequestEventView> {



	@Override
	public String doProcess(RequestEventView request) {
		// 自动登录


		return "";
	}
}
