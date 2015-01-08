/**
 * 文件名称 : ReportUtil.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年8月15日, 上午11:23:31
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : ReportUtil.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年8月15日, 上午11:23:31
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;

import com.lll.lookfor.model.HooLoginBean;
import com.lll.lookfor.model.UserInfo;
import com.lll.lookfor.network.HooHttpResponse;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * @author LIJUNJIE
 *
 */
public class ReportUtil {
    static String reportVersion = "V1.0";
    static String reportCode = "S0001";
    static String asReportVersion = "V1.0";
    static String asReportCode="ASL0001";
    
    static String deviceId = "";
    static String version = "";
    static String terminalId = "";
    static String appCode = "";
    static String userId = "";
    /**
     * 电信业务帐号
     */
    static String businAccount = "";
    static boolean isHooInit = false;
    static boolean isASInit = false;
    //开始时间，从reportLogin开始算起
    static String startTime="";
    
    static AsyncHttpResponseHandler handler = new AsyncHttpResponseHandler() {
        
        @Override
        public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {

        }
        
        @Override
        public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
            
        }
        
    };
    /**
     * 
     * @param deviceId      设备唯一表示
     * @param userId        用户Id
     * @param version       软件版本号(versionName)
     * @param terminalId    渠道编号
     * @param appCode       软件Code
     */
    public static void initHooReport(String deviceId,String userId,String version,String terminalId,String appCode){
        if(deviceId != null){
            ReportUtil.deviceId = deviceId;
        }
        if(userId != null){
            ReportUtil.userId = userId;
        }
        if(version != null){
            ReportUtil.version = version;
        }
        if(terminalId != null){
            ReportUtil.terminalId = terminalId;
        }
        if(appCode != null){
            ReportUtil.appCode = appCode;
        }
        isHooInit = true;
    }
    
    /**
     * 格式化URL
     * @param url
     * @return
     */
    static public String formatURI(String url){
        String newURL = "";
        try {
            newURL = URLEncoder.encode(url,"UTF-8");
        }
        catch (UnsupportedEncodingException e) {
        }
        return newURL;
    }
    
    /**
     * 家庭圈上报登录结果
     * @param response  登录请求返回值
     */
    public static boolean reportTVChatLogin(HooHttpResponse<HooLoginBean> response){
        if(!isHooInit){
            return false;
        }
        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
        response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss);
        
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVCHAT_REPORT_LOGIN)+"?log="+formatURI(param), handler);
        return true;
    }

    /**
     *家庭圈上报软件开启结束情况 
     * @param isStart true开启，false关闭
     */
    public static boolean reportTVChatExit(String startTime,String endTime){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
        startTime+"|"+endTime;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVCHAT_REPORT_EXIT)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 家庭圈上报错误信息 (调用后台接口出错时调用,crashMsg可以为"")
     * @param response
     * @param crashMsg
     * @return
     */
    public static boolean reportTVChatError(HooHttpResponse response,String crashMsg){
        if(!isHooInit){
            return false;
        }
        if(response == null ){
            return false;
        }
        if(crashMsg == null){
            crashMsg = "";
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
        response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+crashMsg;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVCHAT_REPORT_ERROR)+"?log="+formatURI(param), handler);
        
        return true;
    }
    /**
     * 家庭圈上报更新信息
     */
    public static boolean reportTVChatUpgrade(String startTime,String endTime,int status,int length,String upgradeVersionNo,String channelCode){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+
        		"|"+startTime+"|"+endTime+"|"+status+"|"+length+"|"+upgradeVersionNo+"|"+channelCode;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVCHAT_REPORT_UPGRADE)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 家庭圈上报删除信息
     */
    public static boolean reportTVChatUninstall(){
        if(!isHooInit){
            return false;
        }
        
        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVCHAT_REPORT_UNINSTALL)+"?log="+formatURI(param), handler);
        return true;
    }
  //TODO -------------------------手机上报-----------------------------------------------------------------------------------
    /**
     * 手机上报登录结果
     * @param response  登录请求返回值
     * @param userId    用户Id由aaa返回
     */
    public static boolean reportTVPlayerLogin(HooHttpResponse<UserInfo> response){
        if(!isHooInit){
            return false;
        }

		UserInfo userInfo = response.getBody();
        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|" + userInfo.getSubscriberId() + "|"+version+"|"+terminalId+"|"+appCode+"|"+
        response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss);
        
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_LOGIN)+"?log="+formatURI(param), handler);
        return true;
    }
    
    /**
     *手机上报软件开启结束情况 
     * @param isStart true开启，false关闭
     */
    public static boolean reportTVPlayerAction(String startTime,String endTime){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
        startTime+"|"+endTime;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_ACTION)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 手机上报错误信息 (调用后台接口出错时调用,crashMsg可以为"")
     * @param response
     * @param crashMsg
     * @return
     */
    public static boolean reportTVPlayerError(HooHttpResponse response,String crashMsg){
        if(!isHooInit){
            return false;
        }
        if(response == null ){
            return false;
        }
        if(crashMsg == null){
            crashMsg = "";
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
        response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+crashMsg;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_ERROR)+"?log="+formatURI(param), handler);
        
        return true;
    }
    /**
     * 手机上报更新信息
     */
    public static boolean reportTVPlayerUpgrade(String startTime,String endTime,int status,int length,String upgradeVersionNo,String channelCode){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+
        		"|"+startTime+"|"+endTime+"|"+status+"|"+length+"|"+upgradeVersionNo+"|"+channelCode;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_UPGRADE)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 手机上报删除信息
     */
    public static boolean reportTVPlayerUninstall(){
        if(!isHooInit){
            return false;
        }

        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_UNINSTALL)+"?log=", handler);
        return true;
    }
    
    /**
     * 点播播放数据上报
     * @param packageId     媒资包Id
     * @param mediaId       媒资Id
     * @param mediaName     节目名称
     * @param mediaFile     节目文件
     * @param status        播放状态：0开始播放，1结束播放，2持续播放
     * @param netWorkType   网络类型：0 WIFI，1 3G/4G网络
     * @param duration      节目播放时长，单位:秒
     * @return
     */
    public static boolean reportTVPlayerVODPlaying(String packageId,String mediaId,String mediaName,String mediaFile,int status,int netWorkType,String duration){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
                packageId + "|" + mediaId + "|" + mediaName+"|"+mediaFile+"|"+duration+"|"+status+"|"+netWorkType+"|2||||||||||";
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_VOD_PLAYING)+"?log="+formatURI(param), handler);
        return true;
    }
    
    /**
     *  
     * @param packageId     媒资包Id
     * @param mediaId       媒资Id
     * @param mediaName     节目名称
     * @param errorCode     来源于获取节目详情的RC
     * @param netWorkType   网络类型：0WIFI，13G/4G网络
     * @return
     */
    public static boolean reportTVPlayerVODDetail(String packageId,String mediaId,String mediaName,int errorCode,int netWorkType ){
        if(!isHooInit){
            return false;
        }
        
        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
                packageId + "|" + mediaId + "|" + mediaName+"|"+netWorkType+"|"+errorCode;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_VOD_DETAIL)+"?log="+formatURI(param), handler);
        
        return true;
    }
    
    /**
     * 上报用户位置
     * 注：目前由于百度SDK获取不到省份代码，故省份代码留空
     * @param longitude
     * @param latitude
     * @param provinceName
     * @param cityCode
     * @param cityName
     * @return
     */
    public static boolean reportTVPlayerPosition(double longitude,double latitude,String provinceName,String cityCode,String cityName){
        if(!isHooInit){
            return false;
        }

        String param = reportVersion+"|"+reportCode+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+userId+"|"+version+"|"+terminalId+"|"+appCode+"|"+
                longitude+"|"+ latitude+"||"+provinceName+"|"+cityCode+"|"+cityName;
                HttpUtil.get(HooConstant.getURL(HooConstant.URL_TVPLAYER_REPORT_POSITION)+"?log="+formatURI(param), handler);
        return true;
    }
    //TODO -------------------------爱上上报-----------------------------------------------------------------------------------
    public static void initASReport(String deviceId,String userId,String version,String terminalId,String appCode,String businAccount){
        startTime = DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss);
        if(deviceId != null){
            ReportUtil.deviceId = deviceId;
        }
        if(userId != null){
            ReportUtil.userId = userId;
        }
        if(version != null){
            ReportUtil.version = version;
        }
        if(terminalId != null){
            ReportUtil.terminalId = terminalId;
        }
        if(appCode != null){
            ReportUtil.appCode = appCode;
        }
        if(businAccount != null){
            ReportUtil.businAccount = businAccount;
        }
        isASInit = true;
    }
    
    /**
     * 上报登录结果
     * @param response  登录请求返回值
     */
    public static boolean reportASLogin(HooHttpResponse<HooLoginBean> response){
        if(!isASInit){
            return false;
        }
        //设置开始时间
        String param = asReportVersion+"|ASL0001|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+ version+"|"+appCode+"|"+businAccount+"|"+
        response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+DeviceUtil.getLocalIpAddress()+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss);
        String url = HooConstant.getURL(HooConstant.URL_AS_REPORT_LOGIN)+"?log="+formatURI(param);
        Log.i("ASLOG",url);
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_AS_REPORT_LOGIN)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 上报关闭时间
     * @param
     * @return
     */
    public static boolean reportASExit(){
        if(!isASInit){
            return false;
        }
        
        String param = asReportVersion+"|ASL0002|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+ version+"|"+appCode+"|"+businAccount+"|"+
                startTime+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss);
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_AS_REPORT_EXIT)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 
     * @param response  请求结果
     * @param errInfo   错误信息
     * @return
     */
    public static boolean reportASError(HooHttpResponse response,String errInfo){
        if(!isASInit){
            return false;
        }
        if(errInfo == null){
            errInfo = "";
        }

        String param = asReportVersion+"|ASL0003|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+ version+"|"+appCode+"|"+businAccount+"|"+
                response.getHeader().getRc()+"|"+response.getHeader().getRm()+"|"+errInfo;
        HttpUtil.get(HooConstant.getURL(HooConstant.URL_AS_REPORT_ERROR)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 
     * @param channelName   频道名称
     * @param channelId     频道Id
     * @param programId     节目Id
     * @param programName   节目名称
     * @param playType      播放类型 0直播 1回看 2时移 
     * @param status        0开播 1结束 2持续播放   
     * @param netType       0有线 1无线
     * @param streamType    0 CDN 1组播
     * @return
     */
    public static boolean reportASPlay(String channelName,String channelId,String programId,String programName,int playType,int status,int netType,int streamType){
        if(!isASInit){
            return false;
        }

        String param = reportVersion+"|LIVE0004|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+ version+"|"+appCode+"|"+businAccount+"|"+
                channelName+"|"+channelId+"|"+programId+"|"+programName+"|"+playType+"|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+status+"|||||||||||"+
                netType+"|"+streamType;

        HttpUtil.get(HooConstant.getURL(HooConstant.URL_AS_REPORT_PLAY)+"?log="+formatURI(param), handler);
        return true;
    }
    /**
     * 
     * @param channelId     频道Id
     * @param channelName   频道名称
     */
    public static void reportHoorayPlay(String channelId,String channelName){

        String param = asReportVersion+"|LIVE0004|"+DateUtil.getCurrDate(DateUtil.FORMAT_YYYYMMDDhhmmss)+"|"+deviceId+"|"+ channelName+"|"+channelId;
        HttpUtil.get(HooConstant.HOO_OTT_URL_API_HOST_LOG+"iptvzhjt?api="+formatURI(param), handler);
    }
 }
