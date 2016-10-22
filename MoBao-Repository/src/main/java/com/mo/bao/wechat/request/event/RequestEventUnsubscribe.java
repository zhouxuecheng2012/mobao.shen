package com.mo.bao.wechat.request.event;


import com.mo.bao.wechat.request.RequestEventBase;

import java.util.Map;

/**
 * 取消订阅事件
 *
 * @author Xi Xiaohui
 *
 */
public class RequestEventUnsubscribe extends RequestEventBase {
	public static RequestEventUnsubscribe valueOf(Map<String, String> requestMap) {
		RequestEventUnsubscribe requestEventUnsubscribe = new RequestEventUnsubscribe();

		requestEventUnsubscribe.setToUserName(requestMap.get("ToUserName"));
		requestEventUnsubscribe.setFromUserName(requestMap.get("FromUserName"));
		requestEventUnsubscribe.setCreateTime(Long.valueOf(requestMap.get("CreateTime")));
		requestEventUnsubscribe.setMsgType(requestMap.get("MsgType"));
		requestEventUnsubscribe.setEvent(requestMap.get("Event"));

		return requestEventUnsubscribe;
	}
}
