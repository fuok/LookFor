/**
 * 作者信息 : HXM
 * 
 * 创建时间 : 2014年11月14日, 下午3:58:13
 * 
 */

package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * 影片来源
 * 
 */
public class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceId;
	private String sourceName;
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	@Override
	public String toString() {
		return "Source [sourceId=" + sourceId + ", sourceName=" + sourceName
				+ "]";
	}

}
