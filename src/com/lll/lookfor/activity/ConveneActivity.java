package com.lll.lookfor.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;
import com.lll.lookfor.utils.Log;

/**
 * 创建召集
 * 
 * @author Administrator
 * 
 */
public class ConveneActivity extends Activity implements OnClickListener {
	private static final String TAG = "ConveneActivity";// Tag
	private Button btn_cancal;// 取消按钮
	private Button btn_send;// 发送按钮
	private RelativeLayout rl_address;// 选择地址
	private RelativeLayout rl_selectfriend;// 选择好友
	private TextView tv_address;// 目的地
	private TextView tv_selectfriend;// 好友
	private ImageView img_address;
	private ImageView img_selectfriend;
	private LatLng ll_address;// 目的地经纬度
	private static final int ADDRESS = 101;
	private static final int FRIENDS = 102;
	private ArrayList<FriendBean> selectFriendList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_convene);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_convene_cancal);
		btn_send = (Button) findViewById(R.id.btn_convene_send);
		rl_address = (RelativeLayout) findViewById(R.id.rl_convene_address);
		rl_selectfriend = (RelativeLayout) findViewById(R.id.rl_convene_selectfriend);
		tv_address = (TextView) findViewById(R.id.tv_convene_address);
		tv_selectfriend = (TextView) findViewById(R.id.tv_convene_selectfriend);
		img_address = (ImageView) findViewById(R.id.img_convene_address);
		img_selectfriend = (ImageView) findViewById(R.id.img_convene_selectfriend);
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
		case R.id.btn_convene_cancal:
			finish();
			break;
		case R.id.btn_convene_send:

			break;
		case R.id.rl_convene_address:
			startActivityForResult(new Intent(ConveneActivity.this,
					SearchActivity.class), ADDRESS);
			break;
		case R.id.rl_convene_selectfriend:
			startActivityForResult(new Intent(ConveneActivity.this,
					SelectFriendActivity.class), FRIENDS);
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
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
				img_address.setImageResource(R.drawable.ico_travel_down);
				Log.e(TAG, "经纬度：" + ll_address.toString());
				break;
			case FRIENDS:
				selectFriendList = (ArrayList<FriendBean>) data
						.getSerializableExtra("select_friend");
				StringBuffer select_friend = new StringBuffer();
				for (int i = 0; i < selectFriendList.size(); i++) {
					FriendBean bean = selectFriendList.get(i);
					select_friend.append(bean.getNickName());
					if (i < (selectFriendList.size() - 1)) {
						select_friend.append(";");
					}
				}
				img_selectfriend.setImageResource(R.drawable.ico_friend_down);
				tv_selectfriend.setText(select_friend);
				break;
			default:
				break;
			}
		}
	};
}
