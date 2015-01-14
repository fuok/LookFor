package com.lll.lookfor.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lll.lookfor.R;

/** 向导图页面，首次启动可以看到这个 */
public class UserGuideActivity extends Activity implements OnPageChangeListener {
	// 用户向导页面和圆点
	private ViewPager vPager;
	private ViewPagerAdapter adapter;
	private ArrayList<ImageView> images;// 存放向导图
	private int currentItem; // 当前页面
	// 向导图片放在本地，保存图片的id
	private int imageIds[] = new int[] { R.drawable.guide_one, R.drawable.guide_two };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.act__user_guide);
		vPager = (ViewPager) findViewById(R.id.vp);
		/*
		 * dotsLayout = (LinearLayout) findViewById(R.id.dot_layout); dots.get(oldPosition).setBackgroundResource(R.drawable.dot_focus);
		 */
		initview();// 初始化图片和圆点
		adapter = new ViewPagerAdapter();
		vPager.setAdapter(adapter);
		vPager.setOnPageChangeListener(this);

	}

	private void initview() {

		images = new ArrayList<ImageView>();// 显示的图片
		for (int i = 0; i < imageIds.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setBackgroundResource(imageIds[i]);
			if (i == imageIds.length - 1) {// 如果是最后一张图，设置一下跳转
				imageView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						UserGuideActivity.this.startActivity(new Intent(UserGuideActivity.this, MainActivity.class));
						UserGuideActivity.this.finish();
					}
				});
			}

			images.add(imageView);
			/*
			 * ImageView dot = new ImageView(this); dot.setBackgroundResource(R.drawable.dot_nomal); dot.setLayoutParams(new LayoutParams(30, 30)); dots.add(dot); dotsLayout.addView(dot);
			 */

		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	// 图片滚动时设置两边的箭头
	@Override
	public void onPageSelected(int position) {
		/*
		 * dots.get(oldPosition).setBackgroundResource(R.drawable.dot_nomal); dots.get(position).setBackgroundResource(R.drawable.dot_focus);
		 */
		// Log.w("liuy", "检查viewPager位置："+position);
		currentItem = position;
		switch (position) {
		case 0:
			// findViewById(R.id.arrow_left).setVisibility(View.INVISIBLE);
			break;
		case 1:
			// findViewById(R.id.arrow_left).setVisibility(View.VISIBLE);
			break;
		}

	}

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return images.size();
		}

		// 是否是同一张图片
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup view, int position, Object object) {
			view.removeView(images.get(position));

		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			view.addView(images.get(position));
			return images.get(position);
		}
	}

}
