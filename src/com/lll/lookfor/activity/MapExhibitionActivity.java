package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.utils.SharePreferenceUtil;

public class MapExhibitionActivity extends Activity implements OnClickListener {
	private static final String TAG = "MapExhibitionActivity";// Tag
	private Button btn_cancal;// 返回按钮
	private RelativeLayout rl_mapmode;// 地图模式
	private RelativeLayout rl_satellitemode;// 卫星模式
	private ImageView img_mapmode;
	private ImageView img_satellitemode;

	private SharePreferenceUtil sharePfUtil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_mapexhibition);

		this.sharePfUtil = BaseApplication.getInstance()
				.getSharePreferenceUtil();

		initView();
		initListener();
		setMapMode();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_mapexhibition_cancal);
		rl_mapmode = (RelativeLayout) findViewById(R.id.rl_mapexhibition_mapmode);
		rl_satellitemode = (RelativeLayout) findViewById(R.id.rl_mapexhibition_satellitemode);
		img_mapmode = (ImageView) findViewById(R.id.img_mapexhibition_mapmode);
		img_satellitemode = (ImageView) findViewById(R.id.img_mapexhibition_satellitemode);

	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		rl_mapmode.setOnClickListener(this);
		rl_satellitemode.setOnClickListener(this);
	}

	/**
	 * 设置地图展示模式
	 */
	private void setMapMode() {
		if ("mapmode".equals(sharePfUtil.getMapExhibition())) {
			img_mapmode.setBackgroundResource(R.drawable.tick_down);
			img_satellitemode.setBackgroundResource(R.drawable.tick_up);
		} else {
			img_mapmode.setBackgroundResource(R.drawable.tick_up);
			img_satellitemode.setBackgroundResource(R.drawable.tick_down);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_mapexhibition_cancal:
			finish();
			break;
		case R.id.rl_mapexhibition_mapmode:
			sharePfUtil.setMapExhibition("mapmode");
			// 发送广播
			Intent intent_map = new Intent();
			intent_map.putExtra("mapexhibition", "mapmode");
			intent_map.setAction(BaseApplication.BRODCAST_MAPMODE);
			sendBroadcast(intent_map);
			setMapMode();
			break;
		case R.id.rl_mapexhibition_satellitemode:
			sharePfUtil.setMapExhibition("satellitemode");
			// 发送广播
			Intent intent_satellite = new Intent();
			intent_satellite.putExtra("mapexhibition", "satellitemode");
			intent_satellite.setAction(BaseApplication.BRODCAST_MAPMODE);
			sendBroadcast(intent_satellite);
			setMapMode();
			break;

		default:
			break;
		}
	}
}
