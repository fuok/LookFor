package com.lll.lookfor.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;

public class MyRequestAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<FriendBean> userBeanList;

	public ArrayList<FriendBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(ArrayList<FriendBean> userBeanList) {
		this.userBeanList = userBeanList;
	}

	public MyRequestAdapter(Context context) {
		this.context = context;
	}

	public int getCount() {
		return userBeanList == null ? 0 : userBeanList.size();
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null || position < userBeanList.size()) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_myrequest, null);
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_myrequest_name);
			holder.time = (TextView) convertView
					.findViewById(R.id.tv_myrequest_time);
			holder.state = (TextView) convertView
					.findViewById(R.id.tv_myrequest_state);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		FriendBean bean = userBeanList.get(position);
		holder.name.setText(bean.getNickName());
		holder.time.setText(bean.getUpdateTime());
		return convertView;
	}

	private class ViewHolder {
		TextView name, time, state;
	}

}
