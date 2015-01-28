package com.lll.lookfor.ui;

import com.lll.lookfor.R;
import com.lll.lookfor.utils.Log;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * 发送图片选择对话框 实现发送图片选择对话框
 * 
 */
public class PhotoDialog extends Dialog {
	private static final String TAG = "PhotoDialog";
	private Button camera;// 选择相机
	private Button local;// 选择本地相册
	private Button cancel;// 取消按钮
	private int screenWidth;
	private int screenHeight;

	public PhotoDialog(Context context) {
		super(context, R.style.largeDialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_photo);

		DisplayMetrics dm = new DisplayMetrics();
		// 取得窗口属性
		Window window = getWindow();
		window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
		window.getWindowManager().getDefaultDisplay().getMetrics(dm);
		window.setWindowAnimations(R.style.upEnterAnim);
		// 屏幕的宽度
		screenWidth = dm.widthPixels;
		Log.e(TAG, "Width: " + screenWidth);
		// 屏幕的高度
		screenHeight = dm.heightPixels;
		Log.e(TAG, "Height: " + screenHeight);

		WindowManager.LayoutParams wl = window.getAttributes();
		wl.width = screenWidth;
		window.setAttributes(wl);

		camera = (Button) findViewById(R.id.btn_photo_camera);
		local = (Button) findViewById(R.id.btn_photo_local);
		cancel = (Button) findViewById(R.id.btn_photo_cancel);
		cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});

	}

	public void setCameraButton(View.OnClickListener listener) {
		if (listener != null) {
			camera.setOnClickListener(listener);
		}
	}

	public void setLocalButton(View.OnClickListener listener) {
		if (listener != null) {
			local.setOnClickListener(listener);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			dismiss();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
