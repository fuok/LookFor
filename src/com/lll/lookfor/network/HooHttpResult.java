/**
 * 文件名称 : HooHttpResult.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 下午4:37:00
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * 
 * Http结果类，封装公司http Json格式。 body为业务类
 * HooHttpResult 对应整个json，HooHttpResonse对应子集。
 *  { "response":{ "header":{ "rc":0, "rm":"success " }, "body":"XXX" } } 
 **/

package com.lll.lookfor.network;

/**
 * @author LIJUNJIE
 *
 */
public class HooHttpResult<T> {
   HooHttpResponse<T> response = new HooHttpResponse<T>();

public HooHttpResponse<T> getResponse() {
    return response;
}

public void setResponse(HooHttpResponse<T> response) {
    this.response = response;
}
   
}
