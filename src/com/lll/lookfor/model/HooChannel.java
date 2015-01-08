package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 直播频道
 * @author sudan
 */
public class HooChannel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4889169073783769542L;
	/**
	 * 频道ID
	 */
	private String channelId;
	/**
	 * 频道名称
	 */
	private String channelName;
	/**
	 * 直播源地址
	 */
	private String onlinePlayURL;
	/**
	 * 回看地址
	 */
	private String backPlayURL;
	/**
	 * 当前正在播放节目Id
	 */
	private String onlineProgramId;
	/**
	 * 当前正在播放节目名称
	 */
	private String onlineProgramName;
    /**
     * 节目开始时间
     */
	private String startTime;
	/**
	 * 节目结束时间
	 */
	private String endTime;
	/**
	 * 节目单
	 */
	private ArrayList<HooProgram> programs = new ArrayList<HooProgram>();
	/**
	 * 海报地址
	 */
	private ArrayList<Poster> posterList;
	/**
	 * 用户操作标识
	 */
	private String operationId;
	
//	@Override
//	public int describeContents() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel dest, int flags) {
//		// TODO Auto-generated method stub
//		dest.writeString(channelId);
//		dest.writeString(channelName);
//		dest.writeString(onlinePlayURL);
//		dest.writeString(backPlayURL);
//		dest.writeString(onlineProgramId);
//		dest.writeString(onlineProgramName);
//		dest.writeString(startTime);
//		dest.writeString(endTime);
//		dest.writeList(programs);
//		dest.writeInt(commonlyFlag);
//		dest.writeList(posterList);
//		dest.writeString(operationId);
//	}

//	private HooChannel(Parcel parcel) {
//		channelId = parcel.readString();
//		channelName = parcel.readString();
//		onlinePlayURL = parcel.readString();
//		backPlayURL = parcel.readString();
//		onlineProgramId = parcel.readString();
//		onlineProgramName = parcel.readString();
//		startTime = parcel.readString();
//		endTime = parcel.readString();
//		programs = parcel.readArrayList(HooProgram.class.getClassLoader());
//		commonlyFlag = parcel.readInt();
//		posterList = parcel.readArrayList(Poster.class.getClassLoader());
//		operationId = parcel.readString();
//	}

//	public static final Parcelable.Creator<HooChannel> CREATOR = new Parcelable.Creator<HooChannel>() {
//		public HooChannel createFromParcel(Parcel in) {
//			return new HooChannel(in);
//		}
//
//		public HooChannel[] newArray(int size) {
//			return new HooChannel[size];
//		}
//	};

	public HooChannel() {
		super();
	}

	public HooChannel(String channelId, String channelName, String onlinePlayURL,
			String backPlayURL, String onlineProgramId,
			String onlineProgramName, String startTime, String endTime) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.onlinePlayURL = onlinePlayURL;
        this.backPlayURL = backPlayURL;
        this.onlineProgramId = onlineProgramId;
        this.onlineProgramName = onlineProgramName;
        this.startTime = startTime;
        this.endTime = endTime;
	}
	
	public String toString() {
		return "channelID = " + channelId + " channelName = " + channelName
				+ " onlinePlayURL = " + onlinePlayURL + " backPlayURL = "
				+ backPlayURL + " onlineProgramId = " + onlineProgramId
				+ " onlineProgramName = " + onlineProgramName + " startTime = "
				+ startTime + " endTime = " + endTime+" operationId = "+operationId;
	}


	
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getOnlinePlayURL() {
		return onlinePlayURL;
	}

	public void setOnlinePlayURL(String onlinePlayURL) {
		this.onlinePlayURL = onlinePlayURL;
	}

	public String getBackPlayURL() {
		return backPlayURL;
	}

	public void setBackPlayURL(String backPlayURL) {
		this.backPlayURL = backPlayURL;
	}

	public String getOnlineProgramId() {
		return onlineProgramId;
	}

	public void setOnlineProgramId(String onlineProgramId) {
		this.onlineProgramId = onlineProgramId;
	}

	public String getOnlineProgramName() {
		return onlineProgramName;
	}

	public void setOnlineProgramName(String onlineProgramName) {
		this.onlineProgramName = onlineProgramName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public ArrayList<HooProgram> getPrograms() {
		return programs;
	}

	public void setPrograms(ArrayList<HooProgram> programs) {
		this.programs = programs;
	}
	
	public ArrayList<Poster> getPosterList() {
		return posterList;
	}

	public void setPosterList(ArrayList<Poster> posterList) {
		this.posterList = posterList;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	
	
	
}
