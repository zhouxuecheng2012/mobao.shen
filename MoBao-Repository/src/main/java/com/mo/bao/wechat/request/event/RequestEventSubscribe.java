package com.mo.bao.wechat.request.event;


import com.mo.bao.wechat.request.RequestEventBase;

import java.util.Map;

/**
 * 订阅事件
 *
 * @author Xi Xiaohui
 *
 */
public class RequestEventSubscribe extends RequestEventBase {
	public static RequestEventSubscribe valueOf(Map<String, String> requestMap) {
		RequestEventSubscribe requestEventSubscribe = new RequestEventSubscribe();

		requestEventSubscribe.setToUserName(requestMap.get("ToUserName"));
		requestEventSubscribe.setFromUserName(requestMap.get("FromUserName"));
		requestEventSubscribe.setCreateTime(Long.valueOf(requestMap.get("CreateTime")));
		requestEventSubscribe.setMsgType(requestMap.get("MsgType"));
		requestEventSubscribe.setEvent(requestMap.get("Event"));

		return requestEventSubscribe;
	}
}
