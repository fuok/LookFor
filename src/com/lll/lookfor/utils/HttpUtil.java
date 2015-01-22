package com.lll.lookfor.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpUtil {
	private static AsyncHttpClient client = new AsyncHttpClient(); // 实例化对象
	static {
		client.setTimeout(11000); // 设置链接超时，如果不设置，默认为10s
		client.setMaxConnections(50);
	}
	
	//since V1.4.6
	/**
	 * 删除所有头信息
	 */
	public static void removeAllHeaders(){
	    client.removeAllHeaders();
	}
	
	public static void addHeader(String header,String value){
	    client.addHeader(header, value);
	}
	
	public static void removeHeader(String header){
	    client.removeHeader(header);
	}
	/**
	 * GET方法，获取一个string对象
	 * 
	 * @param urlString
	 *            一个完整url
	 * @param res
	 *            回调接口
	 */
	public static void get(String urlString, AsyncHttpResponseHandler res) {
		client.get(urlString, res);
	}

	/**
	 * 带参数GET方法 获取一个string对象
	 * 
	 * @param urlString
	 *            请求地址
	 * @param params
	 *            参数
	 * @param res
	 *            回调接口
	 */
	public static void get(String urlString, RequestParams params,
			AsyncHttpResponseHandler res) {
		client.get(urlString, params, res);
	}

	/**
	 * GET不带参数，获取json对象或者数组
	 * 
	 * @param urlString
	 *            请求地址
	 * @param res
	 *            回调接口
	 */
	public static void get(String urlString, JsonHttpResponseHandler res) {
		client.get(urlString, res);
	}

	/**
	 * GET 带参数，获取json对象或者数组
	 * 
	 * @param urlString
	 *            请求地址
	 * @param params
	 *            参数
	 * @param res
	 *            回调接口
	 */
	public static void get(String urlString, RequestParams params,
			JsonHttpResponseHandler res) {
		client.get(urlString, params, res);
	}

	/**
	 * 下载二进制数据
	 * 
	 * @param urlString
	 *            下载地址
	 * @param res
	 *            回调接口
	 */
	public static void get(String urlString, BinaryHttpResponseHandler res) {
		client.get(urlString, res);
	}
	/**
	 * POST 不带参数获取一个string对象
	 * 
	 * @param url
	 *            请求地址
	 * @param res
	 *            回调接口
	 */
	public static void post(String url, AsyncHttpResponseHandler res) {
		client.post(url, res);
	}

	/**
	 * POST 带参数获取一个string对象
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param res
	 *            回调接口
	 */
	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler res) {
		client.post(url, params, res);
	}

	
	/**
	 * 获取 AsyncHttpClient 实例
	 * 
	 * @return
	 */
	public static AsyncHttpClient getClient() {
		return client;
	}
}
