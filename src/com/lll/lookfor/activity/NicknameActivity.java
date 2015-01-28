package com.lll.lookfor.activity;

import com.lll.lookfor.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NicknameActivity extends Activity implements OnClickListener {
	private EditText nickname;// 昵称输入框
	private Button determine;// 确认按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_nickname);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		nickname = (EditText) findViewById(R.id.et_nickname_input);
		determine = (Button) findViewById(R.id.btn_nickname_determine);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		determine.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_nickname_determine:

			break;

		default:
			break;
		}
	}
}
