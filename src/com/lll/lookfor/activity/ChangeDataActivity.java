package com.lll.lookfor.activity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lll.lookfor.R;
import com.lll.lookfor.ui.PhotoDialog;
import com.lll.lookfor.utils.FileUtils;
import com.lll.lookfor.utils.ImageUtils;
import com.lll.lookfor.utils.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ChangeDataActivity extends Activity implements OnClickListener {
	private static final String TAG = "ChangeDataActivity";// Tag
	private Button btn_cancal;// 取消按钮
	private Button btn_photo;// 上传头像按钮
	private RelativeLayout rl_name;// 修改名字
	private RelativeLayout rl_moblie;// 修改手机号
	private RelativeLayout rl_pwd;// 修改密码
	private static String IMGPATH = null;
	private File vFile = null;
	private static final int CAMERA_WITH_DATA = 101;
	private static final int PHOTO_PICKED_WITH_DATA = 102;
	private static final int CHANGE_NICKNAME = 103;
	private static final int CHANGE_MOBLIE = 104;
	private static final int CHANGE_PWD = 105;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_changedata);

		initView();
		initListener();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		btn_cancal = (Button) findViewById(R.id.btn_changedata_cancal);
		btn_photo = (Button) findViewById(R.id.btn_changedata_photo);
		rl_name = (RelativeLayout) findViewById(R.id.rl_changedata_name);
		rl_moblie = (RelativeLayout) findViewById(R.id.rl_changedata_moblie);
		rl_pwd = (RelativeLayout) findViewById(R.id.rl_changedata_pwd);
	}

	/**
	 * 初始化监听事件
	 */
	private void initListener() {
		btn_cancal.setOnClickListener(this);
		btn_photo.setOnClickListener(this);
		rl_name.setOnClickListener(this);
		rl_moblie.setOnClickListener(this);
		rl_pwd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_changedata_cancal:
			finish();
			break;
		case R.id.btn_changedata_photo:
			showPhotoDailog();
			break;
		case R.id.rl_changedata_name:
			Intent intent = new Intent(ChangeDataActivity.this,
					NicknameActivity.class);
			startActivityForResult(intent, CHANGE_NICKNAME);
			break;
		case R.id.rl_changedata_moblie:
			Intent intent_moblie = new Intent(ChangeDataActivity.this,
					ChangeMoblieActivity.class);
			startActivityForResult(intent_moblie, CHANGE_MOBLIE);
			break;
		case R.id.rl_changedata_pwd:
			Intent intent_pwd = new Intent(ChangeDataActivity.this,
					ChangePwdActivity.class);
			startActivityForResult(intent_pwd, CHANGE_PWD);
			break;

		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "ChatActivity.onActivityResult()---resultCode:" + resultCode);
		Log.d(TAG, "ChatActivity.onActivityResult()+++requestCode:"
				+ requestCode);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case CAMERA_WITH_DATA:// 照相
				try {
					HandleImage handleImage = new HandleImage(IMGPATH);
					handleImage.execute(new Void[0]);
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(this, "读取图片错误！", Toast.LENGTH_SHORT).show();
				}
				break;
			case PHOTO_PICKED_WITH_DATA:// 图片
				Uri uri = data.getData();
				Log.e("Uri:", uri.toString());
				Log.v("图片地址：", ImageUtils.getPath(this, uri));
				HandleImage handleImage = new HandleImage(ImageUtils.getPath(
						this, uri));
				handleImage.execute(new Void[0]);
				break;
			case CHANGE_NICKNAME:

				break;
			case CHANGE_MOBLIE:

				break;
			case CHANGE_PWD:

				break;

			default:
				break;
			}
		}
	};

	/**
	 * 对图片进行处理
	 */
	private class HandleImage extends AsyncTask<Void, Void, String> {
		private String filepath = null;

		private HandleImage(String filepath) {
			this.filepath = filepath;
		}

		public String doInBackground(Void... params) {
			return doSaveImage(ChangeDataActivity.this, filepath);
		}

		public void onPostExecute(String result) {
			if (!TextUtils.isEmpty(result)) {
				// 上传头像

			} else {
				Toast.makeText(ChangeDataActivity.this, "图片发送失败!",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 将图片保存到应用缓存下
	 */
	private String doSaveImage(Context ctx, String str) {
		File imageUri = new File(str);

		String str1 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
				.format(new Date());
		File localFile2 = new File(FileUtils.getSaveImagesDir(this), str1);// 图片存放位置

		// 判断保存文件夹是否存在，如不存在则重新创建
		if (!localFile2.getParentFile().exists()) {
			localFile2.getParentFile().mkdirs();
		}

		// 判断图片的源文件是否存在
		if (!imageUri.exists()) {
			Toast.makeText(this, "照片不存在！", Toast.LENGTH_SHORT).show();
			return null;
		}

		try {
			if (imageUri.length() < 1048576) {// 少于1MB的，不作处理
				ImageUtils.saveImageToSD(null, localFile2.getPath().toString(),
						ImageLoader.getInstance()
								.loadImageSync("file://" + str), 100);
			} else if (imageUri.length() < 10485760) {// 少于10MB的大于1MB的压缩一半
				ImageUtils.saveImageToSD(null, localFile2.getPath().toString(),
						ImageLoader.getInstance()
								.loadImageSync("file://" + str), 50);
			} else if (imageUri.length() < 104857600) {// 少于100MB的直接压缩成10%
				ImageUtils.saveImageToSD(null, localFile2.getPath().toString(),
						ImageLoader.getInstance()
								.loadImageSync("file://" + str), 10);
			} else {// 大于100MB的直接压缩成1%
				ImageUtils.saveImageToSD(null, localFile2.getPath().toString(),
						ImageLoader.getInstance()
								.loadImageSync("file://" + str), 1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return localFile2.getPath().toString();
	}

	/**
	 * 选择图片来源对话框
	 */
	private void showPhotoDailog() {
		final PhotoDialog dialog = new PhotoDialog(ChangeDataActivity.this);
		dialog.show();
		dialog.setCanceledOnTouchOutside(true);
		dialog.setCameraButton(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				doCamera();
			}
		});
		dialog.setLocalButton(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				doPhoto();
			}
		});
	}

	/**
	 * 调用相册
	 */
	private void doPhoto() {
		Intent intent = new Intent(Intent.ACTION_PICK);
		intent.setType("image/*");
		startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
	}

	/**
	 * 调用照相机
	 */
	private void doCamera() {
		if (hasSdcard()) { // 判断手机SD卡是否存在
			String str1 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US)
					.format(new Date());
			String str2 = "IMG_" + str1 + ".jpg";
			File localFile2 = new File(FileUtils.getSaveImagesDir(this), str2);// 图片存放位置
			IMGPATH = localFile2.toString();
			vFile = new File(IMGPATH);
			if (vFile.exists()) {
				vFile.delete();
			}
			if (!vFile.exists()) {
				File vDirPath = vFile.getParentFile();
				vDirPath.mkdirs();
			}
			Uri uri = Uri.fromFile(vFile);
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// "android.media.action.IMAGE_CAPTURE"
			intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);//
			startActivityForResult(intent, CAMERA_WITH_DATA);
		} else {
			Toast.makeText(this, "外部存储卡无法使用！", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 判断是否有外部存储设备
	 * 
	 * @return
	 */
	private boolean hasSdcard() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}
}
