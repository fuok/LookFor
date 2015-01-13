package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * 用户信息实体
 * 
 * @author Hendy
 * @since 1.4.1
 * @date 2014-10-28
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String friendId; // 用户ID
	private String mobilNumber;// 手机号码
	private String nickName;// 中文昵称
	private int sex;// 性别
	private String commentName;// 备注名
	private int status;// 可见状态
	private int permission;// 闭眼模式
	private String portrait;// 头像Url
	private double longitude;// 经度
	private double latitude;// 纬度
	private String updateTime;// 更新时间

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getMobilNumber() {
		return mobilNumber;
	}

	public void setMobilNumber(String mobilNumber) {
		this.mobilNumber = mobilNumber;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
