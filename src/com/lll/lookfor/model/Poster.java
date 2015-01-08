package com.lll.lookfor.model;

import java.io.Serializable;

public class Poster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444332540206434813L;
	/**
	 * 海报标识
	 */
	private String posterId;
	/**
	 * 文件名称
	 */
	private String posterName;
	/**
	 * 海报地址
	 */
	private String localPath;
	/**
	 * 宽度
	 */
	private int width;
	/**
	 * 高度
	 */
	private int height;
	/**另一种判断海报横竖的标识。1，横版。2，竖版*/
	private String posterType;
	private String posterPicUrl;// 海报地址
	private String activityFlag;// 活动标识：0：false 1:true
	public Poster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPosterId() {
		return posterId;
	}

	public void setPosterId(String posterId) {
		this.posterId = posterId;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getPosterType(){
		return posterType;
	}

	public void setPosterType(final String posterType){
		this.posterType=posterType;
	}
	
	public String getPosterPicUrl() {
		return posterPicUrl;
	}

	public void setPosterPicUrl(String posterPicUrl) {
		this.posterPicUrl = posterPicUrl;
	}

	public String getActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(String activityFlag) {
		this.activityFlag = activityFlag;
	}

	@Override
	public String toString() {
		return "Poster [posterId=" + posterId + ", posterName=" + posterName
				+ ", localPath=" + localPath + ", width=" + width + ", height="
				+ height + ", posterType=" + posterType + ", posterPicUrl="
				+ posterPicUrl + ", activityFlag=" + activityFlag + "]";
	}

	// @Override
	// public int describeContents() {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	// @Override
	// public void writeToParcel(Parcel dest, int flags) {
	// // TODO Auto-generated method stub
	// dest.writeString(posterId);
	// dest.writeString(posterName);
	// dest.writeString(localPath);
	// dest.writeInt(width);
	// dest.writeInt(height);
	// }
	//
	// public Poster(Parcel in){
	// posterId = in.readString();
	// posterName = in.readString();
	// localPath = in.readString();
	// width = in.readInt();
	// height = in.readInt();
	// }
	//
	// public static final Parcelable.Creator<Poster> CREATOR = new
	// Parcelable.Creator<Poster>() {
	// public Poster createFromParcel(Parcel in) {
	// return new Poster(in);
	// }
	//
	// public Poster[] newArray(int size) {
	// return new Poster[size];
	// }
	// };

}
