package com.lll.lookfor.crossbutton;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lll.lookfor.R;
import com.lll.lookfor.activity.ConveneActivity;
import com.lll.lookfor.activity.MainActivity;
import com.lll.lookfor.activity.TravelActivity;

/** 为了便于使用，把底部弹出按钮的实现，封装在这个Fragment里面，LY */
public class CrossButtonFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View rootView = inflater.inflate(R.layout.fragment_cross_button,
				container, false);

		composerLayout clayout = (composerLayout) rootView
				.findViewById(R.id.composerLayout);
		clayout.init(new int[] { R.drawable.selector_navi_guard,
				R.drawable.selector_navi_convene,
				R.drawable.selector_navi_friends,
				R.drawable.selector_navi_share },
				R.drawable.selector_navi_home, R.drawable.composer_icn_plus,
				composerLayout.LEFTBOTTOM, 180, 500);// 设置动画旋转时长
		// �ӂ��c���O ��100+0����composer_camera��100+1����composer_music�������������Ў׶������o�ͼӎ׶�����
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (v.getId() == 100 + 0) {
					startActivity(new Intent(getActivity(),
							TravelActivity.class));
				} else if (v.getId() == 100 + 1) {
					startActivity(new Intent(getActivity(),
							ConveneActivity.class));
				} else if (v.getId() == 100 + 2) {
					Toast.makeText(getActivity(), "好友", Toast.LENGTH_SHORT)
							.show();
				} else if (v.getId() == 100 + 3) {
					Toast.makeText(getActivity(), "公开位置", Toast.LENGTH_SHORT)
							.show();
				} else if (v.getId() == 100 + 4) {
					System.out.println("composer_thought");
				} else if (v.getId() == 100 + 5) {
					System.out.println("composer_with");
				}
			}
		};
		clayout.setButtonsOnClickListener(clickit);
		return rootView;
	}

}
