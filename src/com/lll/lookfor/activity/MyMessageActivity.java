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
import com.lll.lookfor.adapter.MyMessagetAdapter;

public class MyMessageActivity extends Activity {
	private MyMessagetAdapter adapter;
	private ListView listView;
	private Button btn_back, btn_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_mymessage);

		initView();
		getData();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_back = (Button) findViewById(R.id.btn_mymessage_back);
		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btn_right = (Button) findViewById(R.id.btn_mymessage_right);
		btn_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});

		adapter = new MyMessagetAdapter(this);
		listView = (ListView) findViewById(R.id.lv_mymessage);
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
