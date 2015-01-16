package com.lll.lookfor.adapter;

import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/** 可见好友列表使用的Adapter */
public class VisiableFriendAdapter extends PagerAdapter {

	private List<View> mViews;

	// private Context mContext;

	public VisiableFriendAdapter(List<View> list, Context context) {
		mViews = list;
		// mContext = context;
	}

	@Override
	public void destroyItem(View collection, int position, Object view) {
		((ViewPager) collection).removeView((View) view);
	}

	@Override
	public void finishUpdate(View arg0) {

	}

	@Override
	public int getCount() {
		if (mViews == null) {
			return 0;
		}
		return mViews.size();
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// 添加一个简单动画，避免添加View太生硬//再议，LY
		// Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
		// mViews.get(position).startAnimation(animation);
		((ViewPager) container).addView(mViews.get(position));
		return mViews.get(position);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void restoreState(Parcelable arg0, ClassLoader arg1) {

	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void startUpdate(View arg0) {

	}

	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	public void refreshView(List<View> list) {
		mViews = list;
		notifyDataSetChanged();
	}

	@Override
	public float getPageWidth(int position) {// 这里是控制ViewPager中每个View的宽度比例，100%是1.0f
		// return super.getPageWidth(position);
		return 0.3f;
	}

	// 据说，只是据说。ViewPager在4.0系统上会出错，是由于这里observer==null，所以重写本方法，增加非空判断
	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		if (observer != null) {
			super.unregisterDataSetObserver(observer);
		}
	}

}
