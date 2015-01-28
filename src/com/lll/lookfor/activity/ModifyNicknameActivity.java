package com.lll.lookfor.activity;

import java.util.LinkedHashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.model.UserBean;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.network.ResponseHeader;
import com.lll.lookfor.utils.HooPhoneConstant;
import com.lll.lookfor.utils.HooRequestParams;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;

public class ModifyNicknameActivity extends Activity implements OnClickListener {
	private static final String TAG = "ChangeNicknameActivity";
	private EditText nickname;// 昵称输入框
	private Button determine;// 确认按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_modifynickname);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		nickname = (EditText) findViewById(R.id.et_modifynickname_input);
		determine = (Button) findViewById(R.id.btn_modifynickname_determine);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		determine.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_modifynickname_determine:

			break;

		default:
			break;
		}
	}

	public void modifyNickName(String userId, String nickName) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		hashMap.put("userId", userId);
		hashMap.put("nickName", nickName);
		HooRequestParams requestParams = new HooRequestParams(hashMap);
		ResponseHandler<UserBean> handler = new ResponseHandler<UserBean>(
				UserBean.class);
		handler.setOnHttpResponseListener(new OnHttpResponseListener() {

			@SuppressWarnings("rawtypes")
			@Override
			public void onSuccess(HooHttpResponse response) {
				// TODO Auto-generated method stub
				UserBean body = (UserBean) response.getBody();
				ResponseHeader header = response.getHeader();
				int rc = header.getRc();
				String rm = header.getRm();

				// 登陆成功则从返回值中取用户信息
				if (rc == 0) {
					UserBean userBean = body.getItems().get(0);

					// 保存用户信息
					BaseApplication.getInstance().getSharePreferenceUtil()
							.setNickname(userBean.getNickName());

				} else {// 当登录失败时，气泡显示错误信息
					Log.e(TAG, rm);
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
				"请求URL："
						+ HooPhoneConstant
								.getURL(HooPhoneConstant.URL_MY_USER_LOGIN)
						+ "?" + requestParams.toString());
		HttpUtil.post(
				HooPhoneConstant.getURL(HooPhoneConstant.URL_MY_USER_LOGIN),
				requestParams, handler);
	}
}
