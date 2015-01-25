package com.lll.lookfor.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class SharePreferenceUtil {
	public static final String HOOPHONE = "hoophone";
	private static final String USERID = "userId";// UserId
	private static final String SUBSCRIBERID = "subscriberId";// 硬件Id
	private static final String MOBILE = "mobile";// 注册手机号
	private static final String PASSWORD = "password";// 用户密码
	private static final String CNNAME = "cnname";// 中文名
	private static final String INTEGRAL = "integral";// 用户积分
	private static final String PORTRAITPIC = "portraitPic";// 头像地址
	private static final String TOPNUM = "topnum";// 排名
	private static final String DELIVERYNAME = "deliveryname";// 收货姓名
	private static final String DELIVERYADDRESS = "deliveryaddress";// 收货地址
	private static final String DELIVERYPHONE = "deliveryphone";// 收货人电话
	private static final String DELIVERYCODE = "deliverycode";// 收货邮编
	private static final String VERSION = "version";// 版本号
	private static final String STARTTIME = "startTime";// 应用开启时间
	private static final String UPDATETIME = "updateTime";// 应用开始更新时间
	private static final String LENGTH = "length";// 更新包长度
	private static final String UPGRADEVERSIONNO = "upgradeVersionNo";// 更新包版本号
	private static final String PWDFLAG = "pwdFlag";// 是够已经设置了密码

	private static final String USEKEY = "usekey";// 是否第一次使用虎键
	private static final String OPENKEY = "openkey";// 是否开启虎键

	private static final String OPERATORCODE = "operatorCode";// 运营商编码
	private static final String OPERATORNAME = "operatorName";// 运营商名称
	private static final String OPERATORLOGOURL = "operatorLogoUrl";// 运营商图标地址
	private static final String FIRSTSETOPERATOR = "fistSetOperator";// 是否第一次设置运营商

	private static final String VOICE = "voice";// 声音开关
	private static final String SHAKE = "shake";// 震动开关

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public SharePreferenceUtil(Context context, String file) {
		sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// 保存运营商名称
	public void setOperatorName(String operatorName) {
		editor.putString(OPERATORNAME, operatorName);
		editor.commit();
	}

	// 获取运营商名称
	public String getOperatorName() {
		return sp.getString(OPERATORNAME, "");
	}

	// 保存运营商编码
	public void setOperatorCode(String operatorCode) {
		editor.putString(OPERATORCODE, operatorCode);
		editor.commit();
	}

	// 获取运营商编码
	public String getOperatorCode() {
		return sp.getString(OPERATORCODE, "");
	}

	// 保存运营商图标地址
	public void setOperatorLogoUrl(String operatorLogoUrl) {
		editor.putString(OPERATORLOGOURL, operatorLogoUrl);
		editor.commit();
	}

	// 获取运营商图标地址
	public String getOperatorLogoUrl() {
		return sp.getString(OPERATORLOGOURL, "");
	}

	// 保存第一次设置运营商标识
	public void setFirstSetOperator(Boolean flag) {
		editor.putBoolean(FIRSTSETOPERATOR, flag);
		editor.commit();
	}

	// 获取第一次设置运营商标识
	public Boolean getFirstSetOperator() {
		return sp.getBoolean(FIRSTSETOPERATOR, true);
	}

	// 保存用户ID
	public void setPwdFlag(String pwdFlag) {
		editor.putString(PWDFLAG, pwdFlag);
		editor.commit();
	}

	// 获取用户ID
	public String getPwdFlag() {
		return sp.getString(PWDFLAG, "");
	}

	// 是否开启虎键
	public boolean getopenkey() {
		return sp.getBoolean(OPENKEY, true);
	}

	// 设置是否开启虎键
	public void setopenkey(boolean openkey) {
		editor.putBoolean(OPENKEY, openkey);
		editor.commit();
	}

	// 获取用户是否是第一次使用虎键
	public boolean getuseKey() {
		return sp.getBoolean(USEKEY, true);
	}

	// 使用虎键
	public void setuseKey(boolean useKey) {
		editor.putBoolean(USEKEY, useKey);
		editor.commit();
	}

	// 保存用户ID
	public void setUserId(String userId) {
		editor.putString(USERID, userId);
		editor.commit();
	}

	// 获取用户ID
	public String getUserId() {
		return sp.getString(USERID, "0");//这里我设置了默认值，LY
	}

	// 保存硬件ID
	public void setSubscriberId(String subscriberId) {
		editor.putString(SUBSCRIBERID, subscriberId);
		editor.commit();
	}

	// 获取硬件ID
	public String getSubscriberId() {
		return sp.getString(SUBSCRIBERID, "");
	}

	// 保存用户手机号
	public void setMobile(String mobile) {
		editor.putString(MOBILE, mobile);
		editor.commit();
	}

	// 获取用户手机号
	public String getMobile() {
		return sp.getString(MOBILE, "");
	}

	// 保存用户密码
	public void setPassword(String password) {
		editor.putString(PASSWORD, password);
		editor.commit();
	}

	// 获取用户密码
	public String getPassword() {
		return sp.getString(PASSWORD, "");
	}

	// 保存中文昵称
	public void setCnname(String cnname) {
		editor.putString(CNNAME, cnname);
		editor.commit();
	}

	// 获取中文昵称
	public String getCnname() {
		return sp.getString(CNNAME, "");
	}

	// 保存用户积分
	public void setIntegral(String integral) {
		editor.putString(INTEGRAL, integral);
		editor.commit();
	}

	// 获取用户积分
	public String getIntegral() {
		return sp.getString(INTEGRAL, "");
	}

	// 保存用户排名
	public void setTopnum(String topnum) {
		editor.putString(TOPNUM, topnum);
		editor.commit();
	}

	// 获取用户排名
	public String getTopnum() {
		return sp.getString(TOPNUM, "");
	}

	// 保存头像Url
	public void setPortraitPic(String portraitPic) {
		editor.putString(PORTRAITPIC, portraitPic);
		editor.commit();
	}

	// 获取头像Url
	public String getPortraitPic() {
		return sp.getString(PORTRAITPIC, "");
	}

	// 保存收货人
	public void setDeliveryname(String deliveryname) {
		editor.putString(DELIVERYNAME, deliveryname);
		editor.commit();
	}

	// 获取收货人
	public String getDeliveryname() {
		return sp.getString(DELIVERYNAME, "");
	}

	// 保存收货地址
	public void setDeliveryaddress(String deliveryaddress) {
		editor.putString(DELIVERYADDRESS, deliveryaddress);
		editor.commit();
	}

	// 获取收货地址
	public String getDeliveryaddress() {
		return sp.getString(DELIVERYADDRESS, "");
	}

	// 保存收货电话
	public void setDeliveryphone(String deliveryphone) {
		editor.putString(DELIVERYPHONE, deliveryphone);
		editor.commit();
	}

	// 获取收货电话
	public String getDeliveryphone() {
		return sp.getString(DELIVERYPHONE, "");
	}

	// 保存收货邮编
	public void setDeliverycode(String deliverycode) {
		editor.putString(DELIVERYCODE, deliverycode);
		editor.commit();
	}

	// 获取收货邮编
	public String getDeliverycode() {
		return sp.getString(DELIVERYCODE, "");
	}

	// 保存版本号
	public void setVersion(String version) {
		editor.putString(VERSION, version);
		editor.commit();
	}

	// 获取版本号
	public String getVersion() {
		return sp.getString(VERSION, "");
	}

	// 应用开启时间
	public void setStartTime(String startTime) {
		editor.putString(STARTTIME, startTime);
		editor.commit();
	}

	// 获取应用开启时间
	public String getStartTime() {
		return sp.getString(STARTTIME, "");
	}

	// 应用开始更新时间
	public void setUpdateTime(String updateTime) {
		editor.putString(UPDATETIME, updateTime);
		editor.commit();
	}

	// 获取应用开始更新时间
	public String getUpdateTime() {
		return sp.getString(UPDATETIME, "");
	}

	// 保存更新包长度
	public void setLength(int length) {
		editor.putInt(LENGTH, length);
		editor.commit();
	}

	// 获取更新包长度
	public int getLength() {
		return sp.getInt(LENGTH, 0);
	}

	// 保存更新包版本号
	public void setUpgradeVersionNo(String upgradeVersionNo) {
		editor.putString(UPGRADEVERSIONNO, upgradeVersionNo);
		editor.commit();
	}

	// 获取更新包版本号
	public String getUpgradeVersionNo() {
		return sp.getString(UPGRADEVERSIONNO, "");
	}

	// 保存声音开关
	public void setVoice(Boolean voice) {
		editor.putBoolean(VOICE, voice);
		editor.commit();
	}

	// 获取声音开关
	public boolean getVoice() {
		return sp.getBoolean(VOICE, true);
	}

	// 保存震动开关
	public void setShake(Boolean shake) {
		editor.putBoolean(SHAKE, shake);
		editor.commit();
	}

	// 获取震动开关
	public boolean getShake() {
		return sp.getBoolean(SHAKE, false);
	}

	public void saveSinaInfo(String actoken, String screat, String expire) {
		editor.putString("expire", expire);
		editor.putString("access_token", actoken);
		editor.putString("access_tokenSecret", screat);
		editor.commit();
	}

	/**
	 * @author Hendy 用于保存用户信息
	 * @param userId
	 * @param subscriberId
	 * @param mobile
	 * @param password
	 * @param cnname
	 * @param integral
	 * @param portraitPic
	 * @param topnum
	 * @param pwdflag
	 */

	public void saveUserInfo(String userId, String subscriberId, String mobile,
			String password, String cnname, String integral,
			String portraitPic, String topnum, String pwdflag) {

		if (!TextUtils.isEmpty(userId)) {
			editor.putString(USERID, userId).commit();
		}

		if (!TextUtils.isEmpty(subscriberId)) {
			editor.putString(SUBSCRIBERID, subscriberId).commit();
		}

		if (!TextUtils.isEmpty(mobile)) {
			editor.putString(MOBILE, mobile).commit();
		}

		if (!TextUtils.isEmpty(password)) {
			editor.putString(PASSWORD, password).commit();
		}

		if (!TextUtils.isEmpty(cnname)) {
			editor.putString(CNNAME, cnname).commit();
		}

		if (!TextUtils.isEmpty(integral)) {
			editor.putString(INTEGRAL, integral).commit();
		}

		if (!TextUtils.isEmpty(portraitPic)) {
			editor.putString(PORTRAITPIC, portraitPic).commit();
		}

		if (!TextUtils.isEmpty(topnum)) {
			editor.putString(TOPNUM, topnum).commit();
		}

		if (!TextUtils.isEmpty(pwdflag)) {
			editor.putString(PWDFLAG, pwdflag).commit();
		}
	}

	/**
	 * 用于清空用户信息
	 */
	public void clearUserInfo() {
		editor.remove(USERID);
		editor.remove(MOBILE);
		editor.remove(PASSWORD);
		editor.remove(CNNAME);
		editor.remove(INTEGRAL);
		editor.remove(PORTRAITPIC);
		editor.remove(TOPNUM);
		editor.remove(PWDFLAG);
		editor.commit();
	}

}
