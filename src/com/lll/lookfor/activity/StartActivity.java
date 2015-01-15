package com.lll.lookfor.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

import com.lll.lookfor.R;
import com.lll.lookfor.service.MessageService;

/** 程序启动页，第一个打开的页面，请求也在这里 */
public class StartActivity extends Activity {
	private final int LOGIN_START = 100;
	private final int LOGIN_DONE = 200;
	private final int LOGIN_FINISH = 300;
	private final String FIRST_RUN = "first";// 是否是第一次启动程序的存档标识

	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case LOGIN_START:
				// 启动登录，这里我直接进入了
				sendEmptyMessage(LOGIN_DONE);
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.act_start);
		// 启动系统登录
		mHandler.sendEmptyMessage(LOGIN_START);

		// 启动Service
		Intent serviceIntent = new Intent();
		serviceIntent.setClass(this, MessageService.class);
		startService(serviceIntent);
	}

	// 在启动图处停留5s
	private void sleep() {
		new Thread() {
			@Override
			public void run() {
				try {
					sleep(1000);
					mHandler.sendEmptyMessage(LOGIN_FINISH);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.run();
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
