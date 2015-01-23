package com.lll.lookfor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lll.lookfor.R;

public class ChangeDataActivity extends Activity implements OnClickListener {
	private static final String TAG = "ChangeDataActivity";// Tag
	private Button btn_cancal;// 取消按钮
	private Button btn_save;// 保存按钮
	private RelativeLayout rl_name;// 修改名字
	private RelativeLayout rl_moblie;// 修改手机号
	private RelativeLayout rl_pwd;// 修改密码

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_changedata);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_changedata_cancal);
		btn_save = (Button) findViewById(R.id.btn_changedata_save);
		rl_name = (RelativeLayout) findViewById(R.id.rl_changedata_name);
		rl_moblie = (RelativeLayout) findViewById(R.id.rl_changedata_moblie);
		rl_pwd = (RelativeLayout) findViewById(R.id.rl_changedata_pwd);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_save.setOnClickListener(this);
		rl_name.setOnClickListener(this);
		rl_moblie.setOnClickListener(this);
		rl_pwd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_changedata_cancal:
			finish();
			break;
		case R.id.btn_changedata_save:

			break;
		case R.id.rl_changedata_name:

			break;
		case R.id.rl_changedata_moblie:

			break;
		case R.id.rl_changedata_pwd:

			break;

		default:
			break;
		}
	}
}
