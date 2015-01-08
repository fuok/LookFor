/**
 * 文件名称 : HooHttpResponse.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 上午11:39:47
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p> 
 * 
 *  Http响应类，封装公司http Json格式。 body为业务类
 *  { "response":{ "header":{ "rc":0, "rm":"success " }, "body":"XXX" } } 
 **/
package com.lll.lookfor.network;

public class HooHttpResponse<T> {
    //消息头
    ResponseHeader header = new ResponseHeader();
    //消息体，参照各业务类
    T               body;
    
    public ResponseHeader getHeader() {
        return header;
    }
    public void setHeader(ResponseHeader header) {
        this.header = header;
    }
    public T getBody() {
        return body;
    }
    public void setBody(T body) {
        this.body = body;
    }
    
    /**
     *@category  验证后台返回的数据是否包含错误信息！
     *@return true--没有错误信息！
     *@return false--有错误！ 
     */
	public  boolean hasNoError() {
		return this.header == null || this.header.rc != 0 ? false : true;

	}
}
