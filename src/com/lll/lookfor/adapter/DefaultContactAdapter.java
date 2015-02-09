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

public class DefaultContactAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<FriendBean> userBeanList;
	private DisplayImageOptions options;// Imageloader配置

	public ArrayList<FriendBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(ArrayList<FriendBean> userBeanList) {
		this.userBeanList = userBeanList;
	}

	public DefaultContactAdapter(Context context) {
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
					R.layout.item_defaultcontact, null);
			holder.choice = (ImageView) convertView
					.findViewById(R.id.img_defaultcontact_choice);
			holder.head = (ImageView) convertView
					.findViewById(R.id.img_defaultcontact_head);
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_defaultcontact_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		FriendBean bean = userBeanList.get(position);
		ImageLoader.getInstance().displayImage(bean.getPortrait(), holder.head,
				options);
		holder.name.setText(bean.getNickName());
		return convertView;
	}

	private class ViewHolder {
		ImageView head, choice;
		TextView name;
	}

}
