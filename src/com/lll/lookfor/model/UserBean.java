package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用户信息实体
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<UserBean> items;
	private String userId; // 用户ID
	private String nickName;// 昵称
	private String portraitPic;// 用户头像
	private int sex;// 1为男，2为女
	private String mobile;// 手机号
	private String token;// 登录校验码

	public ArrayList<UserBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<UserBean> items) {
		this.items = items;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPortraitPic() {
		return portraitPic;
	}

	public void setPortraitPic(String portraitPic) {
		this.portraitPic = portraitPic;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserBean [items=" + items + ", userId=" + userId
				+ ", nickName=" + nickName + ", portraitPic=" + portraitPic
				+ ", sex=" + sex + ", mobile=" + mobile + ", token=" + token
				+ "]";
	}

}
