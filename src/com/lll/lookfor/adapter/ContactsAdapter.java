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
import com.lll.lookfor.model.Contact;

public class ContactsAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Contact> contactsList = null;

	public void setContactsList(ArrayList<Contact> contactsList) {
		this.contactsList = contactsList;
	}

	public ContactsAdapter(Context context) {
		this.context = context;
	}

	public int getCount() {
		return contactsList == null ? 0 : contactsList.size();
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
		if (convertView == null || position < contactsList.size()) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_contacts, null);
			holder.img = (ImageView) convertView
					.findViewById(R.id.contacts_item_img);
			holder.name = (TextView) convertView
					.findViewById(R.id.contacts_item_name);
			holder.number = (TextView) convertView
					.findViewById(R.id.contacts_item_number);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		// 绘制联系人名称
		holder.name.setText(contactsList.get(position).getName());
		// 绘制联系人号码
		holder.number.setText(contactsList.get(position).getNumber());
		// 绘制联系人头像
		// holder.img.setImageBitmap(contactsPhonto.get(position));
		return convertView;
	}

	private class ViewHolder {
		ImageView img;
		TextView name, number;
	}

}
