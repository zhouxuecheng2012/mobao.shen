package com.mo.bao.wechat.request;


import com.mo.bao.wechat.RequestBase;

import java.util.Map;

/**
 * 文本消息请求
 *
 * @author Xi Xiaohui
 *
 */
public class RequestText extends RequestBase {
	// 文本消息内容
	private String	content;

	// 消息id，64位整型
	private Long	msgId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public static RequestText valueOf(Map<String, String> requestMap) {
		RequestText requestText = new RequestText();

		requestText.setToUserName(requestMap.get("ToUserName"));
		requestText.setFromUserName(requestMap.get("FromUserName"));
		requestText.setCreateTime(Long.valueOf(requestMap.get("CreateTime")));
		requestText.setMsgType(requestMap.get("MsgType"));
		requestText.setMsgId(Long.valueOf(requestMap.get("MsgId")));
		requestText.setContent(requestMap.get("Content"));

		return requestText;
	}
}
