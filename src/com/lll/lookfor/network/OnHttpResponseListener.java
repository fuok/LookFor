/**
 * 文件名称 : OnHttpResponseListener.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 上午11:51:20
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 * http请求回调接口
 **/
package com.lll.lookfor.network;

/**
 * @author LIJUNJIE
 *
 */
public interface OnHttpResponseListener {
    public void onSuccess(HooHttpResponse response);
    public void onError(int statusCode,Throwable error,String content);
    public void onStart();
    public void onEnd();
    /**
     * http请求的进度
     * @param bytesWritten  发送的字节数
     * @param totalSize     需要发送的字节总数
     */
    public void onProgress(int bytesWritten, int totalSize);
}
