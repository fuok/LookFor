/**
 * 文件名称 : Log.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年6月16日, 下午3:55:00
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : Log.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年6月16日, 下午3:55:00
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.utils;

/**
 * @author LIJUNJIE
 *
 */
public class Log {
    //log输出形式
    //不输出log
    public static final int LOG_TYPE_NONE = 0;
    //输出log到logcat
    public static final int LOG_TYPE_LOGCAT = 1;
    //输出log到文件
    public static final int LOG_TYPE_FILE = 2;
    //输出log类型结尾该值一定为最大值
    public static final int LOG_TYPE_END = 3;
    
    /**
     * 默认不输出log.
     */
    protected static int logType = LOG_TYPE_LOGCAT;
    
    public void setLogType(int type){
        if(type >= 0 && type < LOG_TYPE_END){
            logType = type;
        }else{
            //默认设置成不打印
            logType = LOG_TYPE_NONE;    
        }
        
    }
    
    // VERBOSE 
    public static void v(String tag,String conent){
        switch(logType){
            case LOG_TYPE_NONE:
                return;
            case LOG_TYPE_LOGCAT:
                android.util.Log.v(tag, conent);
                return ;
            case LOG_TYPE_FILE:
                
                return ;
        }
    }
    
    // INFO 
    public static void i(String tag,String conent){
        switch(logType){
            case LOG_TYPE_NONE:
                return;
            case LOG_TYPE_LOGCAT:
                android.util.Log.i(tag, conent);
                return ;
            case LOG_TYPE_FILE:
                
                return ;
        }
    }
    
    // DEBUG 
    public static void d(String tag,String conent){
        switch(logType){
            case LOG_TYPE_NONE:
                return;
            case LOG_TYPE_LOGCAT:
                android.util.Log.d(tag, conent);
                return ;
            case LOG_TYPE_FILE:
                
                return ;
        }
    }
    
    // WARN
    public static void w(String tag,String conent){
        switch(logType){
            case LOG_TYPE_NONE:
                return;
            case LOG_TYPE_LOGCAT:
                android.util.Log.w(tag, conent);
                return ;
            case LOG_TYPE_FILE:
                
                return ;
        }
    }
    
    // ERROR 
    public static void e(String tag,String conent){
        switch(logType){
            case LOG_TYPE_NONE:
                return;
            case LOG_TYPE_LOGCAT:
                android.util.Log.e(tag, conent);
                return ;
            case LOG_TYPE_FILE:
                
                return ;
        }
    }
}
