package com.lll.lookfor.crossbutton;

import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.view.ViewPropertyAnimator;

/** 底部弹出按钮使用的动画工具类，需要依赖nineOld的Library，原先的注释无法正常显示了，LY */
public class myAnimations {

	public final int R; // �돽
	public static byte RIGHTBOTTOM = 1, CENTERBOTTOM = 2, LEFTBOTTOM = 3, LEFTCENTER = 4, LEFTTOP = 5, CENTERTOP = 6, RIGHTTOP = 7, RIGHTCENTER = 8;

	private int pc; // λ�ô�̖
	private ViewGroup clayout; // ��laoyout
	private final int amount; // �Ў׶������o
	private double fullangle = 180.0;// �ڎ״���Ƕȃ��Ł�
	private byte xOri = 1, yOri = 1; // x��yֵ�����򣬼�ϵ����߀������
	private boolean isOpen = false;// ��¼���Ѿ��򿪻��ǹر�
	private List<ViewPropertyAnimator> viewAnimators = new ArrayList<ViewPropertyAnimator>();

	/**
	 * ���캯��
	 * 
	 * @param comlayout
	 *            �������o��layout
	 * @param poscode
	 *            λ�ô�̖���քe����RIGHTBOTTOM��CENTERBOTTOM��LEFTBOTTOM��LEFTCENTER�� LEFTTOP��CENTERTOP��RIGHTTOP��RIGHTCENTER
	 * @param radius
	 *            �돽
	 */
	public myAnimations(ViewGroup comlayout, int poscode, int radius) {
		this.pc = poscode;
		this.clayout = comlayout;
		this.amount = clayout.getChildCount();
		this.R = radius;

		// ��ʼ��������ÿ��view��Ӧһ��animator
		for (int i = 0; i < amount; i++) {
			View childAt = clayout.getChildAt(i);
			ViewPropertyAnimator anim = animate(childAt);
			viewAnimators.add(anim);
		}

		if (poscode == RIGHTBOTTOM) { // ���½�
			fullangle = 90;
			xOri = -1;
			yOri = -1;
		} else if (poscode == CENTERBOTTOM) {// ����
			fullangle = 180;
			xOri = -1;
			yOri = -1;
		} else if (poscode == LEFTBOTTOM) { // ���½�
			fullangle = 90;
			xOri = 1;
			yOri = -1;
		} else if (poscode == LEFTCENTER) { // ����
			fullangle = 180;
			xOri = 1;
			yOri = -1;
		} else if (poscode == LEFTTOP) { // ���Ͻ�
			fullangle = 90;
			xOri = 1;
			yOri = 1;
		} else if (poscode == CENTERTOP) { // ����
			fullangle = 180;
			xOri = -1;
			yOri = 1;
		} else if (poscode == RIGHTTOP) { // ���Ͻ�
			fullangle = 90;
			xOri = -1;
			yOri = 1;
		} else if (poscode == RIGHTCENTER) { // ����
			fullangle = 180;
			xOri = -1;
			yOri = -1;
		}
	}

	private class AnimListener implements AnimatorListener {

		private View target;

		public AnimListener(View _target) {
			target = _target;
		}

		@Override
		public void onAnimationStart(Animator animation) {

		}

		@Override
		public void onAnimationEnd(Animator animation) {
			if (!isOpen) {
				target.setVisibility(View.INVISIBLE);
			}
		}

		@Override
		public void onAnimationCancel(Animator animation) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationRepeat(Animator animation) {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * ���ׂ����o����
	 * 
	 * @param durationMillis
	 *            �Î׶��r�g
	 */
	public void startAnimationsIn(int durationMillis) {
		isOpen = true;
		for (int i = 0; i < clayout.getChildCount(); i++) {
			final LinearLayout inoutimagebutton = (LinearLayout) clayout.getChildAt(i);

			double offangle = fullangle / (amount - 1);

			double deltaY, deltaX;
			if (pc == LEFTCENTER || pc == RIGHTCENTER) {
				deltaX = Math.sin(offangle * i * Math.PI / 180) * R;
				deltaY = Math.cos(offangle * i * Math.PI / 180) * R;
			} else {
				deltaY = Math.sin(offangle * i * Math.PI / 180) * R;
				deltaX = Math.cos(offangle * i * Math.PI / 180) * R;
				// �޸�֮
				Log.w("liuy", "�Ƕ���" + offangle);
				deltaX = 80 * i;
			}

			ViewPropertyAnimator viewPropertyAnimator = viewAnimators.get(i);
			viewPropertyAnimator.setListener(null);

			inoutimagebutton.setVisibility(View.VISIBLE);
			// ���·������Ƶ���
			viewPropertyAnimator.x((float) (inoutimagebutton.getLeft() + 80 + xOri * deltaX)).y(// 80�Ǹ����ʼƫ��ֵ
					(float) (inoutimagebutton.getTop() + 0));// yOri * deltaY�޸�֮

		}
	}

	/**
	 * ����ׂ����o��ȥ
	 * 
	 * @param durationMillis
	 *            �Î׶��r�g
	 */
	public void startAnimationsOut(int durationMillis) {
		isOpen = false;
		for (int i = 0; i < clayout.getChildCount(); i++) {
			final LinearLayout inoutimagebutton = (LinearLayout) clayout.getChildAt(i);
			ViewPropertyAnimator viewPropertyAnimator = viewAnimators.get(i);
			viewPropertyAnimator.setListener(null);
			viewPropertyAnimator.x((float) inoutimagebutton.getLeft()).y((float) inoutimagebutton.getTop());
			viewPropertyAnimator.setListener(new AnimListener(inoutimagebutton));

		}

	}

	/**
	 * �@ȡλ�ô�a���䌍ò�ƶ���ؿ�ã�
	 */
	public int getPosCode() {
		return this.pc;
	}

	/**
	 * ���D������ԭ�����І��o�B������δ���w���������{�ã�
	 * 
	 * @param fromDegrees
	 *            �Ď׶��
	 * @param toDegrees
	 *            ���׶��
	 * @param durationMillis
	 *            �D����
	 */
	public static Animation getRotateAnimation(float fromDegrees, float toDegrees, int durationMillis) {
		RotateAnimation rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(durationMillis);
		rotate.setFillAfter(true);
		return rotate;
	}

}