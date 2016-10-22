package com.mo.bao.wechat.request.event;

import com.mo.bao.wechat.request.RequestEventBase;

import java.util.Map;

/**
 * 自定义菜单点击事件
 *
 * @author Xi Xiaohui
 *
 */
public class RequestEventClick extends RequestEventBase {
	// 菜单Key
	private String	eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public static RequestEventClick valueOf(Map<String, String> requestMap) {
		RequestEventClick requestEventClick = new RequestEventClick();

		requestEventClick.setToUserName(requestMap.get("ToUserName"));
		requestEventClick.setFromUserName(requestMap.get("FromUserName"));
		requestEventClick.setCreateTime(Long.valueOf(requestMap.get("CreateTime")));
		requestEventClick.setMsgType(requestMap.get("MsgType"));
		requestEventClick.setEvent(requestMap.get("Event"));
		requestEventClick.setEventKey(requestMap.get("EventKey"));

		return requestEventClick;
	}
}
