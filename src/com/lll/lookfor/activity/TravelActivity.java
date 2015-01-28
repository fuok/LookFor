package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;
import com.lll.lookfor.utils.Log;

/**
 * 安全出行
 * 
 * @author Administrator
 * 
 */
public class TravelActivity extends Activity implements OnClickListener {
	private static final String TAG = "ChangeDataActivity";// Tag
	private Button btn_cancal;// 取消按钮
	private Button btn_send;// 发送按钮
	private RelativeLayout rl_address;// 选择地址
	private RelativeLayout rl_selectfriend;// 选择好友
	private TextView tv_address;// 目的地
	private LatLng ll_address;// 目的地经纬度
	private static final int ADDRESS = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_travel);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_travel_cancal);
		btn_send = (Button) findViewById(R.id.btn_travel_send);
		rl_address = (RelativeLayout) findViewById(R.id.rl_travel_address);
		rl_selectfriend = (RelativeLayout) findViewById(R.id.rl_travel_selectfriend);
		tv_address = (TextView) findViewById(R.id.tv_travel_address);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_send.setOnClickListener(this);
		rl_address.setOnClickListener(this);
		rl_selectfriend.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_travel_cancal:
			finish();
			break;
		case R.id.btn_travel_send:

			break;
		case R.id.rl_travel_address:
			Intent intent = new Intent(TravelActivity.this,
					SearchActivity.class);
			startActivityForResult(intent, ADDRESS);
			break;
		case R.id.rl_travel_selectfriend:

			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "--resultCode:" + resultCode);
		Log.d(TAG, "++requestCode:" + requestCode);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case ADDRESS:// 照相
				String input_address = data.getStringExtra("input_address");
				String address = data.getStringExtra("address");
				FriendBean userBean = (FriendBean) data
						.getSerializableExtra("ll_address");
				ll_address = new LatLng(userBean.getLatitude(),
						userBean.getLongitude());
				tv_address.setText(input_address + "(" + address + ")");
				break;
			default:
				break;
			}
		}
	};
}
