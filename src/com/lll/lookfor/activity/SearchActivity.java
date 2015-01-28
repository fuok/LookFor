package com.lll.lookfor.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.lll.lookfor.BaseApplication;
import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;

/**
 * 此demo用来展示如何进行驾车、步行、公交路线搜索并在地图使用RouteOverlay、TransitOverlay绘制
 * 同时展示如何进行节点浏览并弹出泡泡
 */
public class SearchActivity extends Activity implements
		BaiduMap.OnMapClickListener, OnClickListener,
		OnGetGeoCoderResultListener {
	private final String TAG = "RoutePlanActivity";
	private boolean isFirstLoc = true;// 是否首次定位
	private MapView mMapView = null; // 地图View
	private BaiduMap mBaiduMap = null;
	private GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
	private LocationClient mLocClient;
	private MyLocationListenner myListener;
	private RelativeLayout info;
	private TextView tv_input;
	private TextView tv_address;
	private Button btn_back;
	private Button btn_search;
	private Button btn_confirmation;
	private EditText et_input;
	private String city = "";
	private String input_address;// 用户输入搜索地址
	private String address;// 搜索出来的详细地址
	private LatLng ll_address;// 目的地经纬度

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_search);

		initView();
		initListener();
		initMyLocation();
	}

	/**
	 * 初始化视图控件
	 */
	private void initView() {
		info = (RelativeLayout) findViewById(R.id.rl_search_info);
		tv_input = (TextView) findViewById(R.id.tv_search_input);
		tv_address = (TextView) findViewById(R.id.tv_search_address);
		btn_back = (Button) findViewById(R.id.btn_search_back);
		btn_search = (Button) findViewById(R.id.btn_search);
		btn_confirmation = (Button) findViewById(R.id.btn_search_confirmation);
		et_input = (EditText) findViewById(R.id.et_search_input);

		// 初始化地图
		mMapView = (MapView) findViewById(R.id.map_search);
		mBaiduMap = mMapView.getMap();

		// 隐藏缩放控件
		mMapView.showZoomControls(false);
		// 隐藏比例尺控件
		mMapView.showScaleControl(false);
		// 隐藏指南针
		mBaiduMap.getUiSettings().setCompassEnabled(false);
		// 删除百度地图logo
		mMapView.removeViewAt(1);
		// 关闭俯视功能
		mBaiduMap.getUiSettings().setOverlookingGesturesEnabled(false);
		// 开启定位图层
		mBaiduMap.setMyLocationEnabled(true);

		// 默认百度地图显示500米
		MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(15);
		mBaiduMap.animateMapStatus(u);

		// 地图点击事件处理
		mBaiduMap.setOnMapClickListener(this);
	}

	/**
	 * 初始化控件监听事件
	 */
	private void initListener() {
		btn_back.setOnClickListener(this);
		btn_search.setOnClickListener(this);
		btn_confirmation.setOnClickListener(this);

		// 初始化搜索模块，注册事件监听
		mSearch = GeoCoder.newInstance();
		mSearch.setOnGetGeoCodeResultListener(this);
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
		option.setLocationNotify(false);
		option.setAddrType("all");

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
			LatLng stLatLng = new LatLng(location.getLatitude(),
					location.getLongitude());
			if (isFirstLoc) {
				isFirstLoc = false;
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(stLatLng);
				mBaiduMap.animateMapStatus(u);
			}
		}

		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	public void onGetGeoCodeResult(GeoCodeResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(SearchActivity.this, "抱歉，未能找到结果", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		mBaiduMap.clear();
		mBaiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.icon_marka)));
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
				.getLocation()));
		// 反Geo搜索
		ll_address = result.getLocation();
		mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(result
				.getLocation()));
	}

	public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(SearchActivity.this, "抱歉，未能找到结果", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		closeKeyboard();
		address = result.getAddress();
		tv_input.setText(input_address);
		tv_address.setText(address);
		info.setVisibility(View.VISIBLE);
	}

	@Override
	public void onMapClick(LatLng point) {
		mBaiduMap.hideInfoWindow();
	}

	@Override
	public boolean onMapPoiClick(MapPoi poi) {
		return false;
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
		mMapView.onDestroy();
		mSearch.destroy();
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_search_back:
			finish();
			break;
		case R.id.btn_search:
			input_address = et_input.getText().toString();
			if (!TextUtils.isEmpty(BaseApplication.getInstance()
					.getSharePreferenceUtil().getCity())) {
				city = BaseApplication.getInstance().getSharePreferenceUtil()
						.getCity();
			}
			if (TextUtils.isEmpty(input_address)) {
				Toast.makeText(SearchActivity.this, "请输入地址", Toast.LENGTH_SHORT)
						.show();
			} else {
				mSearch.geocode(new GeoCodeOption().city(city).address(
						input_address));
			}
			break;
		case R.id.btn_search_confirmation:
			FriendBean userBean = new FriendBean();
			userBean.setLatitude(ll_address.latitude);
			userBean.setLongitude(ll_address.longitude);
			Intent intent = new Intent();
			intent.putExtra("input_address", input_address);
			intent.putExtra("address", address);
			intent.putExtra("ll_address", userBean);
			setResult(-1, intent);
			finish();
			break;
		default:
			break;
		}
	}

	/**
	 * 隐藏软键盘
	 */
	private void closeKeyboard() {
		View view = getWindow().peekDecorView();
		if (view != null) {
			InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

}
