package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<MessageBean> items;
	private int msgId;// 消息ID
	private String senderId;// 发送用户ID
	private String senderName;// 发送者昵称
	private String senderPortrait;// 发送者头像
	private String sendTime;// 发送时间
	private int msgType;// 消息类型 1，好友请求 2，好友请求确认 3，公开位置请求 4，公开位置确认 5，防卫信息 6，防卫完成
						// 7，召集信息 8，召集确认
	private String subject;// 消息主题
	private String menberId;// 消息成员ID（menberId=001,002,003）
	private double longitude;// 经度
	private double latitude;// 纬度
	private String location;// 位置信息
	private int requestId;// 本次请求ID
	private ArrayList<ImageBean> imageList;// 图片地址列表

	public ArrayList<MessageBean> getItems() {
		return items;
	}

	public void setItems(ArrayList<MessageBean> items) {
		this.items = items;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPortrait() {
		return senderPortrait;
	}

	public void setSenderPortrait(String senderPortrait) {
		this.senderPortrait = senderPortrait;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMenberId() {
		return menberId;
	}

	public void setMenberId(String menberId) {
		this.menberId = menberId;
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

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public ArrayList<ImageBean> getImageList() {
		return imageList;
	}

	public void setImageList(ArrayList<ImageBean> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "MessageBean [items=" + items + ", msgId=" + msgId
				+ ", senderId=" + senderId + ", senderName=" + senderName
				+ ", senderPortrait=" + senderPortrait + ", sendTime="
				+ sendTime + ", msgType=" + msgType + ", subject=" + subject
				+ ", menberId=" + menberId + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", location=" + location
				+ ", requestId=" + requestId + ", imageList=" + imageList + "]";
	}

	public class ImageBean implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String image;// 图片地址

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}
	}
}
