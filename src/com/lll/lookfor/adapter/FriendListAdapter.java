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
import com.lll.lookfor.model.UserBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class FriendListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<UserBean> userBeanList;
	private DisplayImageOptions options;// Imageloader配置

	public ArrayList<UserBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(ArrayList<UserBean> userBeanList) {
		this.userBeanList = userBeanList;
	}

	public FriendListAdapter(Context context) {
		this.context = context;
		this.options = new DisplayImageOptions.Builder()
				.bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true)
				.cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(360))
				.build();
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
					R.layout.item_friendlist, null);
			holder.head = (ImageView) convertView
					.findViewById(R.id.img_item_friendlist_head);
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_item_friendlist_name);
			holder.visiable = (ImageView) convertView
					.findViewById(R.id.img_item_friendlist_visiable);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ImageLoader
				.getInstance()
				.displayImage(
						"http://www.1735la.com/d/file/touxiang/keai/20131026/b8d5edc5cd4d9181a94932ad210f0dfe.jpg",
						holder.head, options);
		holder.name.setText(userBeanList.get(position).getNickName());
		return convertView;
	}

	private class ViewHolder {
		ImageView head, visiable;
		TextView name;
	}

}
