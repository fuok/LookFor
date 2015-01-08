/**
 * 作者信息 : HXM
 * 
 * 创建时间 : 2014年11月19日, 上午11:38:32
 * 
 */

package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * 影视MEDIA
 * 
 */
public class MediaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Media media;

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "MediaBean [media=" + media + "]";
	}

}
