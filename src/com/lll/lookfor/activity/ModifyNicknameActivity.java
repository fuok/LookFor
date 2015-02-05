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

public class ModifyNicknameActivity extends Activity implements OnClickListener {
	private static final String TAG = "ModifyNicknameActivity";
	private EditText et_nickname;// 昵称输入框
	private Button btn_determine;// 确认按钮
	private int first;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_modifynickname);

		first = getIntent().getIntExtra("first", 0);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		et_nickname = (EditText) findViewById(R.id.et_modifynickname_input);
		btn_determine = (Button) findViewById(R.id.btn_modifynickname_determine);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_determine.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_modifynickname_determine:
			String nickName = et_nickname.getText().toString();
			if (TextUtils.isEmpty(nickName)) {
				Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
			} else {
				modifyNickName(BaseApplication.getInstance()
						.getSharePreferenceUtil().getUserId(), nickName);
			}

			break;

		default:
			break;
		}
	}

	public void modifyNickName(String userId, String nickName) {
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		hashMap.put("nickName", nickName);
//		hashMap.put("token", BaseApplication.getInstance()
//				.getSharePreferenceUtil().getToken());
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
					Log.i(TAG, "获取昵称：" + userBean.getNickName());
					// 保存用户信息
					BaseApplication.getInstance().getSharePreferenceUtil()
							.setNickname(userBean.getNickName());
					if (first != 1) {//这里是什么意思，LY
						Intent intent = new Intent();
						intent.putExtra("nickName", userBean.getNickName());
						setResult(-1, intent);
						startActivity(new Intent(ModifyNicknameActivity.this,
								RegisterActivity.class));
					}else {
						startActivity(new Intent(ModifyNicknameActivity.this,
								MainActivity.class));
					}
					finish();
				} else {// 当登录失败时，气泡显示错误信息
					Log.e(TAG, "获取昵称失败:" + "RC=" + rc + ",RM=" + rm);
				}

			}

			// 网络请求失败，气泡显示错误信息
			@Override
			public void onError(int statusCode, Throwable error, String content) {
				// TODO Auto-generated method stub
				Log.e(TAG, "修改昵称错误！");
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
		Log.e(TAG, "请求URL：" + HttpInterface.MODIFY_NICKNAME + "?"
				+ requestParams.toString());
		HttpUtil.post(HttpInterface.MODIFY_NICKNAME, requestParams, handler);
	}
}
