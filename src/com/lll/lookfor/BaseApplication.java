package com.lll.lookfor;

import java.io.File;
import java.util.ArrayList;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.lll.lookfor.model.FriendBean;
import com.lll.lookfor.utils.FileUtils;
import com.lll.lookfor.utils.SharePreferenceUtil;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class BaseApplication extends Application {
	private static BaseApplication mApplication;
	private SharePreferenceUtil mSpUtil;
	private ArrayList<FriendBean> all_friends = null;// 全部好友
	private ArrayList<FriendBean> status_friends = null;// 可见好友

	public ArrayList<FriendBean> getAll_friends() {
		return all_friends;
	}

	public ArrayList<FriendBean> getStatus_friends() {
		return status_friends;
	}

	public static synchronized BaseApplication getInstance() {
		return mApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		mApplication = this;

		// 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
		SDKInitializer.initialize(this);

		initImageLoader(this);

		mSpUtil = new SharePreferenceUtil(this, SharePreferenceUtil.LOOKFOR);

		this.all_friends = new ArrayList<FriendBean>();
		this.status_friends = new ArrayList<FriendBean>();
	}

	/**
	 * 返回保存的文件
	 * 
	 * @return
	 */
	public synchronized SharePreferenceUtil getSharePreferenceUtil() {
		if (mSpUtil == null)
			mSpUtil = new SharePreferenceUtil(this, SharePreferenceUtil.LOOKFOR);
		return mSpUtil;
	}

	/**
	 * 初始化ImageLoade开源控件
	 * 
	 * @param context
	 */
	public static void initImageLoader(Application application) {
		File cacheDir = new File(FileUtils.getImagesDir(application));// 图片存放位置
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
				.cacheInMemory(true)// 开启缓存到内存
				.cacheOnDisk(true)// 开启保存到SD卡
				.build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				application).threadPriority(Thread.NORM_PRIORITY - 2)
				.defaultDisplayImageOptions(defaultOptions)
				.denyCacheImageMultipleSizesInMemory()
				.diskCache(new UnlimitedDiscCache(cacheDir))// 设置图片存放地址
				.diskCacheSize(50 * 1024 * 1024) // 缓冲大小
				.diskCacheFileCount(500) // 缓冲文件数目
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())// 以MD5重命名图片
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);
	}

	public void onLowMemory() {
		super.onLowMemory();
		ImageLoader.getInstance().clearMemoryCache();
	}

}