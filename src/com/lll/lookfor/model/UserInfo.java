package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * 用户信息实体
 * 
 * @author Hendy
 * @since 1.4.1
 * @date 2014-10-28
 */
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userId; // 用户ID
	private String mobile;// 手机号码
	private String cnName;// 中文昵称
	private String enName;// 英文昵称
	private String type;// 注册类型
	private String realName;// 真实姓名
	private String email;// 电邮地址
	private String portraitPic;// 头像Url
	private String registerDate;// 注册日期
	private String vip;// VIP
	private String birthdate;// 生日
	private String familyType;// 家庭类型
	private String mailAudit;// 邮箱状态
	private String integral;// 用户积分
	private String topNum;// 用户金币排名
	private String subscriberId;// 硬件id
	private String pwd; // 是否有密码标志
	private double latitude; // 纬度

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPortraitPic() {
		return portraitPic;
	}

	public void setPortraitPic(String portraitPic) {
		this.portraitPic = portraitPic;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getFamilyType() {
		return familyType;
	}

	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}

	public String getMailAudit() {
		return mailAudit;
	}

	public void setMailAudit(String mailAudit) {
		this.mailAudit = mailAudit;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getTopNum() {
		return topNum;
	}

	public void setTopNum(String topNum) {
		this.topNum = topNum;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", mobile=" + mobile
				+ ", cnName=" + cnName + ", enName=" + enName + ", type="
				+ type + ", realName=" + realName + ", email=" + email
				+ ", portraitPic=" + portraitPic + ", registerDate="
				+ registerDate + ", vip=" + vip + ", birthdate=" + birthdate
				+ ", familyType=" + familyType + ", mailAudit=" + mailAudit
				+ ", integral=" + integral + ", topNum=" + topNum
				+ ", subscriberId=" + subscriberId + ", pwd=" + pwd
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	private double longitude; // 经度

}
