package com.lll.lookfor.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.HttpInterface;
import com.lll.lookfor.R;
import com.lll.lookfor.model.SystemLoginBean;
import com.lll.lookfor.model.SystemLoginData;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.service.MessageService;
import com.lll.lookfor.utils.DeviceUtil;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;
import com.lll.lookfor.utils.SharePreferenceUtil;
import com.loopj.android.http.RequestParams;

/** 程序启动页，第一个打开的页面，请求也在这里 */
public class StartActivity extends Activity {
	private final String TAG = "StartActivity";
	private final int LOGIN_START = 100;
	private final int LOGIN_DONE = 200;
	private final int LOGIN_FINISH = 300;
	private final String FIRST_RUN = "first";// 是否是第一次启动程序的存档标识
	private SharePreferenceUtil share;

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case LOGIN_START:
				// 启动登录，这里我直接进入了

				doSystemLogin();

				if (true) {// TODO
					sendEmptyMessage(LOGIN_DONE);
				}
				break;

			case LOGIN_DONE:
				sleep();
				break;

			case LOGIN_FINISH:
				doInitData();
				break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.share = BaseApplication.getInstance().getSharePreferenceUtil();// 获取sharereferenceUtil
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.act_start);
		// 启动系统登录
		mHandler.sendEmptyMessage(LOGIN_START);

		// 启动Service//这里有问题，不能成功登陆的话就不要启动了，XXX，LY
		Intent serviceIntent = new Intent();
		serviceIntent.setClass(this, MessageService.class);
		startService(serviceIntent);
	}

	/** 启动系统登录 */
	private void doSystemLogin() {

		ResponseHandler<SystemLoginData> handler = new ResponseHandler<SystemLoginData>(
				SystemLoginData.class);
		handler.setOnHttpResponseListener(new OnSystemLoginListener());

		String userId = share.getUserId();
		Log.v(TAG, "UserID :" + userId);
		// 拼接请求体
		// String postPara = "receiveId=" + userId;
		// 请求
		RequestParams params = new RequestParams();
		params.add("subscriberId",
				DeviceUtil.getMACAddress(getApplicationContext()));// MAC
		params.add("platform", "android");// 平台
		PackageManager pm = getPackageManager();// context为当前Activity上下文
		PackageInfo pi;
		String version = "";
		try {
			pi = pm.getPackageInfo(getPackageName(), 0);
			version = pi.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		params.add("version", version);// 版本号
		params.add("userId", userId);// userId
		Log.w(TAG, "系统登录中:" + HttpInterface.SYSTEM_LOGIN);
		Log.w(TAG, "系统登录中:" + params.toString());
		HttpUtil.post(HttpInterface.SYSTEM_LOGIN, params, handler);

	}

	private class OnSystemLoginListener implements OnHttpResponseListener {

		@SuppressWarnings("rawtypes")
		@Override
		public void onSuccess(HooHttpResponse response) {
			int rc = response.getHeader().getRc();
			String rm = response.getHeader().getRm();
			if (rc == 0) {
				// 这里需要返回userId
				SystemLoginData data = (SystemLoginData) response.getBody();
				if (data != null && data.getItems().size() > 0) {

					ArrayList<SystemLoginBean> items = data.getItems();
					String userId = items.get(0).getUserId();
					share.setUserId(userId);
					if (!TextUtils.isEmpty(items.get(0).getToken())) {
						Log.e(TAG, "UserToken : " + items.get(0).getToken());
						HttpUtil.addHeader("token", items.get(0).getToken());
					}
				}

			} else {
				Log.e(TAG, "系统登录失败:" + "RC=" + rc + "RM=" + rm);
			}

		}

		@Override
		public void onError(int statusCode, Throwable error, String content) {
			Log.e(TAG, "系统登录失败" + error);
		}

		@Override
		public void onStart() {

		}

		@Override
		public void onEnd() {

		}

		@Override
		public void onProgress(int bytesWritten, int totalSize) {

		}

	}

	// 在启动图处停留5s
	private void sleep() {
		mHandler.sendEmptyMessageDelayed(LOGIN_FINISH, 2000);
	}

	/** 打开下一级Activity */
	private void doInitData() {
		Intent intent = new Intent();
		// 判断应用是否第一次登陆
		SharedPreferences sharedPref = getSharedPreferences("LookFor", 0);
		boolean isFirstLogin = sharedPref.getBoolean(FIRST_RUN, true);
		if (isFirstLogin) {
			intent.setClass(this, UserGuideActivity.class);
			// 关闭首次登陆判断
			SharedPreferences settings = getSharedPreferences("LookFor", 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean(FIRST_RUN, false);
			editor.commit();
		} else {
			intent.setClass(this, MainActivity.class);
		}
		startActivity(intent);
		finish();
	}
}
