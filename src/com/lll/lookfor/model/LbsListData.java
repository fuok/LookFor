package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

/** 用户详情队列 */
public class LbsListData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<LbsBean> lbsList;

	public ArrayList<LbsBean> getLbsList() {
		return lbsList;
	}

	public void setLbsList(ArrayList<LbsBean> lbsList) {
		this.lbsList = lbsList;
	}

	@Override
	public String toString() {
		return "LbsListData [lbsList=" + lbsList + "]";
	}

}
