package com.lll.lookfor.model;

import java.io.Serializable;

/** 请求指定用户数据详情的返回结果 */
public class LbsBean implements Serializable {

	private String friendId;// 对方id
	private String mobilNumber;// 手机号
	private String nickName;// 昵称
	private int sex;// 性别。1男，2女
	private String commentName;// 备注名
	private String portrait;// 头像地址
	private double longitude;// 经度
	private double latitude;// 纬度
	private String location;// 位置名称
	private String updateTime;// 更新时间
	private double velocity;// 速度
	private double direction;// 方向（相对）
	private int battery;// 电量（百分比）
	private int signal;// 信号强度（百分比）
	private int lattice;// 电子围栏数目（此项待定）

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

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public int getLattice() {
		return lattice;
	}

	public void setLattice(int lattice) {
		this.lattice = lattice;
	}

}
