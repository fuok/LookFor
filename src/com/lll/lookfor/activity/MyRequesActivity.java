package com.lll.lookfor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.adapter.MyRequestAdapter;

public class MyRequesActivity extends Activity {
	private MyRequestAdapter adapter;
	private ListView listView;
	private Button btn_back, btn_clear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_myrequest);

		initView();
		getData();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_back = (Button) findViewById(R.id.btn_myrequest_back);
		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btn_clear = (Button) findViewById(R.id.btn_myrequest_clear);
		btn_clear.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		adapter = new MyRequestAdapter(this);
		listView = (ListView) findViewById(R.id.lv_myrequest);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {

			}
		});
	}

	private void getData() {
		adapter.setUserBeanList(BaseApplication.getInstance().getAll_friends());
		adapter.notifyDataSetChanged();
	}
}
