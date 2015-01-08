package com.lll.lookfor.crossbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/** 底部弹出按钮使用的布局,原先的注释无法正常显示了，LY */
@SuppressLint("ViewConstructor")
public class composerLayout extends RelativeLayout {

	public static byte RIGHTBOTTOM = 1, CENTERBOTTOM = 2, LEFTBOTTOM = 3, LEFTCENTER = 4, LEFTTOP = 5, CENTERTOP = 6, RIGHTTOP = 7, RIGHTCENTER = 8;
	private boolean hasInit = false; // ��ʼ����δ
	private boolean areButtonsShowing = false;// �Ѓ�չ�_
	private Context mycontext;
	private ImageView cross; // �����o���g��ʮ��
	private RelativeLayout rlButton;// �����o
	private myAnimations myani; // �Ӯ��
	private LinearLayout[] llayouts; // �Ӱ��o��
	private int duretime = 300;

	/**
	 * ���캯�� ������՘��캯�����xȡ������������Ҫ��values����むattr��ͬ��layout��xml��Ҫ��������g�������� ����Ԓ~�ö��˿�����֪�c�ã����҅���̫�ࣨ����N���Ӱ��o��̎����������^�_�¡� ���Զ��Ǭ��むinit()��������java��a�{�ã����xxml���� ���Ԙ��캯��ֻӛ䛂�context����
	 */
	public composerLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.mycontext = context;
	}

	public composerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mycontext = context;
	}

	public composerLayout(Context context) {
		super(context);
		this.mycontext = context;
	}

	/**
	 * ��ʼ��
	 * 
	 * @param imgResId
	 *            �Ӱ��o���DƬdrawalbe��id[]
	 * @param showhideButtonId
	 *            �����o���DƬdrawable��id
	 * @param crossId
	 *            �����o������D��ʮ�ֆ��DƬdrawable��id
	 * @param pCode
	 *            λ�ô�a�����硰���Ͻǡ��SALIGN_PARENT_BOTTOM|ALIGN_PARENT_RIGHT
	 * @param radius
	 *            �돽
	 * @param durationMillis
	 *            time duration for the main button
	 */
	public void init(int[] imgResId, int showhideButtonId, int crossId, byte pCode, int radius, final int durationMillis) {
		duretime = durationMillis;
		// ̎��pcode�����Զ��x��λ��ֵ�ĳ�alignֵ
		int align1 = 12, align2 = 14;
		if (pCode == RIGHTBOTTOM) { // ���½�
			align1 = ALIGN_PARENT_RIGHT;
			align2 = ALIGN_PARENT_BOTTOM;
		} else if (pCode == CENTERBOTTOM) {// ����
			align1 = CENTER_HORIZONTAL;
			align2 = ALIGN_PARENT_BOTTOM;
		} else if (pCode == LEFTBOTTOM) { // ���½�
			align1 = ALIGN_PARENT_LEFT;
			align2 = ALIGN_PARENT_BOTTOM;
		} else if (pCode == LEFTCENTER) { // ����
			align1 = ALIGN_PARENT_LEFT;
			align2 = CENTER_VERTICAL;
		} else if (pCode == LEFTTOP) { // ���Ͻ�
			align1 = ALIGN_PARENT_LEFT;
			align2 = ALIGN_PARENT_TOP;
		} else if (pCode == CENTERTOP) { // ����
			align1 = CENTER_HORIZONTAL;
			align2 = ALIGN_PARENT_TOP;
		} else if (pCode == RIGHTTOP) { // ���Ͻ�
			align1 = ALIGN_PARENT_RIGHT;
			align2 = ALIGN_PARENT_TOP;
		} else if (pCode == RIGHTCENTER) { // ����
			align1 = ALIGN_PARENT_RIGHT;
			align2 = CENTER_VERTICAL;
		} else if (pCode == ALIGN_BOTTOM) {
			align1 = ALIGN_PARENT_LEFT;
			align2 = ALIGN_PARENT_BOTTOM;
		}
		// ����^�돽������
		RelativeLayout.LayoutParams thislps = (LayoutParams) this.getLayoutParams();
		Bitmap mBottom = BitmapFactory.decodeResource(mycontext.getResources(), imgResId[0]);
		if (pCode == CENTERBOTTOM || pCode == CENTERTOP) {
			if (thislps.width != -1 && thislps.width != -2 && thislps.width < (radius + mBottom.getWidth() + radius * 0.1) * 2) {
				thislps.width = (int) ((radius * 1.1 + mBottom.getWidth()) * 2);
			}
		} else {
			if (thislps.width != -1 && thislps.width != -2 && thislps.width < radius + mBottom.getWidth() + radius * 0.1) { // -1�SFILL_PARENT��-2�SWRAP_CONTENT
				// ���animation��setInterpolator�O��OvershootInterpolator����ϵ����Ŀ��֮����Ȼ�ж�һ�Σ����^Ŀ��λ�ã�~Ȼ���ٿs����Ŀ��λ�ã����Ը�layout��Ҫ�ٷŴ����١�������؂�OvershootInterpolator�Ӽ{���Sһ�����������c��ֵ���ڽ��^һ���㷨Ӌ������r�g�������Ҫ����؂������D�Q�����x��ֵ���ͱ��^�韩��������ֻϵ����Ӆ�1/10���돽����׷��������~���������о���OvershootInterpolator�ͬAnimation�http://www.oschina.net���ԓh��android
				// sdk��Դ�a��
				thislps.width = (int) (radius * 1.1 + mBottom.getWidth());
			}
		}
		if (pCode == LEFTCENTER || pCode == RIGHTCENTER) {
			if (thislps.height != -1 && thislps.height != -2 && thislps.height < (radius + mBottom.getHeight() + radius * 0.1) * 2) {
				thislps.width = (int) ((radius * 1.1 + mBottom.getHeight()) * 2);
			}
		} else {
			if (thislps.height != -1 && thislps.height != -2 && thislps.height < radius + mBottom.getHeight() + radius * 0.1) {
				thislps.height = (int) (radius * 1.1 + mBottom.getHeight());
			}
		}
		this.setLayoutParams(thislps);
		// �ɂ���Ҫ��
		RelativeLayout rl1 = new RelativeLayout(mycontext);// �������Ӱ��o����

		rlButton = new RelativeLayout(mycontext); // ����Ť
		llayouts = new LinearLayout[imgResId.length];
		// N���Ӱ��o
		for (int i = 0; i < imgResId.length; i++) {
			ImageView img = new ImageView(mycontext);// �Ӱ�Ť�DƬ

			img.setImageResource(imgResId[i]);
			LinearLayout.LayoutParams llps = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

			img.setLayoutParams(llps);
			llayouts[i] = new LinearLayout(mycontext);// �Ӱ��o��
			llayouts[i].setId(100 + i);// �S���O��id������onclick���r���R�e���������؂�idֵ�S�����O�������l�Fͬ����ؼ��_ͻ�����и�һ�¡�
			llayouts[i].addView(img);

			RelativeLayout.LayoutParams rlps = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			rlps.alignWithParent = true;
			rlps.addRule(align1, RelativeLayout.TRUE);
			rlps.addRule(align2, RelativeLayout.TRUE);
			llayouts[i].setLayoutParams(rlps);
			llayouts[i].setVisibility(View.INVISIBLE);// �˴�����ΪGONE
			rl1.addView(llayouts[i]);
		}
		RelativeLayout.LayoutParams rlps1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
		rlps1.alignWithParent = true;
		rlps1.addRule(align1, RelativeLayout.TRUE);
		rlps1.addRule(align2, RelativeLayout.TRUE);
		rl1.setLayoutParams(rlps1);

		RelativeLayout.LayoutParams buttonlps = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		buttonlps.alignWithParent = true;
		buttonlps.addRule(align1, RelativeLayout.TRUE);
		buttonlps.addRule(align2, RelativeLayout.TRUE);
		rlButton.setLayoutParams(buttonlps);
		rlButton.setBackgroundResource(showhideButtonId);
		cross = new ImageView(mycontext);
		cross.setImageResource(crossId);
		RelativeLayout.LayoutParams crosslps = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		crosslps.alignWithParent = true;
		crosslps.addRule(CENTER_IN_PARENT, RelativeLayout.TRUE);
		cross.setLayoutParams(crosslps);
		rlButton.addView(cross);
		myani = new myAnimations(rl1, pCode, radius);// ����ԭ���������pCode�������ڲ�����
		rlButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (areButtonsShowing) {
					myani.startAnimationsOut(duretime);
					cross.startAnimation(myAnimations.getRotateAnimation(-225, 0, duretime));
				} else {
					myani.startAnimationsIn(duretime);
					cross.startAnimation(myAnimations.getRotateAnimation(0, -225, duretime));
				}
				areButtonsShowing = !areButtonsShowing;
			}
		});

		cross.startAnimation(myAnimations.getRotateAnimation(0, 360, 200));
		this.addView(rl1);
		this.addView(rlButton);
		hasInit = true;

	}

	/**
	 * ����
	 */
	// public void collapse() {
	// myani.startAnimationsOut(duretime);
	// cross.startAnimation(myAnimations.getRotateAnimation(-270, 0, duretime));
	// areButtonsShowing = false;
	// }

	/**
	 * ���_
	 */
	// public void expand() {
	// myani.startAnimationsIn(duretime);
	// cross.startAnimation(myAnimations.getRotateAnimation(0, -270, duretime));
	// areButtonsShowing = true;
	// }

	/**
	 * ��ʼ����δ���䌍��ؿ�ã�ԭ���оͱ�����
	 */
	// public boolean isInit() {
	// return hasInit;
	// }

	/**
	 * �Ѓ�չ�_���䌍��ؿ�ã�ԭ���оͱ�����
	 */
	// public boolean isShow() {
	// return areButtonsShowing;
	// }

	/**
	 * �O�ø��Ӱ��o��onclick�¼�
	 */
	public void setButtonsOnClickListener(final OnClickListener l) {

		if (llayouts != null) {
			for (int i = 0; i < llayouts.length; i++) {
				if (llayouts[i] != null)
					llayouts[i].setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(final View view) {
							// �˴���������¼����簴ť����������ز˵�
							// collapse();
							l.onClick(view);
						}

					});
			}
		}
	}
}
