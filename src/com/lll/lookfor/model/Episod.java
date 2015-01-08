package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Episod implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 剧集标识
	 */
	private String episodId;
	/**
	 * 剧集名称
	 */
	private String episodName;
	/**
	 * 剧集编号
	 */
	private String episodNum;
	/**
	 * 播放文件列表追剧剧集地址(提供剧集下所有子集)
	 */
	private ArrayList<PlayFile> playList;
	/**
	 * 1：全部 2：手机 3：盒子
	 */
	private String downloadFlag;

	public Episod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEpisodId() {
		return episodId;
	}

	public void setEpisodId(String episodId) {
		this.episodId = episodId;
	}

	public String getEpisodName() {
		return episodName;
	}

	public void setEpisodName(String episodName) {
		this.episodName = episodName;
	}

	public String getEpisodNum() {
		return episodNum;
	}

	public void setEpisodNum(String episodNum) {
		this.episodNum = episodNum;
	}

	public ArrayList<PlayFile> getPlayList() {
		return playList;
	}

	public void setPlayList(ArrayList<PlayFile> playList) {
		this.playList = playList;
	}

	public String getDownloadFlag() {
		return downloadFlag;
	}

	public void setDownloadFlag(String downloadFlag) {
		this.downloadFlag = downloadFlag;
	}

	@Override
	public String toString() {
		return "Episod [episodId=" + episodId + ", episodName=" + episodName
				+ ", episodNum=" + episodNum + ", playList=" + playList
				+ ", downloadFlag=" + downloadFlag + "]";
	}

	// @Override
	// public int describeContents() {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	// @Override
	// public void writeToParcel(Parcel dest, int flags) {
	// // TODO Auto-generated method stub
	// dest.writeString(episodId);
	// dest.writeString(episodName);
	// dest.writeString(episodNum);
	// dest.writeString(downloadFlag);
	// dest.writeList(playList);
	// }
	//
	// public Episod(Parcel in){
	// episodId = in.readString();
	// episodName = in.readString();
	// episodNum = in.readString();
	// downloadFlag = in.readString();
	// playList = in.readArrayList(PlayFile.class.getClassLoader());
	// }
	// public static final Parcelable.Creator<Episod> CREATOR = new
	// Parcelable.Creator<Episod>() {
	// public Episod createFromParcel(Parcel in) {
	// return new Episod(in);
	// }
	//
	// public Episod[] newArray(int size) {
	// return new Episod[size];
	// }
	// };

}
