package com.lll.lookfor.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.lll.lookfor.R;

public class InfoWindow_View {
	private View view = null;
	private Button quanta = null;
	private Button hide = null;
	private Button here = null;

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Button getQuanta() {
		return quanta;
	}

	public void setQuanta(Button quanta) {
		this.quanta = quanta;
	}

	public Button getHide() {
		return hide;
	}

	public void setHide(Button hide) {
		this.hide = hide;
	}

	public Button getHere() {
		return here;
	}

	public void setHere(Button here) {
		this.here = here;
	}

	public InfoWindow_View(Context context) {
		LayoutInflater mLf = LayoutInflater.from(context);
		view = mLf.inflate(R.layout.item_infowindow, null);
		quanta = (Button) view.findViewById(R.id.btn_infowindow_quanta);
		hide = (Button) view.findViewById(R.id.btn_infowindow_hide);
		here = (Button) view.findViewById(R.id.btn_infowindow_here);
	}
}
