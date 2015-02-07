package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 好友信息实体
 */
public class FriendBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<FriendBean> items;
	private String friendId; // 用户ID
	private String mobile;// 手机号码
	private String nickName;// 中文昵称
	private int sex;// 性别
	private String commentName;// 备注名
	private int status;// 可见状态
	private int permission;// 闭眼模式
	private String portrait;// 头像Url
	private double longitude;// 经度
	private double latitude;// 纬度
	private String location;// 所处位置
	private String updateTime;// 更新时间

	public ArrayList<FriendBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<FriendBean> items) {
		this.items = items;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "FriendBean [items=" + items + ", friendId=" + friendId
				+ ", mobile=" + mobile + ", nickName=" + nickName + ", sex="
				+ sex + ", commentName=" + commentName + ", status=" + status
				+ ", permission=" + permission + ", portrait=" + portrait
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", location=" + location + ", updateTime=" + updateTime + "]";
	}

}
