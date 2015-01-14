package com.lll.lookfor.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.lll.lookfor.R;
import com.lll.lookfor.adapter.DrawerListAdapter;
import com.lll.lookfor.crossbutton.CrossButtonFragment;
import com.lll.lookfor.model.DrawerItem;
import com.lll.lookfor.model.UserBean;
import com.lll.lookfor.utils.Log;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class MainActivity extends Activity implements OnClickListener {
	// 左侧侧滑菜单栏
	private ListView mDrawerList;
	private ArrayList<DrawerItem> list;
	private DrawerListAdapter adapter;
	private ImageView left_drawer_img;
	private DrawerLayout mDrawerLayout;

	// 定位相关
	private LocationClient mLocClient;
	private MyLocationListenner myListener;
	boolean isFirstLoc = true;// 是否首次定位
	// 地图相关
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	// 自定义图标
	private InfoWindow mInfoWindow;
	private ArrayList<Marker> markerList;
	private ArrayList<UserBean> userList;
	private ArrayList<BitmapDescriptor> bitmapList;
	// Imageloader配置
	private DisplayImageOptions option;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_drawer);
		// 创建底部导航按钮碎片
		if (savedInstanceState == null) {
			getFragmentManager()
					.beginTransaction()
					.add(R.id.cross_button_container, new CrossButtonFragment())
					.commit();
		}

		this.markerList = new ArrayList<Marker>();
		this.userList = new ArrayList<UserBean>();
		this.bitmapList = new ArrayList<BitmapDescriptor>();

		this.option = new DisplayImageOptions.Builder()
				.bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true)
				.cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(360))
				.build();
		initView();
		initMyLocation();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		this.left_drawer_img = (ImageView) findViewById(R.id.left_drawer_img);
		this.left_drawer_img.setOnClickListener(this);
		this.mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// ListView头部
		View listHead = LayoutInflater.from(this).inflate(
				R.layout.drawer_list_head, null);
		ListView.LayoutParams params = new ListView.LayoutParams(
				LayoutParams.MATCH_PARENT,200);
		listHead.setLayoutParams(params);
		mDrawerList.addHeaderView(listHead);
		// ListView底部
		View listfoot = LayoutInflater.from(this).inflate(
				R.layout.drawer_list_foot, null);
		mDrawerList.addFooterView(listfoot);
		TextView setting = (TextView) listfoot.findViewById(R.id.setting);
		setting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SendSMSActivity.class);
				startActivity(intent);
			}
		});

		this.list = new ArrayList<DrawerItem>();

		list.add(new DrawerItem(R.drawable.left_quanta,
				getString(R.string.my_circles)));
		list.add(new DrawerItem(R.drawable.left_message_default,
				getString(R.string.my_message)));
		list.add(new DrawerItem(R.drawable.left_friends,
				getString(R.string.my_friend)));
		list.add(new DrawerItem(R.drawable.left_application,
				getString(R.string.my_request)));
		adapter = new DrawerListAdapter(this, list);
		mDrawerList.setAdapter(adapter);

		// 左边侧滑栏点击事件处理
		mDrawerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(MainActivity.this,
							ContactsActivity.class);
					startActivity(intent);
				}
			}
		});

		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();

		// 隐藏缩放控件
		mMapView.showZoomControls(false);
		// 隐藏比例尺控件
		mMapView.showScaleControl(false);
		// 隐藏指南针
		mBaiduMap.getUiSettings().setCompassEnabled(false);
		// 删除百度地图logo
		mMapView.removeViewAt(1);
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);
		// 关闭俯视功能
		mBaiduMap.getUiSettings().setOverlookingGesturesEnabled(false);

		// 默认百度地图显示500米
		MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(15);
		mBaiduMap.animateMapStatus(u);

		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			public boolean onMarkerClick(final Marker marker) {

				for (int i = 0; i < markerList.size(); i++) {
					final Marker position = markerList.get(i);
					if (position == marker) {
						// 图标
						final View item = LayoutInflater
								.from(MainActivity.this).inflate(
										R.layout.overlay_item, null);
						final LinearLayout item_bg = (LinearLayout) item
								.findViewById(R.id.ovetlay_item_bg);
						final ImageView item_img = (ImageView) item
								.findViewById(R.id.ovetlay_item_img);

						ImageLoader
								.getInstance()
								.displayImage(
										"http://www.1735la.com/d/file/touxiang/keai/20131026/b8d5edc5cd4d9181a94932ad210f0dfe.jpg",
										item_img, option,
										new SimpleImageLoadingListener() {
											public void onLoadingComplete(
													String imageUri,
													android.view.View view,
													android.graphics.Bitmap loadedImage) {

												item_bg.setBackgroundResource(R.drawable.icon_personal);
												BitmapDescriptor bdA = BitmapDescriptorFactory
														.fromView(item);
												bitmapList.add(bdA);
												marker.setIcon(bdA);
											};
										});

						Button button = new Button(getApplicationContext());
						button.setBackgroundResource(R.drawable.popup);
						OnInfoWindowClickListener listener = null;
						button.setText("更改位置");
						listener = new OnInfoWindowClickListener() {
							public void onInfoWindowClick() {
								Log.e("MainActivity", "弹出框点击");
							}
						};
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(BitmapDescriptorFactory
								.fromView(button), ll, -87, listener);
						mBaiduMap.showInfoWindow(mInfoWindow);
					} else {
						// 图标
						final View item = LayoutInflater
								.from(MainActivity.this).inflate(
										R.layout.overlay_item, null);
						final LinearLayout item_bg = (LinearLayout) item
								.findViewById(R.id.ovetlay_item_bg);
						final ImageView item_img = (ImageView) item
								.findViewById(R.id.ovetlay_item_img);

						ImageLoader
								.getInstance()
								.displayImage(
										"http://www.1735la.com/d/file/touxiang/keai/20131026/b8d5edc5cd4d9181a94932ad210f0dfe.jpg",
										item_img, option,
										new SimpleImageLoadingListener() {
											public void onLoadingComplete(
													String imageUri,
													android.view.View view,
													android.graphics.Bitmap loadedImage) {

												item_bg.setBackgroundResource(R.drawable.icon_user);
												BitmapDescriptor bdA = BitmapDescriptorFactory
														.fromView(item);
												bitmapList.add(bdA);
												position.setIcon(bdA);
											};
										});
					}

				}
				return true;
			}
		});

		// 地图点击事件
		mBaiduMap.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng point) {
				Log.e("MainActivity", "单击地图");
				mBaiduMap.hideInfoWindow();
				addOverlay(userList);
			}

			public boolean onMapPoiClick(MapPoi poi) {
				return false;
			}
		});
	}

	/**
	 * 初始化定位相关代码
	 */
	private void initMyLocation() {
		// 定位初始化
		mLocClient = new LocationClient(this);
		myListener = new MyLocationListenner();
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
	}

	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mMapView == null)
				return;
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);

				UserBean userInfo = new UserBean();
				userInfo.setLatitude(location.getLatitude());
				userInfo.setLongitude(location.getLongitude());

				UserBean userInfo1 = new UserBean();
				userInfo1.setLatitude(location.getLatitude());
				userInfo1.setLongitude(location.getLongitude() + 0.01);

				UserBean userInfo2 = new UserBean();
				userInfo2.setLatitude(location.getLatitude());
				userInfo2.setLongitude(location.getLongitude() + 0.02);

				userList.add(userInfo);
				userList.add(userInfo1);
				userList.add(userInfo2);
				addOverlay(userList);
			}
		}

		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	/**
	 * 增加覆盖物
	 */
	public void addOverlay(ArrayList<UserBean> infos) {
		mBaiduMap.clear();
		for (final UserBean info : infos) {

			// 图标
			final View item = LayoutInflater.from(MainActivity.this).inflate(
					R.layout.overlay_item, null);
			final LinearLayout item_bg = (LinearLayout) item
					.findViewById(R.id.ovetlay_item_bg);
			final ImageView item_img = (ImageView) item
					.findViewById(R.id.ovetlay_item_img);

			ImageLoader
					.getInstance()
					.displayImage(
							"http://www.1735la.com/d/file/touxiang/keai/20131026/b8d5edc5cd4d9181a94932ad210f0dfe.jpg",
							item_img, option, new SimpleImageLoadingListener() {
								public void onLoadingComplete(String imageUri,
										android.view.View view,
										android.graphics.Bitmap loadedImage) {
									BitmapDescriptor bdA = BitmapDescriptorFactory
											.fromView(item);
									bitmapList.add(bdA);
									// 位置
									LatLng latLng = new LatLng(info
											.getLatitude(), info.getLongitude());
									OverlayOptions overlayOptions = new MarkerOptions()
											.position(latLng).icon(bdA);
									Marker marker = (Marker) (mBaiduMap
											.addOverlay(overlayOptions));
									// 将实体传递
									Bundle bundle = new Bundle();
									bundle.putSerializable("info", info);
									marker.setExtraInfo(bundle);
									markerList.add(marker);
								};
							});

		}
	}

	@Override
	protected void onStart() {
		// 开启图层定位
		mBaiduMap.setMyLocationEnabled(true);
		if (!mLocClient.isStarted()) {
			mLocClient.start();
		}
		super.onStart();
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// 退出时销毁定位
		mLocClient.stop();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;

		// 回收 bitmap 资源
		if (bitmapList != null && bitmapList.size() > 0) {
			for (int i = 0; i < bitmapList.size(); i++) {
				BitmapDescriptor bitmap = bitmapList.get(i);
				bitmap.recycle();
			}
		}
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.left_drawer_img:
			if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
				mDrawerLayout.closeDrawer(mDrawerList);
			} else {
				mDrawerLayout.openDrawer(mDrawerList);
			}
			break;

		default:
			break;
		}

	}

	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				// System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
