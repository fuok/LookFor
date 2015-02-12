package com.lll.lookfor.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class SelectFriendAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<FriendBean> friendList;
	private DisplayImageOptions options;// Imageloader配置

	public ArrayList<FriendBean> getFriendList() {
		return friendList;
	}

	public void setFriendList(ArrayList<FriendBean> friendList) {
		this.friendList = friendList;
	}

	public SelectFriendAdapter(Context context) {
		this.context = context;
		this.options = new DisplayImageOptions.Builder()
				.bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true)
				.cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(360))
				.build();
	}

	public int getCount() {
		return friendList == null ? 0 : friendList.size();
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	public Object getItem(int position) {
		return friendList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null || position < friendList.size()) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_selectfriend, null);
			holder.choice = (ImageView) convertView
					.findViewById(R.id.img_selectfriend_choice);
			holder.head = (ImageView) convertView
					.findViewById(R.id.img_selectfriend_head);
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_selectfriend_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		FriendBean bean = friendList.get(position);
		ImageLoader.getInstance().displayImage(bean.getPortrait(), holder.head,
				options);
		holder.name.setText(bean.getNickName());
		if (bean.isChoice()) {
			holder.choice.setImageResource(R.drawable.tick_down);
		} else {
			holder.choice.setImageResource(R.drawable.tick_up);
		}
		return convertView;
	}

	private class ViewHolder {
		ImageView head, choice;
		TextView name;
	}

}
