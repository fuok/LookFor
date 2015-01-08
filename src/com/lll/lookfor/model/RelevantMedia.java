/**
 * 作者信息 : HXM
 * 
 * 创建时间 : 2014年11月14日, 上午11:03:09
 * 
 */

package com.lll.lookfor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 影视详情相关影片
 * 
 */
public class RelevantMedia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnId;
	private String columnName;
	private ArrayList<Media> mediaList;
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public ArrayList<Media> getMedia() {
		return mediaList;
	}
	public void setMedia(ArrayList<Media> mediaList) {
		this.mediaList = mediaList;
	}
	@Override
	public String toString() {
		return "RelevantMedia [columnId=" + columnId + ", columnName="
				+ columnName + ", media=" + mediaList + "]";
	}

}
