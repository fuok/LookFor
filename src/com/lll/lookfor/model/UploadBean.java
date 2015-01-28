package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class UploadBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<UploadBean> items;
	private String image;// 头像地址

	public ArrayList<UploadBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<UploadBean> items) {
		this.items = items;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "UploadBean [items=" + items + ", image=" + image + "]";
	}

}
