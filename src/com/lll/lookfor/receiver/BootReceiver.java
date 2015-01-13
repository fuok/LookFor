package com.lll.lookfor.receiver;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

import com.lll.lookfor.service.MessageService;

public class BootReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
			boolean isServiceRunning = false;// 判断服务是否已经启动了
			ActivityManager manager = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			for (RunningServiceInfo service : manager
					.getRunningServices(Integer.MAX_VALUE)) {
				if ("com.hooray.hoophone.service.HooMessageService"
						.equals(service.service.getClassName())) {
					isServiceRunning = true;
				}

			}
			if (!isServiceRunning) {// 启动服务
				Intent serviceIntent = new Intent(context,
						MessageService.class);
				context.startService(serviceIntent);
			}

		} else if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			// 启动服务
			Intent serviceIntent = new Intent(context, MessageService.class);
			context.startService(serviceIntent);
		}

	}
}