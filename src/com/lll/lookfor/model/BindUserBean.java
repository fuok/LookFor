/**
 * 文件名称 : BindUserBean.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月27日, 上午11:16:45
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : BindUserBean.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月27日, 上午11:16:45
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.model;

import java.io.Serializable;
import java.text.MessageFormat;

import com.lll.lookfor.database.HooDBSql;

/**
 * @author LIJUNJIE
 *
 */
public class BindUserBean implements Serializable,Comparable<BindUserBean> {
	
	/*--------------盒子端构造一条绑定消息必要的属性---------------*/
	
	//绑定的手机端id
	String bindedUserId;
    //盒子端本地id
    String userId;
    //主/副账户标识。1，主；0，副
    int primary;
    //用户信息实体
    HooUserInfo user;
    
    /*--------------以下不知道是干嘛用的，LY---------------*/
    
    //绑定关系的ID
    int bindingId;
    //绑定状态
    int status;
    //用户名
    String name;
    //关系创建时间
    String createTime;
    String updateTime;
    //接收请求用户标记指向被请求方
    int flag;
    

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public HooUserInfo getUser() {
        return user;
    }
    public void setUser(HooUserInfo user) {
        this.user = user;
    }
   
    
    public int getBindingId() {
        return bindingId;
    }
    public void setBindingId(int bindingId) {
        this.bindingId = bindingId;
    }
    public String getBindedUserId() {
        return bindedUserId;
    }
    public void setBindedUserId(String bindedUserId) {
        this.bindedUserId = bindedUserId;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getPrimary() {
        return primary;
    }
    public void setPrimary(int primary) {
        this.primary = primary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
	public String getInsertSql() {
		String sql = MessageFormat.format(HooDBSql.HOO_SQL_USER_INSERT, getBindedUserId(), getUserId(), getPrimary()+"", user.getCnName(), user.getMobile(), user.getPortraitPic());
		return sql;
	}
	
	public String toString(){
		return "bindedUserId="+getBindedUserId()+",userId="+getUserId()+",primary="+getPrimary()+",user.getCnName="+user.getCnName()+",user.getMobile="+user.getMobile()+",user.getPortraitPic="+user.getPortraitPic();
	}
	
	/**根据绑定关系排序，主人账号在前，亲友账号在后*/
	@Override
	public int compareTo(BindUserBean another) {
		return primary>another.getPrimary()?-1:0;
	}
}
