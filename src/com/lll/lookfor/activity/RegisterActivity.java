package com.lll.lookfor.activity;

import java.util.LinkedHashMap;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.HttpInterface;
import com.lll.lookfor.R;
import com.lll.lookfor.model.UserBean;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.utils.HooRequestParams;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;

public class RegisterActivity extends Activity implements OnClickListener {
	private static final String TAG = "RegisterActivity";// Tag
	private Button btn_cancal;// 取消按钮
	private Button btn_register;// 注册按钮
	private Button btn_send;// 发送按钮
	private EditText et_mobilenumber;// 手机号码输入
	private EditText et_password;// 密码输入框
	private EditText et_code;// 验证码输入框
	private TimeCount time;// 计时器
	private String mobile;// 手机号
	private String code;// 验证码
	private String password;// 密码

	// 填写从短信SDK应用后台注册得到的APPKEY
	private static String APPKEY = "518ec8a6aa30";
	// 填写从短信SDK应用后台注册得到的APPSECRET
	private static String APPSECRET = "23f82461e51ac52d992af8117fe5d331";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_register);

		initView();
		initListener();

		// 初始化短信SDK
		SMSSDK.initSDK(this, APPKEY, APPSECRET);
		EventHandler eh = new EventHandler() {

			@Override
			public void afterEvent(int event, int result, Object data) {

				Message msg = new Message();
				msg.arg1 = event;
				msg.arg2 = result;
				msg.obj = data;
				handler.sendMessage(msg);
			}

		};
		SMSSDK.registerEventHandler(eh);
	}

	/**
	 * 初始化布局文件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_register_cancal);
		btn_register = (Button) findViewById(R.id.btn_register);
		btn_send = (Button) findViewById(R.id.btn_register_send);
		et_mobilenumber = (EditText) findViewById(R.id.et_register_mobilenumber);
		et_password = (EditText) findViewById(R.id.et_register_password);
		et_code = (EditText) findViewById(R.id.et_register_code);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_register.setOnClickListener(this);
		btn_send.setOnClickListener(this);
	}

	/**
	 * 点击事件处理1：返回按钮，2：获取注册验证码，3：注册用户
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_register_cancal:
			finish();
			break;
		case R.id.btn_register:
			code = et_code.getText().toString();
			password = et_password.getText().toString();
			mobile = et_mobilenumber.getText().toString();
			if (TextUtils.isEmpty(mobile) || mobile.length() != 11) {
				Toast.makeText(this, getString(R.string.phone_num_lack),
						Toast.LENGTH_SHORT).show();
			} else {
				if (password.length() >= 6) {
					if (!TextUtils.isEmpty(code)) {
						SMSSDK.submitVerificationCode("86", mobile, code);
					} else {
						Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT)
								.show();
					}
				} else if (TextUtils.isEmpty(password) || password.length() < 6) {
					Toast.makeText(this, "请输入大于6位的密码", Toast.LENGTH_SHORT)
							.show();
				}
			}
			break;
		case R.id.btn_register_send:
			mobile = et_mobilenumber.getText().toString();
			if (TextUtils.isEmpty(mobile) || mobile.length() != 11) {
				Toast.makeText(this, getString(R.string.phone_num_lack),
						Toast.LENGTH_SHORT).show();
			} else {
				// 如果发送验证码，则显示倒计时，60秒后可以重新发送验证码
				if (time != null) {
					time.cancel();
					time = null;
				}
				time = new TimeCount(60000, 1000);// 构造CountDownTimer对象
				time.start();

				SMSSDK.getVerificationCode("86", mobile);
			}

			break;

		default:
			break;
		}
	}

	/**
	 * 定义一个倒计时的内部类
	 */
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			btn_send.setText(R.string.send);
			btn_send.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			btn_send.setClickable(false);
			btn_send.setText(getString(R.string.resend) + millisUntilFinished
					/ 1000 + getString(R.string.resend_second));
		}
	}

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			int event = msg.arg1;
			int result = msg.arg2;
			Object data = msg.obj;
			Log.e("event", "event=" + event);
			if (result == SMSSDK.RESULT_COMPLETE) {
				// 短信注册成功后，返回MainActivity,然后提示新好友
				if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
					Toast.makeText(getApplicationContext(), "提交验证码成功",
							Toast.LENGTH_SHORT).show();
					registerUser();
				} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
					Toast.makeText(getApplicationContext(), "验证码已经发送",
							Toast.LENGTH_SHORT).show();
				}
			} else {
				((Throwable) data).printStackTrace();
			}

		}

	};

	/**
	 * 用户注册
	 */
	private void registerUser() {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		hashMap.put("mobile", mobile);
		hashMap.put("password", password);
		hashMap.put("token", BaseApplication.getInstance()
				.getSharePreferenceUtil().getToken());
		HooRequestParams requestParams = new HooRequestParams(hashMap);
		ResponseHandler<UserBean> handler = new ResponseHandler<UserBean>(
				UserBean.class);
		handler.setOnHttpResponseListener(new OnHttpResponseListener() {
			@SuppressWarnings("rawtypes")
			@Override
			public void onSuccess(HooHttpResponse response) {
				UserBean body = (UserBean) response.getBody();
				int rc = response.getHeader().getRc();
				String rm = response.getHeader().getRm();
				if (rc == 0) {
					Log.e(TAG, "用户注册成功:" + "RC=" + rc + "RM=" + rm);
					UserBean bean = body.getItems().get(0);
					BaseApplication.getInstance().getSharePreferenceUtil()
							.setUserId(bean.getUserId());
					finish();
				} else {
					Log.e(TAG, "用户注册失败:" + "RC=" + rc + "RM=" + rm);
				}
			}

			// 网络请求失败
			@Override
			public void onError(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				Log.e(TAG, "用户注册失败!");
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
		// 网络请求
		Log.e(TAG,
				"请求URL：" + HttpInterface.REGIST + "?"
						+ requestParams.toString());
		HttpUtil.post(HttpInterface.REGIST, requestParams, handler);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (time != null) {
			time.cancel();
			time = null;
		}
		SMSSDK.unregisterAllEventHandler();
	}
}
