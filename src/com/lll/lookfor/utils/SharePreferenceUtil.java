package com.lll.lookfor.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class SharePreferenceUtil {
	public static final String LOOKFOR = "lookfor";
	private static final String USERID = "userId";// UserId
	private static final String SUBSCRIBERID = "subscriberId";// 硬件Id
	private static final String MOBILE = "mobile";// 手机号
	private static final String PASSWORD = "password";// 用户密码
	private static final String NICKNAME = "nickname";// 昵称
	private static final String PORTRAITPIC = "portraitPic";// 头像地址
	private static final String VERSION = "version";// 版本号
	private static final String STARTTIME = "startTime";// 应用开启时间
	private static final String UPDATETIME = "updateTime";// 应用开始更新时间
	private static final String LENGTH = "length";// 更新包长度
	private static final String UPGRADEVERSIONNO = "upgradeVersionNo";// 更新包版本号
	private static final String CITY = "city";// 城市
	private static final String SEX = "sex";// 性别
	private static final String TOKEN ="token";

	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public SharePreferenceUtil(Context context, String file) {
		sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
		editor = sp.edit();
	}

	// 保存用户ID
	public void setUserId(String userId) {
		editor.putString(USERID, userId);
		editor.commit();
	}

	// 获取用户ID
	public String getUserId() {
		return sp.getString(USERID, "");
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

	// 保存昵称
	public void setNickname(String nickname) {
		editor.putString(NICKNAME, nickname);
		editor.commit();
	}

	// 获取昵称
	public String getNickname() {
		return sp.getString(NICKNAME, "");
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

	// 保存城市
	public void setCity(String city) {
		editor.putString(CITY, city);
		editor.commit();
	}

	// 获取城市
	public String getCity() {
		return sp.getString(CITY, "");
	}

	// 保存性别
	public void setSex(int sex) {
		editor.putInt(SEX, sex);
		editor.commit();
	}

	// 获取性别
	public int getSex() {
		return sp.getInt(SEX, 1);
	}
	
	// 保存Token
	public void setToken(String token) {
		editor.putString(TOKEN, token);
		editor.commit();
	}

	// 获取Token
	public String getToken() {
		return sp.getString(TOKEN, "");
	}

	public void saveUserInfo(String userId, int sex, String mobile,
			String password, String nickname, String portraitPic) {

		if (!TextUtils.isEmpty(userId)) {
			editor.putString(USERID, userId).commit();
		}

		editor.putInt(SEX, sex).commit();

		if (!TextUtils.isEmpty(mobile)) {
			editor.putString(MOBILE, mobile).commit();
		}

		if (!TextUtils.isEmpty(password)) {
			editor.putString(PASSWORD, password).commit();
		}

		if (!TextUtils.isEmpty(nickname)) {
			editor.putString(NICKNAME, nickname).commit();
		}

		if (!TextUtils.isEmpty(portraitPic)) {
			editor.putString(PORTRAITPIC, portraitPic).commit();
		}
	}

	/**
	 * 用于清空用户信息
	 */
	public void clearUserInfo() {
		editor.remove(USERID);
		editor.remove(MOBILE);
		editor.remove(PASSWORD);
		editor.remove(NICKNAME);
		editor.remove(PORTRAITPIC);
		editor.commit();
	}

}
