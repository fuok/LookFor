package com.lll.lookfor.model;

import java.io.Serializable;

public class PlayFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 播放文件ID
	 */
	private String fileId;
	/**
	 * 播放URL
	 */
	private String playUrl;
	/**
	 * VOD影片播放时长
	 */
	private String playTime;
	/**
	 * 视频类型（视频清淅的中文描述）
	 */
	private String videoType;
	/**
	 * 1：全部 2：手机 3：盒子
	 */
	private String downloadFlag;

	public PlayFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getPlayUrl() {
		return playUrl;
	}

	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public String getDownloadFlag() {
		return downloadFlag;
	}

	public void setDownloadFlag(String downloadFlag) {
		this.downloadFlag = downloadFlag;
	}
	// @Override
	// public int describeContents() {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	// @Override
	// public void writeToParcel(Parcel dest, int flags) {
	// // TODO Auto-generated method stub
	// dest.writeString(fileId);
	// dest.writeString(playUrl);
	// dest.writeString(playTime);
	// dest.writeString(videoType);
	// dest.writeString(downloadFlag);
	// }
	//
	// public PlayFile(Parcel in){
	// fileId = in.readString();
	// playUrl = in.readString();
	// playTime = in.readString();
	// videoType = in.readString();
	// downloadFlag = in.readString();
	// }
	// public static final Parcelable.Creator<PlayFile> CREATOR = new
	// Parcelable.Creator<PlayFile>() {
	// public PlayFile createFromParcel(Parcel in) {
	// return new PlayFile(in);
	// }
	//
	// public PlayFile[] newArray(int size) {
	// return new PlayFile[size];
	// }
	// };

}
