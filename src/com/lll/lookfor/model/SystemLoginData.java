package com.lll.lookfor.model;

import java.io.Serializable;

/** 系统登录接口返回 */
public class SystemLoginData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321777942561635149L;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
