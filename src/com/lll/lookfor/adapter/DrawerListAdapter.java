package com.lll.lookfor.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lll.lookfor.R;
import com.lll.lookfor.model.DrawerItem;

public class DrawerListAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<DrawerItem> list;

	public DrawerListAdapter(Context context, ArrayList<DrawerItem> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.drawer_list_item, null);
			holder.logo = (ImageView) convertView
					.findViewById(R.id.drawer_item_logo);
			holder.title = (TextView) convertView
					.findViewById(R.id.drawer_item_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		DrawerItem item = list.get(position);
		holder.logo.setBackgroundResource(item.getLogo());
		holder.title.setText(item.getTitle());

		return convertView;
	}

	private class ViewHolder {
		ImageView logo;
		TextView title;
	}

}
