package com.mo.bao.wechat.request;


import com.mo.bao.wechat.RequestBase;

/**
 * 事件消息请求
 *
 * @author Xi Xiaohui
 *
 */
public class RequestEventBase extends RequestBase {
	// 事件类型
	private String	event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

}
