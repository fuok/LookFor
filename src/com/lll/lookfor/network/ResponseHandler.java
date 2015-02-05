/**
 * 文件名称 : ResponseHandler.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 上午11:49:15
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 * http回调句柄类
 **/
package com.lll.lookfor.network;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lll.lookfor.utils.HooConstant;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * @author LIJUNJIE
 * 
 */
public class ResponseHandler<T> extends AsyncHttpResponseHandler {
    private static final int MSG_JSON_PARSE_COMPLETE = 0;
	HooHttpResponse<T> httpResponse = new HooHttpResponse<T>();
	Class<T> beanType;
	String responseContent;
	
	Handler handler = new Handler(){
	    public void handleMessage(Message msg){
	        switch(msg.what){
	            case MSG_JSON_PARSE_COMPLETE:
	                if(listener != null){	                    
	                    listener.onSuccess((HooHttpResponse)msg.obj);
	                }
	        }
	    }
	};

	public ResponseHandler(Class<T> cls) {
		beanType = cls;
	}

	public Class<T> getBeanType() {
		return beanType;
	}

	public void setBeanType(Class<T> beanType) {
		beanType = beanType;
	}

	// Http返回结果回调
	OnHttpResponseListener listener;

	/**
	 * 设置http监听器
	 * 
	 * @param listener
	 */
	public void setOnHttpResponseListener(OnHttpResponseListener listener) {
		this.listener = listener;
	}

	/**
	 * 获取监听器
	 * 
	 * @return
	 */
	public OnHttpResponseListener getOnHttpResponseListener() {
		return listener;
	}

	public HooHttpResponse<T> getHttpResponse() {
		return httpResponse;
	}

	public void setHttpResponse(HooHttpResponse<T> httpResponse) {
		this.httpResponse = httpResponse;

	}

	/**
	 * http请求失败回调方法
	 */
	public void onFailure(int statusCode, Header[] headers, byte[] content,
			Throwable error) {
		if (listener != null) {
			try {
				if (content != null) {
					String str = new String(content, "UTF-8");
					listener.onError(statusCode, error, str);
				}else {
					listener.onError(statusCode, error, null);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * http请求开始回调方法
	 */
	@Override
	public void onStart() {
		super.onStart();
		if (listener != null) {
			listener.onStart();
		}
	}

	/**
	 * http请求结束回调方法
	 */
	@Override
	public void onFinish() {
		super.onFinish();
		if (listener != null) {
			listener.onEnd();
		}
	}

	/**
     * 
     */
	@Override
	public void onProgress(int bytesWritten, int totalSize) {
		// TODO Auto-generated method stub
		super.onProgress(bytesWritten, totalSize);
		if (listener != null) {
			listener.onProgress(bytesWritten, totalSize);
		}
	}

	/**
	 * http请求成功回调方法
	 */
	@Override
	public void onSuccess(int statusCode, Header[] headers, byte[] content) {
	    //
	    if (listener != null) {
	        responseContent = null;
            try {
                responseContent = new String(content, "UTF-8");
                Log.v("liuy", responseContent);//测试数据
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                
            }
			new Thread(){
			    public void run(){
			        
			     // 使用Gson解析
		            Gson gson = new Gson();
		            try {
		                HooHttpResult<T> result = new HooHttpResult<T>();
		                // 使用泛型对应业务类，但是GSON不支持广义泛型，只能用Class<T>指定类
		                result = gson.fromJson(responseContent, new TypeToken<HooHttpResult<T>>() {
		                }.getType());
		                if (result != null) {
		                    httpResponse = result.getResponse();
		                    // 从json中抽出body内容，使用强类型进行转换
		                    JSONObject jobj = new JSONObject(responseContent);
		                    JSONObject subobj = jobj.getJSONObject("response");
		                    if (subobj != null) {
		                        JSONObject body = subobj.getJSONObject("body");
		                        // 有些返回结果没有body字段，body的值为null，不处理 lijunjie
		                        if (body != null) {
		                            // 转换成业务类
		                            T bean = gson.fromJson(body.toString(), beanType);// JSON数组中出现空String会导致本行报错,liuy
		                            result.getResponse().setBody(bean);
		                        }
		                    }
		                } else {
		                    throw new JSONException("ERROR!!!!!");
		                }
		            } catch (JsonSyntaxException ex) {
		                ex.printStackTrace();
		                httpResponse = new HooHttpResponse<T>();
		                httpResponse.getHeader().rc = HooConstant.HOO_OTT_ERRORCODE_JSON_PARSE;
		                httpResponse.getHeader().rm = "系统繁忙，请稍后重试！";
		            } catch (JSONException e) {
		                // 有些返回结果没有body字段，body的值为null
		                if (!e.getMessage().equalsIgnoreCase("No value for body")) {
		                    e.printStackTrace();
		                    httpResponse = new HooHttpResponse<T>();
		                    httpResponse.getHeader().rc = HooConstant.HOO_OTT_ERRORCODE_JSON_FORMAT;
		                    httpResponse.getHeader().rm = "系统繁忙，请稍后重试！";
		                }
		            }
		            //回调
		            Message msg = new Message();
		            msg.what = MSG_JSON_PARSE_COMPLETE;
		            msg.obj = httpResponse;
		            handler.sendMessage(msg);
		            //listener.onSuccess(httpResponse);
			    }
			}.start();
		}
	}
}
