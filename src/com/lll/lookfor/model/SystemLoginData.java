package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

/** 系统登录接口返回 */
public class SystemLoginData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321777942561635149L;
	private ArrayList<SystemLoginBean> items;//

	public ArrayList<SystemLoginBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<SystemLoginBean> items) {
		this.items = items;
	}

}
