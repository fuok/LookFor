package com.lll.lookfor.activity;

import java.util.LinkedHashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.HttpInterface;
import com.lll.lookfor.R;
import com.lll.lookfor.model.UserBean;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.network.ResponseHeader;
import com.lll.lookfor.utils.HooRequestParams;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;
import com.lll.lookfor.utils.SharePreferenceUtil;

/** 用户登录界面 */
public class LoginActivity extends Activity implements OnClickListener {
	private static final String TAG = "LoginActivity";
	private Button btn_cancal;// 取消按钮
	private Button btn_register;// 注册按钮
	private EditText et_mobilenumber;// 手机号码输入
	private EditText et_password;// 密码输入框
	private Button btn_login;// 登录按钮
	private Button btn_forget;// 忘记密码按钮
	private SharePreferenceUtil shareUtil;
	private String pwd;// 密码
	private String mobile;// 手机号

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login);

		this.shareUtil = BaseApplication.getInstance().getSharePreferenceUtil();

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
			mobile = et_mobilenumber.getText().toString();
			pwd = et_password.getText().toString();
			if (!TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(pwd)) {
				userLogin(mobile, pwd);
			} else {
				Toast.makeText(this, "请输入手机号和密码", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_login_forget:
			startActivity(new Intent(this, ModifyPwdActivity.class));
			break;

		default:
			break;
		}
	}

	/**
	 * 用户手机号登录
	 * 
	 * @param mobile
	 * @param pwd
	 */
	public void userLogin(String mobile, String pwd) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		hashMap.put("mobile", mobile);
		hashMap.put("password", pwd);
//		hashMap.put("token", BaseApplication.getInstance().getSharePreferenceUtil().getToken());
		HooRequestParams requestParams = new HooRequestParams(hashMap);
		ResponseHandler<UserBean> handler = new ResponseHandler<UserBean>(
				UserBean.class);
		handler.setOnHttpResponseListener(new OnHttpResponseListener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void onSuccess(HooHttpResponse response) {
				UserBean body = (UserBean) response.getBody();
				ResponseHeader header = response.getHeader();
				int rc = header.getRc();
				String rm = header.getRm();

				// 登陆成功则从返回值中取用户信息
				if (rc == 0) {
					UserBean userBean = body.getItems().get(0);
					if (!TextUtils.isEmpty(userBean.getToken())) {
						Log.i(TAG, "UserToken : " + userBean.getToken());
						HttpUtil.addHeader("token", userBean.getToken());
					}

					// 保存用户信息
					shareUtil.saveUserInfo(userBean.getUserId(),
							userBean.getSex(), userBean.getMobile(), null,
							userBean.getNickName(), userBean.getPortraitPic());

					Intent intent = new Intent(LoginActivity.this,
							ModifyDataActivity.class);//这个流程也不对，LY
					startActivity(intent);
				} else {// 失败时，气泡显示错误信息
					Log.e(TAG, "用户登录失败:" + "RC=" + rc + ",RM=" + rm);
				}

			}

			// 网络请求失败，气泡显示错误信息
			@Override
			public void onError(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStart() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onEnd() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgress(int bytesWritten, int totalSize) {
				// TODO Auto-generated method stub

			}
		});
		// 请求用户登录接口
		Log.e(TAG,
				"请求URL：" + HttpInterface.USER_LOGIN + "?"
						+ requestParams.toString());
		HttpUtil.post(HttpInterface.USER_LOGIN, requestParams, handler);
	}

}
