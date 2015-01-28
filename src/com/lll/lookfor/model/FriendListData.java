package com.lll.lookfor.model;

import java.util.ArrayList;

public class FriendListData {
	ArrayList<FriendBean> friendList;

	public ArrayList<FriendBean> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<FriendBean> friendList) {
		this.friendList = friendList;
	}

	@Override
	public String toString() {
		return "FriendListData [friendList=" + friendList + "]";
	}

}
