package com.lll.lookfor.utils;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.loopj.android.http.RequestParams;

public class HooRequestParams extends RequestParams {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HooRequestParams(LinkedHashMap<String, String> linkedHashMap) {
		StringBuffer buffer = new StringBuffer();
		if (linkedHashMap != null && linkedHashMap.size() != 0) {
			for (Entry<String, String> entry : linkedHashMap.entrySet()) {

				put((String) entry.getKey(), entry.getValue());
				buffer.append("&").append(entry.getKey()).append("=")
						.append(entry.getValue());
			}
			buffer.deleteCharAt(buffer.indexOf("&"));
		}

	}
}
