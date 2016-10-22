package com.mo.bao.wechat.response;


import com.mo.bao.wechat.ResponseBase;

public class ResponseText extends ResponseBase {
	private String	content;

	@Override
	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + this.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + this.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + Long.toString(this.getCreateTime()) + "</CreateTime>");
		sb.append("<MsgType><![CDATA[text]]></MsgType>");
		sb.append("<Content><![CDATA[" + this.getContent() + "]]></Content>");
		sb.append("</xml>");

		return sb.toString();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
