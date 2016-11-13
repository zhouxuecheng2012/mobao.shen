package com.mo.bao.wechat.weixin;

import java.io.Serializable;

public class AccessToken implements Serializable{


	private static final long serialVersionUID = 7454843994308630023L;
	private String	appId;
	private String	accessToken;
	private Long	expire;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpire() {
		return expire;
	}

	public void setExpire(Long expire) {
		this.expire = expire;
	}

	@Override
	public String toString() {
		return "AccessToken{" +
				"appId='" + appId + '\'' +
				", accessToken='" + accessToken + '\'' +
				", expire=" + expire +
				'}';
	}
}
