package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.utils.SharePreferenceUtil;

public class SettingActivity extends Activity implements OnClickListener {
	private static final String TAG = "SettingActivity";// Tag
	private Button btn_cancal;// 返回按钮
	private Button btn_signout;// 退出按钮
	private RelativeLayout rl_mapexhibition;// 地图展示方式
	private RelativeLayout rl_eyespower;// 闭眼权限设置
	private RelativeLayout rl_commonlyaddress;// 常用地址
	private RelativeLayout rl_addcontact;// 添加默认联系人
	private RelativeLayout rl_versionupdate;// 版本更新
	private RelativeLayout rl_aboutus;// 关于我们

	private SharePreferenceUtil sharePfUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_setting);

		this.sharePfUtil = BaseApplication.getInstance()
				.getSharePreferenceUtil();

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_setting_cancal);
		btn_signout = (Button) findViewById(R.id.btn_setting_signout);
		rl_mapexhibition = (RelativeLayout) findViewById(R.id.rl_setting_mapexhibition);
		rl_eyespower = (RelativeLayout) findViewById(R.id.rl_setting_eyespower);
		rl_commonlyaddress = (RelativeLayout) findViewById(R.id.rl_setting_commonlyaddress);
		rl_addcontact = (RelativeLayout) findViewById(R.id.rl_setting_addcontact);
		rl_versionupdate = (RelativeLayout) findViewById(R.id.rl_setting_versionupdate);
		rl_aboutus = (RelativeLayout) findViewById(R.id.rl_setting_aboutus);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_signout.setOnClickListener(this);
		rl_mapexhibition.setOnClickListener(this);
		rl_eyespower.setOnClickListener(this);
		rl_commonlyaddress.setOnClickListener(this);
		rl_addcontact.setOnClickListener(this);
		rl_versionupdate.setOnClickListener(this);
		rl_aboutus.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_setting_cancal:
			finish();
			break;
		case R.id.btn_setting_signout:
			sharePfUtil.setIsLogin(false);
			// 发送广播
			Intent intent = new Intent();
			intent.setAction(BaseApplication.BRODCAST_ISLOGIN);
			sendBroadcast(intent);
			break;
		case R.id.rl_setting_mapexhibition:
			startActivity(new Intent(this, MapExhibitionActivity.class));
			break;
		case R.id.rl_setting_eyespower:

			break;
		case R.id.rl_setting_commonlyaddress:

			break;
		case R.id.rl_setting_addcontact:

			break;
		case R.id.rl_setting_versionupdate:

			break;
		case R.id.rl_setting_aboutus:

			break;

		default:
			break;
		}
	}
}
