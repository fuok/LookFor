package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;


public class Media implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String mediaId;// 节目/电视剧媒资包ID
	public String mediaName;// 影片/节目名称
	public String actor;// VOD影片演员名称
	public String director;// VOD影片导演名称
	public String posterURL;// 海报地址(节目单无海报)
	public String description;// 描述（影片节目单，剧集）
	public String mediaType;// 1：影片 2、电视剧
	public String downloadFlag;// 1：全部2：手机 3：盒子
	public ArrayList<Poster> posterList;// 海报文件列表
	public ArrayList<Episod> episodList;// 追剧剧集地址
	public String operationId;// 用户操作标识 如：用户关注、预约对应的操作Id
	public String score;// 评分
	public double playProgress;// 播放进度
	public int anthologyNumber;// 当前播放集数
	public int definition;// 清晰度
	public String channelId;//频道id
	private String positiveTotal;//总共集数
	private String chapters;//更新至第N集
	private ArrayList<RelevantMedia> relevantMediaList;//相关影片
	private ArrayList<Source> sourceList;//影片来源

	public Media() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getDownloadFlag() {
		return downloadFlag;
	}

	public void setDownloadFlag(String downloadFlag) {
		this.downloadFlag = downloadFlag;
	}

	public ArrayList<Poster> getPosterList() {
		return posterList;
	}

	public void setPosterList(ArrayList<Poster> posterList) {
		this.posterList = posterList;
	}

	public ArrayList<Episod> getEpisodList() {
		return episodList;
	}

	public void setEpisodList(ArrayList<Episod> episodList) {
		this.episodList = episodList;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public double getPlayProgress() {
		return playProgress;
	}

	public void setPlayProgress(double playProgress) {
		this.playProgress = playProgress;
	}

	public int getAnthologyNumber() {
		return anthologyNumber;
	}

	public void setAnthologyNumber(int anthologyNumber) {
		this.anthologyNumber = anthologyNumber;
	}

	public int getDefinition() {
		return definition;
	}

	public void setDefinition(int definition) {
		this.definition = definition;
	}
	
	public String getChannelId(){
		return channelId;
	}
	
	public void setChannelId(String channelId){
		this.channelId=channelId;
	}

	public String getPositiveTotal() {
		return positiveTotal;
	}

	public void setPositiveTotal(String positiveTotal) {
		this.positiveTotal = positiveTotal;
	}

	public String getChapters() {
		return chapters;
	}

	public void setChapters(String chapters) {
		this.chapters = chapters;
	}

	public ArrayList<RelevantMedia> getRelevantMediaList() {
		return relevantMediaList;
	}

	public void setRelevantMediaList(ArrayList<RelevantMedia> relevantMediaList) {
		this.relevantMediaList = relevantMediaList;
	}

	public ArrayList<Source> getSourceList() {
		return sourceList;
	}

	public void setSourceList(ArrayList<Source> sourceList) {
		this.sourceList = sourceList;
	}

	@Override
	public String toString() {
		return "Media [mediaId=" + mediaId + ", mediaName=" + mediaName
				+ ", actor=" + actor + ", director=" + director
				+ ", posterURL=" + posterURL + ", description=" + description
				+ ", mediaType=" + mediaType + ", downloadFlag=" + downloadFlag
				+ ", posterList=" + posterList + ", episodList=" + episodList
				+ ", operationId=" + operationId + ", score=" + score
				+ ", playProgress=" + playProgress + ", anthologyNumber="
				+ anthologyNumber + ", definition=" + definition
				+ ", channelId=" + channelId + ", positiveTotal="
				+ positiveTotal + ", chapters=" + chapters
				+ ", relevantMediaList=" + relevantMediaList + ", sourceList="
				+ sourceList + "]";
	}

	// public static final Parcelable.Creator<Media> CREATOR = new
	// Parcelable.Creator<Media>() {
	// public Media createFromParcel(Parcel in) {
	// return new Media(in);
	// }
	//
	// public Media[] newArray(int size) {
	// return new Media[size];
	// }
	// };
	//
	// @Override
	// public int describeContents() {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// Media(Parcel in) {
	// mediaId = in.readString();
	// mediaName = in.readString();
	// actor = in.readString();
	// director = in.readString();
	// posterURL = in.readString();
	// description = in.readString();
	// mediaType = in.readString();
	// downloadFlag = in.readString();
	// posterList = in.readArrayList(Poster.class.getClassLoader());
	// episodList = in.readArrayList(Episod.class.getClassLoader());
	// operationId = in.readString();
	// score = in.readString();
	// playProgress = in.readDouble();
	// anthologyNumber = in.readInt();
	// }
	//
	// @Override
	// public void writeToParcel(Parcel dest, int flags) {
	// // TODO Auto-generated method stub
	// dest.writeString(mediaId);
	// dest.writeString(mediaName);
	// dest.writeString(actor);
	// dest.writeString(director);
	// dest.writeString(posterURL);
	// dest.writeString(description);
	// dest.writeString(mediaType);
	// dest.writeString(downloadFlag);
	// dest.writeList(posterList);
	// dest.writeList(episodList);
	// dest.writeString(operationId);
	// dest.writeString(score);
	// dest.writeDouble(playProgress);
	// dest.writeInt(anthologyNumber);
	// }

}
