package com.lll.lookfor.service;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;

import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.model.FriendListData;
import com.lll.lookfor.model.UserBean;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.utils.HooPhoneConstant;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;
import com.lll.lookfor.utils.SharePreferenceUtil;

public class MessageService extends Service {
	private final String TAG = "MessageService";
	private String userId;
	private Timer timer;
	private SharePreferenceUtil share;

	public void onCreate() {
		super.onCreate();
		this.share = ((BaseApplication) BaseApplication.getInstance())
				.getSharePreferenceUtil();// 获取sharereferenceUtil

		share.setUserId("123");
		// 对象
		// 开启时间任务，每十秒请求一次绑定关系
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				Log.v(TAG, "Service TimerTask for every 10 seconds");
				mHandler.sendEmptyMessage(0);
			}
		}, 0, 10 * 1000);
		Log.i(TAG, "startService onCreate");
	}

	@SuppressLint("HandlerLeak")
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			// process incoming messages here
			switch (msg.what) {
			case 0:
				getMessageList();
				break;
			default:
				break;
			}
		}
	};

	public void onDestroy() {
		if (timer != null) {
			timer.cancel();
		}
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	// ------------------------------------------网络请求及响应事件-----------------------------------------------

	/**
	 * 获取站内信(未读)
	 */
	private void getMessageList() {
		ResponseHandler<FriendListData> handler = new ResponseHandler<FriendListData>(
				FriendListData.class);
		handler.setOnHttpResponseListener(new OnGetHomeMessageListener());

		userId = share.getUserId();
		if (TextUtils.isEmpty(userId)) {
			userId = share.getSubscriberId();
		}
		if (!TextUtils.isEmpty(userId)) {// 当userId不为空时，才进行请求
			Log.v(TAG, "UserID :" + userId);
			// 拼接请求体
			String postPara = "receiveId=" + userId;
			// 请求
			Log.w(TAG,
					"消息轮询中:"
							+ HooPhoneConstant
									.getURL(HooPhoneConstant.URL_MSG_GET_MSG_LIST)
							+ "?" + postPara);
			HttpUtil.get("http://www.xshcar.com/chen/friendList.html", handler);
		}
	}

	/** 请求站内信相应事件 */
	private class OnGetHomeMessageListener implements OnHttpResponseListener {

		@SuppressWarnings("rawtypes")
		@Override
		public void onSuccess(HooHttpResponse response) {
			int rc = response.getHeader().getRc();
			String rm = response.getHeader().getRm();
			if (rc == 0) {
				FriendListData friendList = (FriendListData) response.getBody();
				if (friendList != null && friendList.getFriendList().size() > 0) {
					// 添加全部好友集合
					((BaseApplication) BaseApplication.getInstance())
							.getAll_friends()
							.addAll(friendList.getFriendList());
					// 添加可见好友集合
					for (int i = 0; i < friendList.getFriendList().size(); i++) {
						UserBean uBean = friendList.getFriendList().get(i);
						if (uBean.getStatus() == 1) {
							((BaseApplication) BaseApplication.getInstance())
									.getStatus_friends().add(uBean);
						}
					}
				}
				System.out
						.println("MessageService.OnGetHomeMessageListener.onSuccess()"
								+ friendList.toString());
			} else {
				Log.e(TAG, "获取新消息失败:" + "RC=" + rc + "RM=" + rm);
			}

		}

		@Override
		public void onError(int statusCode, Throwable error, String content) {
			Log.e(TAG, "获取新消息失败" + error);
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

	}
}
