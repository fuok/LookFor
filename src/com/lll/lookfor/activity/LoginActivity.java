package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.lll.lookfor.R;

/** 用户登录界面 */
public class LoginActivity extends Activity implements OnClickListener {
	private Button btn_cancal;// 取消按钮
	private Button btn_register;// 注册按钮
	private EditText et_mobilenumber;// 手机号码输入
	private EditText et_password;// 密码输入框
	private Button btn_login;// 登录按钮
	private Button btn_forget;// 忘记密码按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_login_cancal);
		btn_register = (Button) findViewById(R.id.btn_login_register);
		et_mobilenumber = (EditText) findViewById(R.id.et_login_mobilenumber);
		et_password = (EditText) findViewById(R.id.et_login_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_forget = (Button) findViewById(R.id.btn_login_forget);
	}

	/**
	 * 初始化控件监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		btn_login.setOnClickListener(this);
		btn_forget.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_login_cancal:
			finish();
			break;
		case R.id.btn_login_register:
			startActivity(new Intent(this, RegisterActivity.class));
			break;
		case R.id.btn_login:

			break;
		case R.id.btn_login_forget:
			startActivity(new Intent(this, ChangePwdActivity.class));
			break;

		default:
			break;
		}
	}

}
