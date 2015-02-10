package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.adapter.FriendListAdapter;

public class FriendListActivity extends Activity {
	private FriendListAdapter adapter;
	private ListView listView;
	private Button btn_back, btn_add;
	private RelativeLayout rl_findfriend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_friendlist);

		initView();
		getData();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_back = (Button) findViewById(R.id.btn_friendlist_back);
		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btn_add = (Button) findViewById(R.id.btn_friendlist_add);
		btn_add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(FriendListActivity.this,
						AddFriendActivity.class));
			}
		});
		rl_findfriend = (RelativeLayout) findViewById(R.id.rl_friendlist_findfriend);
		rl_findfriend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		listView = (ListView) findViewById(R.id.lv_friendlist);

		// ListView头部
		View listHead = LayoutInflater.from(this).inflate(
				R.layout.item_friendlist_head, null);
		listView.addHeaderView(listHead);

		adapter = new FriendListAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(FriendListActivity.this,
							ContactsActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	private void getData() {
		adapter.setUserBeanList(BaseApplication.getInstance().getAll_friends());
		adapter.notifyDataSetChanged();
	}
}
