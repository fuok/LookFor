package com.lll.lookfor.activity;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.lll.lookfor.R;
import com.lll.lookfor.adapter.DrawerListAdapter;
import com.lll.lookfor.crossbutton.CrossButtonFragment;
import com.lll.lookfor.model.DrawerItem;

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
	private BitmapDescriptor mCurrentMarker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer);
		//创建底部导航按钮碎片
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.cross_button_container, new CrossButtonFragment()).commit();
		}
		initView();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		this.left_drawer_img = (ImageView) findViewById(R.id.left_drawer_img);
		this.left_drawer_img.setOnClickListener(this);
		this.mDrawerList = (ListView) findViewById(R.id.left_drawer);

		//ListView头部
		View listHead = LayoutInflater.from(this).inflate(
				R.layout.drawer_list_head, null);
		mDrawerList.addHeaderView(listHead);
		//ListView底部
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

		list.add(new DrawerItem(R.drawable.ic_launcher,
				getString(R.string.my_message)));
		list.add(new DrawerItem(R.drawable.ic_launcher,
				getString(R.string.my_friend)));
		list.add(new DrawerItem(R.drawable.ic_launcher,
				getString(R.string.my_circles)));
		list.add(new DrawerItem(R.drawable.ic_launcher,
				getString(R.string.my_request)));
		adapter = new DrawerListAdapter(this, list);
		mDrawerList.setAdapter(adapter);

		myListener = new MyLocationListenner();
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

		// 修改为自定义marker
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher);
		mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
				LocationMode.NORMAL, true, mCurrentMarker));

		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();

		// 默认百度地图显示500米
		MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(15);
		mBaiduMap.animateMapStatus(u);
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
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(100).latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			mBaiduMap.setMyLocationData(locData);
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);
			}
		}

		public void onReceivePoi(BDLocation poiLocation) {
		}
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
}
