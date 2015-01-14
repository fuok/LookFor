package com.lll.lookfor.model;

import java.util.ArrayList;

public class FriendListData {
	ArrayList<UserBean> friendList;

	public ArrayList<UserBean> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<UserBean> friendList) {
		this.friendList = friendList;
	}

	@Override
	public String toString() {
		return "FriendListData [friendList=" + friendList + "]";
	}

}
