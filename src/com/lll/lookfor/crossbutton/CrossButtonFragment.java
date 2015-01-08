package com.lll.lookfor.crossbutton;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lll.lookfor.R;

/** 为了便于使用，把底部弹出按钮的实现，封装在这个Fragment里面，LY */
public class CrossButtonFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		View rootView = inflater.inflate(R.layout.fragment_cross_button, container, false);

		composerLayout clayout = (composerLayout) rootView.findViewById(R.id.composerLayout);
		clayout.init(new int[] { R.drawable.composer_camera, R.drawable.composer_music, R.drawable.composer_place, R.drawable.composer_sleep, R.drawable.composer_thought, R.drawable.composer_with },
				R.drawable.composer_button, R.drawable.composer_icn_plus, composerLayout.LEFTBOTTOM, 180,// �����������ӵ�ˮƽ��ʾ
				1000);
		// �ӂ��c���O ��100+0����composer_camera��100+1����composer_music�������������Ў׶������o�ͼӎ׶�����
		OnClickListener clickit = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (v.getId() == 100 + 0) {
					Toast.makeText(getActivity(), "��һ��", Toast.LENGTH_SHORT).show();
				} else if (v.getId() == 100 + 1) {
					System.out.println("composer_music");
				} else if (v.getId() == 100 + 2) {
					System.out.println("composer_place");
				} else if (v.getId() == 100 + 3) {
					System.out.println("composer_sleep");
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
