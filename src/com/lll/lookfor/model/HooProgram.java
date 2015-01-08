package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * 节目
 * @author sudan
 */
public class HooProgram implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8152309492640706605L;
	/**
	 * 节目ID
	 */
	private String programId;
	/**
	 * 节目名字
	 */
	private String programName;
	/**
	 * 节目播放地址(如果是追剧展示的是媒资包的剧集展示地址，如果是直播直接进入频道直播流，如果是回看，则进入回看点播地址)
	 */
	private String programPlayUrl;
	/**
	 * 节目类型 1：预约的节目单 2：收藏的影片 3、收藏的电视剧(追剧 暂无)
	 * 如果是检索节目 1：影片  2、电视剧
	 */
	private String mediaType;
	/**
	 * 节目开始播放时间
	 */
	private String startTime;
	/**
	 * 节目结束播放时间
	 */
	private String endTime;
	/**
	 * 节目评分
	 */
	private String score;
	/**
	 * 节目年代
	 */
	private String programYears;
	/**
	 * 节目所属地区
	 */
	private String programRegion;
	/**
	 * 导演
	 */
	private String director;
	/**
	 * 演员
	 */
	private String actor;
	/**
	 * 海报
	 */
	private ArrayList<Poster> posterList;
	/**
	 * 电视剧剧集序号
	 */
	private String mediaSortId;
	/**
	 * 节目所属频道Id
	 */
	private String channelId;
	/**
	 * 节目所属频道名称
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
	 * 节目Id(当前正在播放的节目)
	 */
	private String onlineProgramId;
	/**
	 * 节目名称(当前正在播放的节目)
	 */
	private String onlineProgramName;
	/**
	 * 节目/电视剧媒资包ID
	 */
	private String mediaId;
	/**
	 * 影片/节目名称
	 */
	private String mediaName;
	/**
	 * 描述（影片节目单，剧集）
	 */
	private String description;
	/**
	 * 追剧剧集地址(提供剧集下所有子集)
	 */
	private ArrayList<Episod> episodList;
	/**
	 * VOD影片点播地址
	 */
	private String playURL;
	/**
	 * VOD影片播放时长
	 */
	private String playTime;
	
    /** 节目播出时间与当前时间的关系
     * 0 在指定时间区间之前
	 * 1 在指定时间区间之内
	 * 2 在指定时间区间之后
     */
	private int relativeCurrentSysTime = -1 ;
	/**
	 * 节目播出时间 所属在日期
	 */
	private String date;
	/**
	 * 播放进度(只有点播才有)
	 */
	private int progress;
	/**
	 * 是否有更新 0：否1：是
	 */
	private String updateFlag;
	/**
	 * 最后操作时间
	 */
	private long operationTime;
	/**
	 * 创建时间(节目为关注时)
	 */
	private String createTime;
	/**
	 * 热播节目所属标签ID
	 */
	private String programType;
	/**
	 * 1：全部
     * 2：手机
     * 3：盒子
	 */
	private String downloadFlag;
	/**
	 * 用户操作标识
	 * 如：用户关注、预约对应的操作Id
	 */
	private String operationId;
	/**
	 * 海报地址
	 */
	private String posterURL;
	/**
	 * 追剧剧集地址(提供剧集下所有子集)
	 */
	private String episodURL;
	
	public HooProgram() {
		super();
	}

//	@Override
//	public int describeContents() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void writeToParcel(Parcel dest, int flags) {
//		// TODO Auto-generated method stub
//		dest.writeString(programId);
//		dest.writeString(programName);
//		dest.writeString(programPlayUrl);
//		dest.writeString(mediaType);
//		dest.writeString(startTime);
//		dest.writeString(endTime);
//
//		dest.writeString(score);
//		dest.writeString(programYears);
//		dest.writeString(programRegion);
//		dest.writeString(director);
//		dest.writeString(actor);
//		
//		dest.writeList(posterList);
//		dest.writeString(mediaSortId);
//		dest.writeString(channelId);
//		dest.writeString(channelName);
//		dest.writeString(onlinePlayURL);
//		dest.writeString(backPlayURL);
//		dest.writeString(onlineProgramId);
//		dest.writeString(onlineProgramName);
//		dest.writeString(mediaId);
//		dest.writeString(mediaName);
//		dest.writeString(description);
//		
//		dest.writeList(episodList);
//		dest.writeString(playURL);
//		dest.writeString(playTime);
//		dest.writeInt(relativeCurrentSysTime);
//		dest.writeString(date);
//		dest.writeInt(progress);
//		dest.writeString(updateFlag);
//		dest.writeLong(operationTime);
//		dest.writeString(createTime);
//		dest.writeString(programType);
//		dest.writeString(downloadFlag);
//		dest.writeString(operationId);
//	}
//
//	public static final Parcelable.Creator<HooProgram> CREATOR = new Parcelable.Creator<HooProgram>() {
//		public HooProgram createFromParcel(Parcel in) {
//			return new HooProgram(in);
//		}
//
//		public HooProgram[] newArray(int size) {
//			return new HooProgram[size];
//		}
//	};
//
//	private HooProgram(Parcel in) {
//		programId = in.readString();
//		programName = in.readString();
//		programPlayUrl = in.readString();
//		mediaType = in.readString();
//		startTime = in.readString();
//		endTime = in.readString();
//
//		score = in.readString();
//		programYears = in.readString();
//		programRegion = in.readString();
//		director = in.readString();
//		actor = in.readString();
//		
//		posterList = in.readArrayList(Poster.class.getClassLoader());
//		mediaSortId = in.readString();
//		channelId = in.readString();
//		channelName = in.readString();
//		onlinePlayURL = in.readString();
//		backPlayURL = in.readString();
//		onlineProgramId = in.readString();
//		onlineProgramName = in.readString();
//		mediaId = in.readString();
//		mediaName = in.readString();
//		description = in.readString();
//		
//		episodList = in.readArrayList(Episod.class.getClassLoader());
//		playURL = in.readString();
//		playTime = in.readString();
//		relativeCurrentSysTime = in.readInt();
//		date = in.readString();
//		progress = in.readInt();
//		updateFlag = in.readString();
//		operationTime = in.readLong();
//		createTime = in.readString();
//		programType = in.readString();
//		
//	}


	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramPlayUrl() {
		return programPlayUrl;
	}

	public void setProgramPlayUrl(String programPlayUrl) {
		this.programPlayUrl = programPlayUrl;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
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
	



	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getProgramYears() {
		return programYears;
	}

	public void setProgramYears(String programYears) {
		this.programYears = programYears;
	}

	public String getProgramRegion() {
		return programRegion;
	}

	public void setProgramRegion(String programRegion) {
		this.programRegion = programRegion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	

	public ArrayList<Poster> getPosterList() {
		return posterList;
	}

	public void setPosterList(ArrayList<Poster> posterList) {
		this.posterList = posterList;
	}

	public String getMediaSortId() {
		return mediaSortId;
	}

	public void setMediaSortId(String mediaSortId) {
		this.mediaSortId = mediaSortId;
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

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Episod> getEpisodList() {
		return episodList;
	}

	public void setEpisodList(ArrayList<Episod> episodList) {
		this.episodList = episodList;
	}


	public String getPlayURL() {
		return playURL;
	}

	public void setPlayURL(String playURL) {
		this.playURL = playURL;
	}

	public int getRelativeCurrentSysTime() {
		return relativeCurrentSysTime;
	}

	public void setRelativeCurrentSysTime(int relativeCurrentSysTime) {
		this.relativeCurrentSysTime = relativeCurrentSysTime;
	}

	public String getDate() {
		if (startTime != null) {
			String[] strings = startTime.split(" ");
			if (strings.length > 0) {
				this.date = strings[0];
			}
		}
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public long getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(long operationTime) {
		this.operationTime = operationTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getDownloadFlag() {
		return downloadFlag;
	}

	public void setDownloadFlag(String downloadFlag) {
		this.downloadFlag = downloadFlag;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getEpisodURL() {
		return episodURL;
	}

	public void setEpisodURL(String episodURL) {
		this.episodURL = episodURL;
	}


}
