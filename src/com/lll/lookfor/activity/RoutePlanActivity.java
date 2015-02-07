package com.lll.lookfor.activity;

import java.util.Timer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.overlayutil.DrivingRouteOverlay;
import com.baidu.mapapi.overlayutil.OverlayManager;
import com.baidu.mapapi.overlayutil.TransitRouteOverlay;
import com.baidu.mapapi.overlayutil.WalkingRouteOverlay;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.lll.lookfor.HttpInterface;
import com.lll.lookfor.R;
import com.lll.lookfor.model.FriendBean;
import com.lll.lookfor.model.LbsListData;
import com.lll.lookfor.network.HooHttpResponse;
import com.lll.lookfor.network.OnHttpResponseListener;
import com.lll.lookfor.network.ResponseHandler;
import com.lll.lookfor.utils.HttpUtil;
import com.lll.lookfor.utils.Log;

/**
 * 此demo用来展示如何进行驾车、步行、公交路线搜索并在地图使用RouteOverlay、TransitOverlay绘制
 * 同时展示如何进行节点浏览并弹出泡泡
 */
public class RoutePlanActivity extends Activity implements
		BaiduMap.OnMapClickListener, OnGetRoutePlanResultListener {
	private final String TAG = "RoutePlanActivity";
	int nodeIndex = -1;// 节点索引,供浏览节点时使用
	OverlayManager routeOverlay = null;
	boolean useDefaultIcon = false;
	boolean isFirstLoc = true;// 是否首次定位

	// 地图相关，使用继承MapView的MyRouteMapView目的是重写touch事件实现泡泡处理
	// 如果不处理touch事件，则无需继承，直接使用MapView即可
	MapView mMapView = null; // 地图View
	BaiduMap mBaiduMap = null;
	// 搜索相关
	RoutePlanSearch mSearch = null; // 搜索模块，也可去掉地图模块独立使用

	private FriendBean enUserBean;// 到，就是要去地点的用户信息

	private LatLng stLatLng;// 从的经纬度
	private LatLng enLatLng;// 到的经纬度

	private Timer timer;

	private LocationClient mLocClient;
	private MyLocationListenner myListener;
	private int distance;// 距离
	private int duration;// 时间
	private TextView info;
	private Button btn_back;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_routeplan);

		enUserBean = (FriendBean) getIntent().getSerializableExtra("en");

		initView();

		// 初始化地图
		mMapView = (MapView) findViewById(R.id.map);
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

		// 将地图移到到当前经纬度位置
		MapStatusUpdate st = MapStatusUpdateFactory.newLatLng(stLatLng);
		mBaiduMap.setMapStatus(st);
		// 地图点击事件处理
		mBaiduMap.setOnMapClickListener(this);
		// 初始化搜索模块，注册事件监听
		mSearch = RoutePlanSearch.newInstance();
		mSearch.setOnGetRoutePlanResultListener(this);

		initMyLocation();

		// 开启时间任务，每十秒请求一次
		// timer = new Timer();
		// timer.schedule(new TimerTask() {
		// public void run() {
		// Log.v(TAG, "请求好友地理位置!");
		// mHandler.sendEmptyMessage(0);
		// }
		// }, 0, 10 * 1000);
	}

	private void initView() {
		info = (TextView) findViewById(R.id.act_routeplan_info);
		btn_back = (Button) findViewById(R.id.btn_routeplan_back);

		btn_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
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
			stLatLng = new LatLng(location.getLatitude(),
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

	@SuppressLint("HandlerLeak")
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			// process incoming messages here
			switch (msg.what) {
			case 0:
				getUserData();
				break;
			default:
				break;
			}
		}
	};

	/**
	 * 获取数据
	 */
	private void getUserData() {
		ResponseHandler<LbsListData> handler = new ResponseHandler<LbsListData>(
				LbsListData.class);
		handler.setOnHttpResponseListener(new OnGetHomeMessageListener());

		// 请求
		HttpUtil.get(HttpInterface.LBS_LIST, handler);
	}

	/** 请求站内信相应事件 */
	private class OnGetHomeMessageListener implements OnHttpResponseListener {

		@SuppressWarnings("rawtypes")
		@Override
		public void onSuccess(HooHttpResponse response) {
			int rc = response.getHeader().getRc();
			String rm = response.getHeader().getRm();
			if (rc == 0) {
				LbsListData lbsListData = (LbsListData) response.getBody();
				enLatLng = new LatLng(lbsListData.getLbsList().get(0)
						.getLatitude(), lbsListData.getLbsList().get(0)
						.getLongitude());
			} else {
				Log.e(TAG, "获取用户信息失败:" + "RC=" + rc + "RM=" + rm);
			}

		}

		@Override
		public void onError(int statusCode, Throwable error, String content) {
			Log.e(TAG, "获取用户信息失败:" + error);
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

	/**
	 * 发起路线规划搜索示例
	 * 
	 * @param v
	 */
	public void SearchButtonProcess(View v) {
		// 重置浏览节点的路线数据
		mBaiduMap.clear();

		PlanNode stNode = PlanNode.withLocation(stLatLng);
		PlanNode enNode = PlanNode.withLocation(enLatLng);

		// 实际使用中请对起点终点城市进行正确的设定
		if (v.getId() == R.id.drive) {
			mSearch.drivingSearch((new DrivingRoutePlanOption()).from(stNode)
					.to(enNode));
		} else if (v.getId() == R.id.walk) {
			mSearch.walkingSearch((new WalkingRoutePlanOption()).from(stNode)
					.to(enNode));
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(RoutePlanActivity.this, "抱歉，未找到结果",
					Toast.LENGTH_SHORT).show();
		}
		if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
			// 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
			// result.getSuggestAddrInfo()
			return;
		}
		if (result.error == SearchResult.ERRORNO.NO_ERROR) {
			distance = result.getRouteLines().get(0).getDistance();
			duration = result.getRouteLines().get(0).getDuration();
			info.setText("步行" + distance + "米" + "  " + "约"
					+ (duration % 3600 / 60) + "分钟");
			info.setVisibility(View.VISIBLE);
			nodeIndex = -1;
			WalkingRouteOverlay overlay = new MyWalkingRouteOverlay(mBaiduMap);
			mBaiduMap.setOnMarkerClickListener(overlay);
			routeOverlay = overlay;
			overlay.setData(result.getRouteLines().get(0));
			overlay.addToMap();
			overlay.zoomToSpan();
		}

	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult result) {

		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(RoutePlanActivity.this, "抱歉，未找到结果",
					Toast.LENGTH_SHORT).show();
		}
		if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
			// 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
			// result.getSuggestAddrInfo()
			return;
		}
		if (result.error == SearchResult.ERRORNO.NO_ERROR) {
			nodeIndex = -1;
			TransitRouteOverlay overlay = new MyTransitRouteOverlay(mBaiduMap);
			mBaiduMap.setOnMarkerClickListener(overlay);
			routeOverlay = overlay;
			overlay.setData(result.getRouteLines().get(0));
			overlay.addToMap();
			overlay.zoomToSpan();
		}
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult result) {
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(RoutePlanActivity.this, "抱歉，未找到结果",
					Toast.LENGTH_SHORT).show();
		}
		if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
			// 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
			// result.getSuggestAddrInfo()
			return;
		}
		if (result.error == SearchResult.ERRORNO.NO_ERROR) {
			distance = result.getRouteLines().get(0).getDistance();
			duration = result.getRouteLines().get(0).getDuration();
			info.setText("步行" + distance + "米" + "  " + "约"
					+ (duration % 3600 / 60) + "分钟");
			info.setVisibility(View.VISIBLE);
			nodeIndex = -1;
			DrivingRouteOverlay overlay = new MyDrivingRouteOverlay(mBaiduMap);
			routeOverlay = overlay;
			mBaiduMap.setOnMarkerClickListener(overlay);
			overlay.setData(result.getRouteLines().get(0));
			overlay.addToMap();
			overlay.zoomToSpan();
		}
	}

	// 定制RouteOverly
	private class MyDrivingRouteOverlay extends DrivingRouteOverlay {

		public MyDrivingRouteOverlay(BaiduMap baiduMap) {
			super(baiduMap);
		}

		@Override
		public BitmapDescriptor getStartMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_st);
			}
			return null;
		}

		@Override
		public BitmapDescriptor getTerminalMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_en);
			}
			return null;
		}
	}

	private class MyWalkingRouteOverlay extends WalkingRouteOverlay {

		public MyWalkingRouteOverlay(BaiduMap baiduMap) {
			super(baiduMap);
		}

		@Override
		public BitmapDescriptor getStartMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_st);
			}
			return null;
		}

		@Override
		public BitmapDescriptor getTerminalMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_en);
			}
			return null;
		}
	}

	private class MyTransitRouteOverlay extends TransitRouteOverlay {

		public MyTransitRouteOverlay(BaiduMap baiduMap) {
			super(baiduMap);
		}

		@Override
		public BitmapDescriptor getStartMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_st);
			}
			return null;
		}

		@Override
		public BitmapDescriptor getTerminalMarker() {
			if (useDefaultIcon) {
				return BitmapDescriptorFactory.fromResource(R.drawable.icon_en);
			}
			return null;
		}
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
		mSearch.destroy();
		// 退出时销毁定位
		mLocClient.stop();
		mMapView.onDestroy();
		if (timer != null) {
			timer.cancel();
			timer = null;
		}
		super.onDestroy();
	}

}
