package com.mo.bao.wechat.weixin;

import java.io.Serializable;
import java.util.Calendar;

public class UserAccessToken implements Serializable {
	private String		accessToken;
	private Calendar	expire;
	private String		refreshToken;
	private String		openId;
	private String		scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Calendar getExpire() {
		return expire;
	}

	public void setExpire(Calendar expire) {
		this.expire = expire;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
