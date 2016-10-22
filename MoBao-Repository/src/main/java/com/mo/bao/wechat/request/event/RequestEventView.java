package com.mo.bao.wechat.request.event;

import com.mo.bao.wechat.request.RequestEventBase;

import java.util.Map;

/**
 * 自定义菜单跳转事件
 *
 * @author Xi Xiaohui
 *
 */
public class RequestEventView extends RequestEventBase {
	// 跳转URL
	private String	eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public static RequestEventView valueOf(Map<String, String> requestMap) {
		RequestEventView requestEventView = new RequestEventView();

		requestEventView.setToUserName(requestMap.get("ToUserName"));
		requestEventView.setFromUserName(requestMap.get("FromUserName"));
		requestEventView.setCreateTime(Long.valueOf(requestMap.get("CreateTime")));
		requestEventView.setMsgType(requestMap.get("MsgType"));
		requestEventView.setEvent(requestMap.get("Event"));
		requestEventView.setEventKey(requestMap.get("EventKey"));

		return requestEventView;
	}
}
