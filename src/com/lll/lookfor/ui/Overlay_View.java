package com.lll.lookfor.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lll.lookfor.R;

public class Overlay_View {
	private View view = null;
	private LinearLayout item_bg = null;
	private ImageView item_img = null;
	private TextView item_text = null;

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public LinearLayout getItem_bg() {
		return item_bg;
	}

	public void setItem_bg(LinearLayout item_bg) {
		this.item_bg = item_bg;
	}

	public ImageView getItem_img() {
		return item_img;
	}

	public void setItem_img(ImageView item_img) {
		this.item_img = item_img;
	}

	public TextView getItem_text() {
		return item_text;
	}

	public void setItem_text(TextView item_text) {
		this.item_text = item_text;
	}

	public Overlay_View(Context context) {
		LayoutInflater mLf = LayoutInflater.from(context);
		view = mLf.inflate(R.layout.item_overlay, null);
		item_bg = (LinearLayout) view.findViewById(R.id.ovetlay_item_bg);
		item_img = (ImageView) view.findViewById(R.id.ovetlay_item_img);
		item_text = (TextView) view.findViewById(R.id.ovetlay_item_text);
	}
}
