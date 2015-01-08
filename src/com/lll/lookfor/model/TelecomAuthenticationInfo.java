package com.lll.lookfor.model;

import java.util.ArrayList;

/** 
 * 绑定电信返回数据 
 */
public class TelecomAuthenticationInfo {

	/*
	 * 结果 0. 鉴权成功
	 */
	private int RESULT;

	// 合作方ID
	private String SPID;

	// 广电序列号
	private String SN;

	// 机顶盒编码
	private String STBID;

	// 终端ID，电信业务平台唯一标识
	private String CLIENTID;

	// 用户标识
	private String ACCOUNT;

	// 地区代码
	private String AREA;

	// 用户令牌
	private String USERTOKEN;

	// 用户令牌过期时间
	private Long EXPIRETIME;

	// 该合作方对应的已订购产品列表 ，其中每个PRODUCT内部参数为：“P”:productid}

	private ArrayList<ProductId> PRODUCTLIST;
	/**
	 * 错误描述
	 */
	private String MESSAGE;

	public int getRESULT() {
		return RESULT;
	}

	public void setRESULT(int rESULT) {
		RESULT = rESULT;
	}

	public String getSPID() {
		return SPID;
	}

	public void setSPID(String sPID) {
		SPID = sPID;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getSTBID() {
		return STBID;
	}

	public void setSTBID(String sTBID) {
		STBID = sTBID;
	}

	public String getCLIENTID() {
		return CLIENTID;
	}

	public void setCLIENTID(String cLIENTID) {
		CLIENTID = cLIENTID;
	}

	public String getACCOUNT() {
		return ACCOUNT;
	}

	public void setACCOUNT(String aCCOUNT) {
		ACCOUNT = aCCOUNT;
	}

	public String getAREA() {
		return AREA;
	}

	public void setAREA(String aREA) {
		AREA = aREA;
	}

	public String getUSERTOKEN() {
		return USERTOKEN;
	}

	public void setUSERTOKEN(String uSERTOKEN) {
		USERTOKEN = uSERTOKEN;
	}

	public Long getEXPIRETIME() {
		return EXPIRETIME;
	}

	public void setEXPIRETIME(Long eXPIRETIME) {
		EXPIRETIME = eXPIRETIME;
	}

	public ArrayList<ProductId> getPRODUCTLIST() {
		return PRODUCTLIST;
	}

	public void setPRODUCTLIST(ArrayList<ProductId> pRODUCTLIST) {
		PRODUCTLIST = pRODUCTLIST;
	}

	public String getMESSAGE() {
		return MESSAGE;
	}

	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}

}
