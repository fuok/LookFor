package com.lll.lookfor.activity;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class AddFriendActivity extends Activity implements OnClickListener {
	private static final String TAG = "AddFriendActivity";
	private EditText et_input;// 输入框
	private Button btn_determine;// 确认按钮
	private Button btn_cancal;// 取消按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_addfriend);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		et_input = (EditText) findViewById(R.id.et_addfriend_input);
		btn_determine = (Button) findViewById(R.id.btn_addfriend_determine);
		btn_cancal = (Button) findViewById(R.id.btn_addfriend_cancal);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_determine.setOnClickListener(this);
		btn_cancal.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_addfriend_determine:
			String input = et_input.getText().toString();
			if (TextUtils.isEmpty(input)) {
				Toast.makeText(this, "请输入手机号或者昵称", Toast.LENGTH_SHORT).show();
			} else {
				addRequest(input);
			}

			break;
		case R.id.btn_addfriend_cancal:
			finish();
			break;
		default:
			break;
		}
	}

	/**
	 * 判断是否为手机号码
	 * 
	 * @param mobiles
	 * @return
	 */
	public boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * 添加好友
	 * 
	 * @param input
	 */
	public void addRequest(String input) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();

		if (isMobileNO(input)) {
			hashMap.put("friendMobile", input);
		} else {
			hashMap.put("friendName", input);
		}
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

				if (rc == 0) {// 添加好友成功
					Log.e(TAG, "添加好友成功:" + "RC=" + rc + ",RM=" + rm);
					Toast.makeText(AddFriendActivity.this,
							getString(R.string.addfirend_success),
							Toast.LENGTH_SHORT).show();
					finish();
				} else {// 添加好友失败
					Log.e(TAG, "添加好友失败:" + "RC=" + rc + ",RM=" + rm);
					Toast.makeText(AddFriendActivity.this, rm,
							Toast.LENGTH_SHORT).show();
				}

			}

			// 网络请求失败，气泡显示错误信息
			@Override
			public void onError(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				Toast.makeText(AddFriendActivity.this,
						getString(R.string.addfirend_failure),
						Toast.LENGTH_SHORT).show();
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
				"请求URL：" + HttpInterface.ADD_REQUEST + "?"
						+ requestParams.toString());
		HttpUtil.post(HttpInterface.ADD_REQUEST, requestParams, handler);
	}
}
