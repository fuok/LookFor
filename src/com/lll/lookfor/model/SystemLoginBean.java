package com.lll.lookfor.model;

import java.io.Serializable;

public class SystemLoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String token;// 登录校验码

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SystemLoginBean [userId=" + userId + ", token=" + token + "]";
	}

}
