package com.mo.bao.wechat;

/**
 * 请求消息基类
 *
 * @author Xi Xiaohui
 *
 */
public abstract class RequestBase {
	// 开发者微信号
	private String	toUserName;

	// 发送方帐号（一个OpenID）
	private String	fromUserName;

	// 消息创建时间 （整型）
	private long	createTime;

	// 消息类型（text/image/location/link）
	private String	msgType;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
