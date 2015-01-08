/**
 * 文件名称 : HooUserInfo.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年6月6日, 下午5:38:48
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : HooUserInfo.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年6月6日, 下午5:38:48
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * @author LIJUNJIE
 *
 */
public class HooUserInfo implements Serializable{
	
	/*--------------盒子端构造一条绑定消息必要的属性---------------*/
	
    //用户名称
    String cnName;
    //用户头像地址
    String portraitPic;
    //用户手机号
    String mobile;
    
    /*--------------以下不知道是干嘛用的，LY---------------*/
    
    @Deprecated
    String realName;
    String birthdate;
    String birthdateBegin;
    String birthdateEnd;
    String email;
    String enName;
    int familyType;
    String loginName;
    String mac;
    int mailAudit;
    String newMobile;
    String newPassword;
    String password;
    String registerDate;
    String registerDateBegin;
    String registerDateEnd;
    String registerIp;
    String remark;
    String signMd5;
    int status;
    String subscriberId;
    int type;
    String updateTime;
    String updateTimeBegin;
    String updateTimeEnd;
    String userId;
    boolean vip;
    
    public String getCnName() {
        return cnName;
    }
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getBirthdateBegin() {
        return birthdateBegin;
    }
    public void setBirthdateBegin(String birthdateBegin) {
        this.birthdateBegin = birthdateBegin;
    }
    public String getBirthdateEnd() {
        return birthdateEnd;
    }
    public void setBirthdateEnd(String birthdateEnd) {
        this.birthdateEnd = birthdateEnd;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEnName() {
        return enName;
    }
    public void setEnName(String enName) {
        this.enName = enName;
    }
    public int getFamilyType() {
        return familyType;
    }
    public void setFamilyType(int familyType) {
        this.familyType = familyType;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public int getMailAudit() {
        return mailAudit;
    }
    public void setMailAudit(int mailAudit) {
        this.mailAudit = mailAudit;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getNewMobile() {
        return newMobile;
    }
    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public String getRegisterDateBegin() {
        return registerDateBegin;
    }
    public void setRegisterDateBegin(String registerDateBegin) {
        this.registerDateBegin = registerDateBegin;
    }
    public String getRegisterDateEnd() {
        return registerDateEnd;
    }
    public void setRegisterDateEnd(String registerDateEnd) {
        this.registerDateEnd = registerDateEnd;
    }
    public String getRegisterIp() {
        return registerIp;
    }
    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getSignMd5() {
        return signMd5;
    }
    public void setSignMd5(String signMd5) {
        this.signMd5 = signMd5;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getSubscriberId() {
        return subscriberId;
    }
    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateTimeBegin() {
        return updateTimeBegin;
    }
    public void setUpdateTimeBegin(String updateTimeBegin) {
        this.updateTimeBegin = updateTimeBegin;
    }
    public String getUpdateTimeEnd() {
        return updateTimeEnd;
    }
    public void setUpdateTimeEnd(String updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public boolean isVip() {
        return vip;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    
}