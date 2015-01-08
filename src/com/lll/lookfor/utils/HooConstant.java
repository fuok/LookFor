/**
 * 文件名称 : HooContant.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月6日, 下午4:17:32
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

package com.lll.lookfor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.os.Environment;

/**
 * @author LIJUNJIE 常量类，错误码
 */
public class HooConstant {
    
    protected static boolean inited = false;
    /**
     * 成功
     */
    public static final int HOO_OTT_ERRORCODE_SUCCESS = 0000;
    
    // TODO 错误码范围0001 - 0999
    /**
     * 连接http错误,拿不到后台返回结果
     */
    public static final int HOO_OTT_ERRORCODE_HTTP = 0001;
    
    /**
     * 传入参数错误
     */
    public static final int HOO_OTT_ERRORCODE_PARAM = 0002;
    
    /**
     * JSON转换类错误
     */
    public static final int HOO_OTT_ERRORCODE_JSON_PARSE = 0003;
    
    /**
     * JSON格式错误
     */
    public static final int HOO_OTT_ERRORCODE_JSON_FORMAT = 0003;
    
    /**
     * 未知错误
     */
    public static final int HOO_OTT_ERRORCODE_KNOWNERROR = 9999;
    
    /**
     * FTP服务器hostname
     */
    public static final String HOST_URL = "192.168.1.198";
    
    /**
     * FTP服务器端口
     */
    public static final int HOST_PORT = 21;
    
    /**
     * FTP登录账号
     */
    public static final String HOST_USERNAME = "cmsftp";
    
    /**
     * FTP登录密码
     */
    public static final String HOST_PASSWORD = "cmsftp";
    
    //-----------------AAA-----------------------------------------------------------------     
    /**
     * 登录接口
     */
    public static final int URL_AAA_LOGIN = 10001;
    /**
     * 盒子登录接口
     */
    public static final int URL_OTT_AAA_LOGIN = 1001;
    /**
     * 手机登录接口
     */
    public static final int URL_MOBILE_AAA_LOGIN = 1101;
    
    /**获取首页WebView地址*/
    public static final int URL_HOME_PAGE = 10003;
    
    //TODO----------------comment---------------------------------------------------------------
    /**
     * 盒子添加评论
     */
    public static final int URL_COMMENT_ADD = 20001;
    /**
     * 盒子添加评论
     */
    public static final int URL_OTT_COMMENT_ADD = 20001;
    /**
     * 手机添加评论
     */
    public static final int URL_MOBILE_COMMENT_ADD = 21001;
    /**
     * 删除评论
     */
    public static final int URL_COMMENT_DELETE = 20002;
    /**
     * 盒子删除评论
     */
    public static final int URL_OTT_COMMENT_DELETE = 20002;
    /**
     * 手机删除评论
     */
    public static final int URL_MOBILE_COMMENT_DELETE = 21002;
    /**
     * 获取评论列表
     */
    public static final int URL_COMMENT_GET_LIST = 20003;
    /**
     * 盒子获取评论列表
     */
    public static final int URL_OTT_COMMENT_GET_LIST = 20003;
    /**
     * 手机获取评论列表
     */
    public static final int URL_MOBILE_COMMENT_GET_LIST = 21003;
    //TODO----------------EPG---------------------------------------------------------------
    /**
     * 我的节目单 /ott/userProgramList.do
     */
    public static final int URL_EPG_GET_MY_LIST = 30001;
    
    /**
     * 我的节目单手机版本 /mobile/userProgramList.do
     */
    public static final int URL_MOBILE_EPG_GET_MY_LIST = 31001;
    
    /**
     * 获取节目标签 /ott/programTypeTag.do
     */
    public static final int URL_EPG_GET_PROG_TAG = 30002;

    /**
     * 获取节目标签/mobile/programTypeTag.do
     */
    public static final int URL_MOBILE_EPG_GET_PROG_TAG =31002;
    
    /**
     * 获取热播节目 /ott/hotProgramList.do
     */
    public static final int URL_EPG_GET_HOT_PROG_LIST = 30003;
    /**
     * 获取热播节目/mobile/hotProgramList.do
     */
    public static final int URL_MOBILE_EPG_GET_HOT_PROG_LIST = 31003;
    
    /**
     * 获取EPG频道列表 /ott/channelList.do
     */
    public static final int URL_EPG_GET_CHANNEL_LIST = 30004;
    /**
     * 获取EPG频道列表手机版本 /mobile/channelList.do
     */
    public static final int URL_MOBILE_EPG_GET_CHANNEL_LIST = 31004;
    /**
     * 获取频道节目列表 /ott/channelProgramList.do
     */
    public static final int URL_EPG_GET_PROGRAM_LIST = 30005;
    /**
     * 获取频道节目列表手机版本 /mobile/channelProgramList.do
     */
    public static final int URL_MOBILE_EPG_GET_PROGRAM_LIST = 31005;
    /**
     * 获取检索标签 /ott/getSearchColumn.do
     */
    public static final int URL_EPG_SEARCH_PROGRAM = 30006;
    /**
     * 手机获取检索标签/mobile/getSearchColumn.do
     */
    public static final int URL_MOBILE_EPG_SEARCH_PROGRAM = 31006;
    /**
     * 获取检索结果 /ott/categorySearch.do
     */
    public static final int URL_EPG_RETRIEVAL_PROGRAM = 30007;
    /**
     * 手机获取检索结果 /mobile/categorySearch.do
     */
    public static final int URL_MOBILE_EPG_RETRIEVAL_PROGRAM = 31007;
    
    /**
     * 获取一级,二级栏目接口 /ott/getColumn.do
     */
    public static final int URL_EPG_GET_COLUMN = 30009;
    /**
     * 获取一级,二级栏目接口 /mobile/getColumn.do
     */
    public static final int URL_MOBILE_EPG_GET_COLUMN = 31009;
    
    /**
     * 获取栏目下的影片 /ott/getColumnMedia.do
     */
    public static final int URL_EPG_GET_COLUMN_MEDIA = 30011;
    /**
     * 获取栏目下的影片 /mobile/getColumnMedia.do
     */
    public static final int URL_MOBILE_EPG_GET_COLUMN_MEDIA = 31011;
    
    /**
     * 获取栏目下推荐影片 /ott/getColumnRecommend.do
     */
    public static final int URL_EPG_GET_COLUMN_RECOMMEND = 30012;
    /**
     * 获取栏目下推荐影片 /mobile/getColumnRecommend.do
     */
    public static final int URL_MOBILE_EPG_GET_COLUMN_RECOMMEND = 31012;
    
    /**
     * 获取猜你喜欢 /ott/getGuessMedia.do
     */
    public static final int URL_EPG_GET_USER_FAVORIATE = 30013;
    /**
     * 获取猜你喜欢 /mobile/getGuessMedia.do
     */
    public static final int URL_MOBILE_EPG_GET_USER_FAVORIATE = 31013;
    
    /**
     * 获取推荐影片 /ott/getUserRecommendMediaList.do
     */
    public static final int URL_EPG_RECOMMEND_LIST = 30014;
    /**
     * 获取推荐影片 /mobile/getUserRecommendMediaList.do
     */
    public static final int URL_MOBILE_EPG_RECOMMEND_LIST = 31014;
    
    /**
     * 获取儿童二级栏目
     */
    public static final int URL_EPG_GET_COLUMNBYCHILD = 30015;

    //TODO----------------MSG---------------------------------------------------------------
    /**
     * 查询站内信接口 /ott/getMsgList.do
     */
    public static final int URL_MSG_GET_MSG_LIST = 40001;
    /**
     * 查询站内信接口/mobile/getMsgList.do     
     */
    public static final int URL_MOBILE_GET_MSG_LIST = 41001;
    
    /**
     * 删除站内信 /ott/delMsg.do
     */
    @Deprecated
    public static final int URL_MSG_DELETE = 40002;
    
    /**
     * 发送站内信 /ott/sendMsg.do
     */
    public static final int URL_MSG_SEND = 40004;
    /**
     * 发送站内信 /mobile/sendMsg.do
     */
    public static final int URL_MOBILE_MSG_SEND = 41004;
    
    /**
     * 设置家庭圈用户账号主/副关系 /ott/modifyPrimaryMobile.do
     */
    public static final int URL_USER_UPDATE = 40005;
    
    /**获取常用回复语*/
    public static final int URL_COMMON_WORD_LIST = 40006;
    
    //TODO----------------MY---------------------------------------------------------------
    /**
     * 家庭圈增加关注 /ott/addFollower.do
     */
    public static final int URL_MY_ADD_FOLLOWER = 50001;
    /**
     * 手机增加关注 /mobile/addFollower.do
     */
    public static final int URL_MOBILE_MY_ADD_FOLLOWER = 51001;
    
    /**
     * 家庭圈取消关注 /ott/delFollower.do
     */
    public static final int URL_MY_DEL_FOLLOWER = 50002;
    /**
     * 手机取消关注 /mobile/delFollower.do
     */
    public static final int URL_MOBILE_MY_DEL_FOLLOWER = 51002;
    
    /**
     * 家庭圈更新关注时间 /ott/updateFollowerTime.do
     */
    public static final int URL_MY_UPDATE_FOLLOWER_TIME = 50003;
    /**
     * 手机更新关注时间 /mobile/updateFollowerTime.do
     */
    public static final int URL_MOBILE_MY_UPDATE_FOLLOWER_TIME = 51003;
    
    /**
     * 家庭圈获取关注列表/ott/getFollowerList.do
     */
    public static final int URL_MY_GET_FOLLOWER_LIST = 50004;
    /**
     * 手机获取关注列表/ott/getFollowerList.do
     */
    public static final int URL_MOBILE_MY_GET_FOLLOWER_LIST = 51004;
    
    /**
     * 家庭圈绑定手机接口 /ott/bindMobile.do
     */
    public static final int URL_MY_BIND_MOBILE = 50005;
    /**
     * 家庭圈绑定手机接口 /ott/bindMobile.do
     */
    public static final int URL_MOBILE_MY_BIND_MOBILE = 51005;
    
    /**
     * 家庭圈确认/拒绝绑定用户接口 /ott/confirmBindMobile.do
     */
    public static final int URL_MY_CONFIRM_BIND = 50006;
    /**
     * 手机确认/拒绝绑定用户接口 /ott/confirmBindMobile.do
     */
    public static final int URL_MOBILE_MY_CONFIRM_BIND = 51006;
    
    /**
     * 家庭圈解绑用户接口 /ott/cancelBindMobile.do
     */
    public static final int URL_MY_UNBIND_MOBILE = 50007;
    /**
     * 手机解绑用户接口 /ott/cancelBindMobile.do
     */
    public static final int URL_MOBILE_MY_UNBIND_MOBILE = 51007;
    
    /**
     * 家庭圈修改手机昵称 /ott/modifyBindMobileName.do
     */
    public static final int URL_MY_MODIFY_MOBILE_NAME = 50008;
    /**
     * 手机修改手机昵称 /mobile/modifyBindMobileName.do
     */
    public static final int URL_MOBILE_MY_MODIFY_MOBILE_NAME = 51008;
    
    /**
     * 家庭圈获取绑定用户列表 /ott/getBindList.do
     */
    public static final int URL_MY_GET_BIND_LIST = 50009;
    /**
     * 手机获取绑定用户列表 /ott/getBindList.do
     */
    public static final int URL_MOBILE_MY_GET_BIND_LIST = 51009;
    //-TODO--------日志上报-----------------------------------------------------
    /**
     * 家庭圈开户/登录日志上报
     */
    public static final int URL_TVCHAT_REPORT_LOGIN = 70001;
    /**
     * 家庭圈应用退出日志
     */
    public static final int URL_TVCHAT_REPORT_EXIT = 70002;
    /**
     * 家庭圈异常日志 
     */
    public static final int URL_TVCHAT_REPORT_ERROR = 70003;
    /**
     * 升级文件下载日志
     */
    public static final int URL_TVCHAT_REPORT_UPGRADE = 70004;
    /**
     * 应用卸载日志
     */
    public static final int URL_TVCHAT_REPORT_UNINSTALL = 70005;
    /**
     * 
     */
  //-TODO--------爱上日志上报-----------------------------------------------------
    /**
     * 开户/登录日志上报
     */
    public static final int URL_AS_REPORT_LOGIN = 70006;
    /**
     * 应用退出日志
     */
    public static final int URL_AS_REPORT_EXIT = 70007;
    /**
     * 异常日志 
     */
    public static final int URL_AS_REPORT_ERROR = 70008;
    /**
     * 播放日志
     */
    public static final int URL_AS_REPORT_PLAY = 70009;
    
    /**
     * 手机圈开户/登录日志上报
     */
    public static final int URL_TVPLAYER_REPORT_LOGIN = 70011;
    /**
     * 手机圈应用使用日志
     */
    public static final int URL_TVPLAYER_REPORT_ACTION = 70012;
    /**
     * 手机圈异常日志 
     */
    public static final int URL_TVPLAYER_REPORT_ERROR = 70013;
    /**
     * 手机文件下载日志
     */
    public static final int URL_TVPLAYER_REPORT_UPGRADE = 70014;
    /**
     * 应用卸载日志
     */
    public static final int URL_TVPLAYER_REPORT_UNINSTALL = 70015;
    /**
     * 点播播放日志
     */
    public static final int URL_TVPLAYER_REPORT_VOD_PLAYING = 70016;
    /**
     * 点播浏览行为日志
     */
    public static final int URL_TVPLAYER_REPORT_VOD_DETAIL = 70017;
    /**
     * 位置上报日志
     */
    public static final int URL_TVPLAYER_REPORT_POSITION = 70018;
    
    //-TODO--------爱上日志上报-----------------------------------------------------
    /**
     * 升级
     */
    public static final int URL_UPGRADE = 80001;
    //url类型 0:现网,1:开发环境,2:测试环境,3:prd环境,4:pat环境,99:开发桩环境
    protected static void init() {
        int urlType = 0;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(getSDCardPath() + "/HooTV");
            byte[] buffer = new byte[1];
            fileIn.read(buffer);
            urlType = buffer[0];
            fileIn.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            urlType = 0;
            
        }
        catch (IOException e) {
            e.printStackTrace();
            urlType = 0;
        }
        urlType=1;// ☆ 环境控制开关，请保持常闭 ☆
        switch (urlType) {
            case 1:
                //开发环境
                HOO_OTT_URL_HOST_AAA = "http://dev.aaa.hooray.cn";
                HOO_OTT_URL_HOST_MSG = "http://dev.msg.hooray.cn";
                HOO_OTT_URL_HOST_MY = "http://dev.my.hooray.cn";
                HOO_OTT_URL_HOST_EPG = "http://dev.epg.hooray.cn";
                HOO_OTT_URL_HOST_LOG = "http://dev.logcloud.hooray.cn";
                HOO_OTT_URL_AS_HOST_LOG = "http://dev.as-logcloud.hooray.cn";
                HOO_OTT_URL_API_HOST_LOG = "http://dev.api.hooray.cn";
                HOO_OTT_URL_HOST_UPGRADE = "http://dev.upgrade.hooray.cn";
                break;
            case 2:
                //测试环境
                HOO_OTT_URL_HOST_AAA = "http://beta.aaa.hooray.cn";
                HOO_OTT_URL_HOST_MSG = "http://beta.msg.hooray.cn";
                HOO_OTT_URL_HOST_MY = "http://beta.my.hooray.cn";
                HOO_OTT_URL_HOST_EPG = "http://beta.epg.hooray.cn";
                HOO_OTT_URL_HOST_LOG = "http://beta.as-logcloud.hooray.cn";
                HOO_OTT_URL_AS_HOST_LOG = "http://beta.as-logcloud.hooray.cn";
                HOO_OTT_URL_API_HOST_LOG = "http://beta.api.hooray.cn";
                HOO_OTT_URL_HOST_UPGRADE = "http://beta.upgrade.hooray.cn";
                break;
            case 3:
                //爱上的环境
                HOO_OTT_URL_HOST_AAA = "http://prd.aaa.hooray.cn";
                HOO_OTT_URL_HOST_MSG = "http://prd.msg.hooray.cn";
                HOO_OTT_URL_HOST_MY = "http://prd.my.hooray.cn";
                HOO_OTT_URL_HOST_EPG = "http://prd.epg.hooray.cn";
                HOO_OTT_URL_AS_HOST_LOG = "http://prd.as-logcloud.hooray.cn";
                HOO_OTT_URL_API_HOST_LOG = "http://prd.api.hooray.cn";
                HOO_OTT_URL_HOST_UPGRADE = "http://prd.upgrade.hooray.cn";
                break;
            case 4:
                //演示环境
                HOO_OTT_URL_HOST_AAA = "http://pat.aaa.hooray.cn";
                HOO_OTT_URL_HOST_MSG = "http://pat.msg.hooray.cn";
                HOO_OTT_URL_HOST_MY = "http://pat.my.hooray.cn";
                HOO_OTT_URL_HOST_EPG = "http://pat.epg.hooray.cn";
                HOO_OTT_URL_HOST_LOG = "http://pat.logcloud.hooray.cn";
                HOO_OTT_URL_AS_HOST_LOG = "http://pat.as-logcloud.hooray.cn";
                HOO_OTT_URL_API_HOST_LOG = "http://pat.api.hooray.cn";
                HOO_OTT_URL_HOST_UPGRADE = "http://pat.upgrade.hooray.cn";
                break;
            case 99:
                //开发桩环境
                HOO_OTT_URL_HOST_AAA = "http://dev.ott.hooray.cn";
                HOO_OTT_URL_HOST_MSG = "http://dev.ott.hooray.cn";
                HOO_OTT_URL_HOST_MY  = "http://dev.ott.hooray.cn";
                HOO_OTT_URL_HOST_EPG = "http://dev.ott.hooray.cn";
                break;
            default:
                HOO_OTT_URL_HOST_AAA = "http://aaa.hooray.cn"; //http://218.17.157.92:9081
                HOO_OTT_URL_HOST_MSG = "http://msg.hooray.cn"; //218.17.157.92:9084
                HOO_OTT_URL_HOST_MY = "http://my.hooray.cn"; //http://218.17.157.92:8084
                HOO_OTT_URL_HOST_EPG = "http://epg.hooray.cn"; //http://218.17.157.92:8081
                HOO_OTT_URL_HOST_LOG = "http://logcloud.hooray.cn";
                HOO_OTT_URL_HOST_UPGRADE = "http://upgrade.hooray.cn";
                break;
        }
        inited = true;
    }
    
    // TODO ---------------------------接口部分----------------------------------------------------------
    
    /**
     * 默认现网URL
     */
    public static String HOO_OTT_URL_HOST_AAA = "http://aaa.hooray.cn";
    
    public static String HOO_OTT_URL_HOST_MSG = "http://msg.hooray.cn";
    
    public static String HOO_OTT_URL_HOST_MY = "http://my.hooray.cn";
    
    public static String HOO_OTT_URL_HOST_EPG = "http://epg.hooray.cn";
    
    public static String HOO_OTT_URL_HOST_LOG = "http://logcloud.hooray.cn";
    
    public static String HOO_OTT_URL_AS_HOST_LOG = "http://as-logcloud.hooray.cn";
    
    public static String HOO_OTT_URL_API_HOST_LOG = "http://api.hooray.cn/";
    
    public static String HOO_OTT_URL_HOST_UPGRADE = "http://upgrade.hooray.cn";

    public static String getURL(String orgURL){
        String httpPrefix = "http://";
        
        String url = orgURL.replace("http://", httpPrefix);
        return "";
    }
    /**
     * 获取URL地址
     * @param URL编号 HOO_OTT_URL_XXX
     * @return URL地址
     */
    public static String getURL(int type) {
        String url = "";
        if(!inited){
            init();
        }
        switch (type) {
            //aaa 家庭圈登录
            case URL_AAA_LOGIN:
                return HOO_OTT_URL_HOST_AAA + "/ott/login.do";
            //aaa 手机登录
            case URL_MOBILE_AAA_LOGIN:
                return HOO_OTT_URL_HOST_AAA + "/mobile/login.do";
            //aaa获取首页WebView地址
            case URL_HOME_PAGE:
                return HOO_OTT_URL_HOST_AAA+"/ott/viewTVChat.do";
            //my 盒子获取绑定列表
            case URL_EPG_GET_MY_LIST:
                return HOO_OTT_URL_HOST_EPG + "/ott/userProgramList.do";
            //my 手机获取绑定列表
            case URL_MOBILE_EPG_GET_MY_LIST:
                return HOO_OTT_URL_HOST_EPG + "/mobile/userProgramList.do";
            //EPG 家庭圈获取节目分类标签
            case URL_EPG_GET_PROG_TAG:
                return HOO_OTT_URL_HOST_EPG + "/ott/programTypeTag.do";
            //EPG 手机获取节目分类标签
            case URL_MOBILE_EPG_GET_PROG_TAG:
                return HOO_OTT_URL_HOST_EPG + "/mobile/programTypeTag.do";
            //EPG 家庭圈获取热点节目列表
            case URL_EPG_GET_HOT_PROG_LIST:
                return HOO_OTT_URL_HOST_EPG + "/ott/hotProgramList.do";
            //EPG 手机获取热点节目列表                
            case URL_MOBILE_EPG_GET_HOT_PROG_LIST:
                return HOO_OTT_URL_HOST_EPG + "/mobile/hotProgramList.do";
            //EPG 家庭圈获取频道列表
            case URL_EPG_GET_CHANNEL_LIST:
                return HOO_OTT_URL_HOST_EPG + "/ott/channelList.do";
            //EPG 手机获取频道列表
            case URL_MOBILE_EPG_GET_CHANNEL_LIST:
                return HOO_OTT_URL_HOST_EPG + "/mobile/channelList.do";
            //EPG 家庭圈获取频道节目列表
            case URL_EPG_GET_PROGRAM_LIST:
                return HOO_OTT_URL_HOST_EPG + "/ott/channelProgramList.do";
            //EPG 家庭圈获取频道节目列表
            case URL_MOBILE_EPG_GET_PROGRAM_LIST:
                return HOO_OTT_URL_HOST_EPG + "/mobile/channelProgramList.do";
            //EPG 家庭圈获取检索标签
            case URL_EPG_SEARCH_PROGRAM:
                return HOO_OTT_URL_HOST_EPG + "/ott/getSearchColumn.do";
            //EPG 手机获取检索标签
            case URL_MOBILE_EPG_SEARCH_PROGRAM:
                return HOO_OTT_URL_HOST_EPG + "/mobile/getSearchColumn.do";
            //EPG 家庭圈获取检索结果
            case URL_EPG_RETRIEVAL_PROGRAM:
                return HOO_OTT_URL_HOST_EPG + "/ott/categorySearch.do";
            //EPG 手机获取检索结果
            case URL_MOBILE_EPG_RETRIEVAL_PROGRAM:
                return HOO_OTT_URL_HOST_EPG + "/mobile/categorySearch.do";
            //EPG 家庭圈获取一级/二级分类接口
            case URL_EPG_GET_COLUMN:
                return HOO_OTT_URL_HOST_EPG + "/ott/getColumn.do";
            //EPG 手机获取一级/二级分类接口
            case URL_MOBILE_EPG_GET_COLUMN:                
                return HOO_OTT_URL_HOST_EPG + "/mobile/getColumn.do";
              //EPG 家庭圈获取分类节目接口
            case URL_EPG_GET_COLUMN_MEDIA:
                return HOO_OTT_URL_HOST_EPG + "/ott/getColumnMedia.do";
              //EPG 手机获取分类节目接口
            case URL_MOBILE_EPG_GET_COLUMN_MEDIA:
                return HOO_OTT_URL_HOST_EPG + "/mobile/getColumnMedia.do";
            //EPG 家庭圈获取分类推荐接口
            case URL_EPG_GET_COLUMN_RECOMMEND:
                return HOO_OTT_URL_HOST_EPG + "/ott/getColumnRecommend.do";
              //EPG 手机获取分类推荐接口
            case URL_MOBILE_EPG_GET_COLUMN_RECOMMEND:
                return HOO_OTT_URL_HOST_EPG + "/mobile/getColumnRecommend.do";
            //EPG 家庭圈获取猜你喜欢接口
            case URL_EPG_GET_USER_FAVORIATE:
                return HOO_OTT_URL_HOST_EPG + "/ott/getGuessMedia.do";
            //EPG 手机获取猜你喜欢接口
            case URL_MOBILE_EPG_GET_USER_FAVORIATE:
                return HOO_OTT_URL_HOST_EPG + "/mobile/getGuessMedia.do";
            //EPG 家庭圈获取推荐节目接口
            case URL_EPG_RECOMMEND_LIST:
                return HOO_OTT_URL_HOST_EPG + "/ott/getUserRecommendMediaList.do";
            //EPG 手机获取推荐节目接口
            case URL_MOBILE_EPG_RECOMMEND_LIST:
                return HOO_OTT_URL_HOST_EPG + "/mobile/getUserRecommendMediaList.do";
            //EPG 获取少儿分类
            case URL_EPG_GET_COLUMNBYCHILD:
                return HOO_OTT_URL_HOST_EPG+"/ott/getColumnByChild.do";
            //MSG 家庭圈获取消息列表
            case URL_MSG_GET_MSG_LIST:
                return HOO_OTT_URL_HOST_MSG + "/ott/getMsgList.do";
            //MSG 手机获取消息列表
            case URL_MOBILE_GET_MSG_LIST:
                return HOO_OTT_URL_HOST_MSG + "/mobile/getMsgList.do";
            case URL_MSG_DELETE:
                return HOO_OTT_URL_HOST_MSG + "/ott/delMsg.do";
            //MSG 家庭圈发送消息
            case URL_MSG_SEND:
                return HOO_OTT_URL_HOST_MSG + "/ott/sendMsg.do";
            //MSG 手机发送消息
            case URL_MOBILE_MSG_SEND:
                return HOO_OTT_URL_HOST_MSG + "/mobile/sendMsg.do";
            //MSG 家庭圈设置主绑接口
            case URL_USER_UPDATE:
                return HOO_OTT_URL_HOST_MY + "/ott/modifyPrimaryMobile.do";
            //MSG 家庭圈获取
            case URL_COMMON_WORD_LIST:
            	return HOO_OTT_URL_HOST_MSG+"/ott/msgDelivered.do";
            //MY 家庭圈添加关注
            case URL_MY_ADD_FOLLOWER:
                return HOO_OTT_URL_HOST_MY + "/ott/addFollower.do";
            //MY 手机添加关注
            case URL_MOBILE_MY_ADD_FOLLOWER:
                return HOO_OTT_URL_HOST_MY + "/mobile/addFollower.do";
            //MY 家庭圈取消关注
            case URL_MY_DEL_FOLLOWER:
                return HOO_OTT_URL_HOST_MY + "/ott/delFollower.do";
            //MY 手机取消关注
            case URL_MOBILE_MY_DEL_FOLLOWER:
                return HOO_OTT_URL_HOST_MY + "/mobile/delFollower.do";
            //MY 家庭圈更新关注时间
            case URL_MY_UPDATE_FOLLOWER_TIME:
                return HOO_OTT_URL_HOST_MY + "/ott/updateFollowerTime.do";
            //MY 手机更新关注时间
            case URL_MOBILE_MY_UPDATE_FOLLOWER_TIME:
                return HOO_OTT_URL_HOST_MY + "/mobile/updateFollowerTime.do";
            //MY 家庭圈获取关注列表 
            case URL_MY_GET_FOLLOWER_LIST:
                return HOO_OTT_URL_HOST_MY + "/ott/getFollowerList.do";
            //MY 手机获取关注列表 
            case URL_MOBILE_MY_GET_FOLLOWER_LIST:
                return HOO_OTT_URL_HOST_MY + "/mobile/getFollowerList.do";
            //    
            case URL_MY_BIND_MOBILE:
                return HOO_OTT_URL_HOST_MY + "/ott/bindMobile.do";
            case URL_MY_CONFIRM_BIND:
                return HOO_OTT_URL_HOST_MY + "/ott/confirmBindMobile.do";
            case URL_MY_UNBIND_MOBILE:
                return HOO_OTT_URL_HOST_MY + "/ott/cancelBindMobile.do";
            case URL_MY_MODIFY_MOBILE_NAME:
                return HOO_OTT_URL_HOST_MY + "/ott/modifyBindMobileName.do";
            //MY 家庭圈获取绑定列表
            case URL_MY_GET_BIND_LIST:
                return HOO_OTT_URL_HOST_MY + "/ott/getBindList.do";
            //MY 手机获取绑定列表
            case URL_MOBILE_MY_GET_BIND_LIST:
                return HOO_OTT_URL_HOST_MY + "/ott/getBindList.do";
            case URL_TVCHAT_REPORT_LOGIN:
                return HOO_OTT_URL_HOST_LOG + "/S_OPEN";
            case URL_TVCHAT_REPORT_EXIT:
                return HOO_OTT_URL_HOST_LOG + "/S_EXIT";
            case URL_TVCHAT_REPORT_ERROR:
                return HOO_OTT_URL_HOST_LOG + "/S_ERR";
            case URL_TVCHAT_REPORT_UPGRADE:
                return HOO_OTT_URL_HOST_LOG + "/S_UPGRADE";
            case URL_TVCHAT_REPORT_UNINSTALL:
                return HOO_OTT_URL_HOST_LOG + "/S_UNINSTALL";
            case URL_TVPLAYER_REPORT_LOGIN:
                return HOO_OTT_URL_HOST_LOG + "/M_OPEN";
            case URL_TVPLAYER_REPORT_ACTION:
            	return HOO_OTT_URL_HOST_LOG + "/M_EXIT";
            case URL_TVPLAYER_REPORT_ERROR:
                return HOO_OTT_URL_HOST_LOG + "/M_ERR";
            case URL_TVPLAYER_REPORT_UPGRADE:
                return HOO_OTT_URL_HOST_LOG + "/M_UPGRADE";
            case URL_TVPLAYER_REPORT_UNINSTALL:
                return HOO_OTT_URL_HOST_LOG + "/M_UNINSTALL";
            case URL_TVPLAYER_REPORT_VOD_PLAYING:
                return HOO_OTT_URL_HOST_LOG + "/M_PLAY";
            case URL_TVPLAYER_REPORT_VOD_DETAIL:
                return HOO_OTT_URL_HOST_LOG + "/M_BROWSER";
            case URL_TVPLAYER_REPORT_POSITION:
                return HOO_OTT_URL_HOST_LOG + "/M_POSITION";
            case URL_AS_REPORT_LOGIN:
                return HOO_OTT_URL_AS_HOST_LOG + "/ASL_OPEN";
            case URL_AS_REPORT_EXIT:
                return HOO_OTT_URL_AS_HOST_LOG + "/ASL_EXIT";
            case URL_AS_REPORT_ERROR:
                return HOO_OTT_URL_AS_HOST_LOG + "/ASL_ERR";
            case URL_AS_REPORT_PLAY:
                return HOO_OTT_URL_AS_HOST_LOG + "/ASL_PLAY";
            case URL_UPGRADE:
                return HOO_OTT_URL_HOST_UPGRADE+"/upgradeService/upgrade.do";
        }
        return url;
    }
    
    /**
     * 根目录
     */
    public final static String ROOT = getSDCardPath() + File.separator
            + "hooray" + File.separator;
    
    /**
     * 得到sdcard目录
     */
    public static String getSDCardPath() {
       /*/if (checkSDCard()) {
       
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        //return Environment.getExternalStorageDirectory().getPath();
        return "/system/app";//torage/emulated/legacy";//
        //}
        //else {
          //  return null;
        //}
    }
    
    /**
     * 检测sdcard是否存在
     * 
     * @return 存在返回true，不存在返回false
     */
    public static boolean checkSDCard() {
        //sd卡是否存在
        return Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);
    }
    
    /**
     * 创建目录
     * 
     * @param dir
     *            为目录名称
     */
    public static void createDir(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
    /**
	 * 获取设备类型接口/mobile/getDeviceTypeList.do
	 */
	public static final int URL_EPG_GET_DEVICE_TYPE_LIST = 30031;

	/**
	 * 获取电视机/机顶盒品牌接口/mobile/getDeviceBrandList.do
	 */
	public static final int URL_EPG_GET_DEVICE_BRAND_LIST = 30032;

	/**
	 * 获取设备型号接口/mobile/getDeviceModelList.do
	 */
	public static final int URL_EPG_GET_DEVICE_MODE_LIST = 30033;

	/**
	 * 获取我的设备型号列表/mobile/getMyDeviceModelList.do
	 */
	public static final int URL_EPG_GET_MY_DEVICE_MODE_LIST = 30034;

	/**
	 * 将适配成功的设备添加到我的设备中/mobile/addDeviceModel.do
	 */
	public static final int URL_EPG_ADD_DEVICE_MODEL = 30035;

	/**
	 * 删除我的遥控器/mobile/delDeviceModel.do
	 */
	public static final int URL_EPG_DEL_DEVICE_MODEL = 30036;

	/**
	 * 修改设备型号名称接口/mobile/modifyDeviceModel.do
	 */
	public static final int URL_EPG_MODIFY_DEVICE_MODEL = 30037;

}
