package com.lll.lookfor.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.adapter.SelectFriendAdapter;
import com.lll.lookfor.model.FriendBean;

/**
 * 选择好友
 * 
 * @author Administrator
 * 
 */
public class SelectFriendActivity extends Activity {
	private SelectFriendAdapter adapter;
	private ListView listView;
	private Button btn_back;
	private Button btn_determine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_selectfriend);

		initView();
		getData();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_back = (Button) findViewById(R.id.btn_selectfriend_back);
		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btn_determine = (Button) findViewById(R.id.btn_selectfriend_determine);
		btn_determine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<FriendBean> selectFriendBeans = new ArrayList<FriendBean>();
				for (int i = 0; i < adapter.getFriendList().size(); i++) {
					FriendBean bean = (FriendBean) adapter.getItem(i);
					if (bean.isChoice()) {
						selectFriendBeans.add(bean);
					}
				}
				Intent intent = new Intent();
				intent.putExtra("select_friend", selectFriendBeans);
				setResult(-1, intent);
				finish();
			}
		});
		listView = (ListView) findViewById(R.id.lv_selectfriend);

		adapter = new SelectFriendAdapter(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				FriendBean bean = (FriendBean) adapter.getItem(position);
				if (bean.isChoice()) {
					bean.setChoice(false);
				} else {
					bean.setChoice(true);
				}
				adapter.notifyDataSetChanged();
			}
		});
	}

	private void getData() {
		adapter.setFriendList(BaseApplication.getInstance().getAll_friends());
		adapter.notifyDataSetChanged();
	}
}
