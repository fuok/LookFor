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
public class HooPhoneConstant {

	protected static boolean inited = false;
	/**
	 * 成功
	 */
	public static final int HOO_PHONE_ERRORCODE_SUCCESS = 0000;

	// TODO 错误码范围0001 - 0999
	/**
	 * 连接http错误,拿不到后台返回结果
	 */
	public static final int HOO_PHONE_ERRORCODE_HTTP = 0001;

	/**
	 * 传入参数错误
	 */
	public static final int HOO_PHONE_ERRORCODE_PARAM = 0002;

	/**
	 * 未知错误
	 */
	public static final int HOO_PHONE_ERRORCODE_KNOWNERROR = 9999;

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

	// -----------------AAA-----------------------------------------------------------------
	/**
	 * 登录接口
	 */
	public static final int URL_AAA_LOGIN = 10001;

	/**
	 * 获取盒子业务列表接口
	 */
	public static final int URL_AAA_GET_PRODUCT_LIST = 10002;

	/**
	 * 我的订购接口 /mobile/getUserOrderList.do
	 */
	public static final int URL_AAA_USERORDER_LIST = 10003;

	/**
	 * 产品详情 /mobile/getProductDetail.do
	 */
	public static final int URL_AAA_PRODUCT_DETAIL = 10004;

	/**
	 * 产品购买支付接口 /mobile/buyProduct.do
	 */
	public static final int URL_AAA_BUY_PRODUCT = 10005;

	// TODO----------------comment---------------------------------------------------------------
	/**
	 * 添加评论 /comment/addComment.do
	 */
	public static final int URL_COMMENT_ADD = 20001;

	/**
	 * 删除评论
	 */
	public static final int URL_COMMENT_DELETE = 20002;

	/**
	 * 获取评论列表/comment/getCommentByPage.do
	 */
	public static final int URL_COMMENT_GET_LIST = 20003;

	/**
	 * 节目点赞接口/comment/addCommentLike.do
	 */
	public static final int URL_COMMENT_ADD_LIKE = 20004;

	/**
	 * 节目点赞取消接口/comment/deleteCommentLike.do
	 */
	public static final int URL_COMMENT_DELETE_LIKE = 20005;

	// TODO----------------EPG---------------------------------------------------------------
	/**
	 * 我的节目单 /mobile/userProgramList.do
	 */
	public static final int URL_EPG_GET_MY_LIST = 30001;

	/**
	 * 获取节目标签 /mobile/programTypeTag.do
	 */
	public static final int URL_EPG_GET_PROG_TAG = 30002;

	/**
	 * 获取热播节目 /mobile/hotProgramList.do
	 */
	public static final int URL_EPG_GET_HOT_PROG_LIST = 30003;

	/**
	 * 获取EPG频道列表 /mobile/channelList.do
	 */
	public static final int URL_EPG_GET_CHANNEL_LIST = 30004;

	/**
	 * 获取频道节目列表 /mobile/channelProgramList.do
	 */
	public static final int URL_EPG_GET_PROGRAM_LIST = 30005;

	/**
	 * 获取检索标签 /mobile/getSearchColumn.do
	 */
	public static final int URL_EPG_SEARCH_PROGRAM = 30006;

	/**
	 * 获取检索结果 /mobile/categorySearch.do
	 */
	public static final int URL_EPG_RETRIEVAL_PROGRAM = 30007;

	/**
	 * 获取一级,二级栏目接口 /mobile/getColumn.do
	 */
	public static final int URL_EPG_GET_COLUMN = 30009;

	/**
	 * 获取栏目下的影片 /mobile/getColumnMedia.do
	 */
	public static final int URL_EPG_GET_COLUMN_MEDIA = 30011;

	/**
	 * 获取栏目下推荐影片 /mobile/getColumnRecommend.do
	 */
	public static final int URL_EPG_GET_COLUMN_RECOMMEND = 30012;

	/**
	 * 获取猜你喜欢 /mobile/getGuessMedia.do
	 */
	public static final int URL_EPG_GET_USER_FAVORIATE = 30013;

	/**
	 * 获取推荐影片 /mobile/getUserRecommendMediaList.do
	 */
	public static final int URL_EPG_RECOMMEND_LIST = 30014;

	/**
	 * 获取儿童二级栏目
	 */
	public static final int URL_EPG_GET_COLUMNBYCHILD = 30015;

	/**
	 * 获取盒子在看接口/mobile/stbNowWatchProgram.do
	 */
	public static final int URL_EPG_WATCH_PROGRAM = 30016;

	/**
	 * 获取节目详情接口/mobile/programDetail.do
	 */
	public static final int URL_EPG_PROGRAM_DETAIL = 30017;

	/**
	 * 获取活动列表接口/mobile/activityList.do
	 */
	public static final int URL_EPG_ACTIVITY_LIST = 30018;

	/**
	 * 获取频道分类的节目信息/mobile/channelTypeProgramList.do
	 */
	public static final int URL_EPG_CHANNEL_TYPE_PROGRAMLIST = 30019;

	/**
	 * 首页推荐位接口/mobile/getRecommendList.do
	 */
	public static final int URL_EPG_GET_RECOMMENDLIST = 30020;

	/**
	 * 获取节目分类的节目信息/mobile/tagTypeProgramList.do
	 */
	public static final int URL_EPG_TAG_PROGRAMLIST = 30021;

	/**
	 * 获取猜你喜欢节目信息/mobile/getYouLikeProgramList.do
	 */
	public static final int URL_EPG_GET_GUESSYOULIKE = 30022;

	/**
	 * 获取明星相册集接口/mobile/starPhotoAlbum.do
	 */
	public static final int URL_EPG_GET_STARTPHOTO = 30023;
	/**
	 * 详情投票接口/mobile/vote.do
	 */
	public static final int URL_EPG_PTO_VOTE = 30024;

	/**
	 * 首页大家在看接口/mobile/playingProgramList.do
	 */
	public static final int URL_EPG_HOME_OUR_WATCH = 30025;

	/**
	 * 影视信息列表mobile/categoryFilter.do--vodList
	 */
	public static final int URL_EPG_GET_CATEGORY_LIST = 30027;
	/**
	 * 影视分类标签信息列表mobile/categoryDisplay.do ---categoryTagList
	 */
	public static final int URL_EPG_GET_CATEGORYDISPLAY_LIST = 30028;
	/**
	 * 影视首页分类推荐接口/mobile/vodHomeList.do
	 */
	public static final int URL_EPG_VOD_CATEGORY_RECOMMEND = 30029;
	/**
	 * 获取影视详情信息/mobile/vodDetail.do
	 */
	public static final int URL_EPG_GET_MOVIE_DETAIL = 30030;

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

	/**
	 * 获取运营商列表/mobile/getOperatorList.do
	 */
	public static final int URL_EPG_OPERATOR_LIST = 30038;
	/**
	 * 7.6.1获取游戏公告接口 (getPartakeGamesNotice)
	 */
	public static final int URL_EPG_GET_PARTAKE_GAMES_NOTICE = 30039;
	/**
	 * 7.6.2奖品信息列表展示(getPrizeList)
	 */
	public static final int URL_EPG_GET_PRIZE_LIST = 30040;
	/**
	 * 7.6.3奖品详情接口(getPrizeDetail)
	 */
	public static final int URL_EPG_GET_PRIZE_DETAIL = 30041;
	/**
	 * 7.6.4提交订单接口(auditOrder)
	 * 
	 */
	public static final int URL_EPG_AUDIT_ORDER = 30042;
	/**
	 * 7.6.5我的奖品列表接口(getMyPrizeList)
	 */
	public static final int URL_EPG_GET_MY_PRIZE_LIST = 30043;
	/**
	 * 获取运营商信息接口 /mobile/getOperatorInfo.do
	 */
	public static final int URL_EPG_GET_OPERATOR_INFO = 30044;

	/**
	 * 1.4.6 EPG需要用到的加版本号的接口
	 */

	public static final int URL_EPG_TAG_PROGRAMLIST_146 = 30046;
	public static final int URL_EPG_CHANNEL_TYPE_PROGRAMLIST_146 = 30047;
	public static final int URL_EPG_GET_PROGRAM_LIST_146 = 30048;
	public static final int URL_EPG_PROGRAM_DETAIL_146 = 30049;

	// TODO----------------MSG---------------------------------------------------------------
	/**
	 * 查询站内信接口 /mobile/getMsgListByPage.do
	 */
	public static final int URL_MSG_GET_MSG_LIST = 40001;

	/**
	 * 删除站内信 /mobile/delMsg.do
	 */
	public static final int URL_MSG_DELETE = 40002;

	/**
	 * 设置站内信为已读状态 /mobile/setMsgStatus.do
	 */
	public static final int URL_MSG_SET_READ = 40003;

	/**
	 * 发送站内信 /mobile/sendMsg.do
	 */
	public static final int URL_MSG_SEND = 40004;

	/**
	 * 设置家庭圈用户账号主/副关系 /mobile/modifyPrimaryMobile.do
	 */
	public static final int URL_USER_UPDATE = 40005;

	/**
	 * 上传图片/mobile/upload.do
	 */
	public static final int URL_UPLOAD = 40006;

	/**
	 * 发送站内信 /mobile/sendMsg146.do 不同版本由于兼容性，所以加上不同的尾号
	 */
	public static final int URL_MSG_SEND146 = 40007;

	// TODO----------------MY---------------------------------------------------------------
	/**
	 * 增加关注 /mobile/addFollower.do
	 */
	public static final int URL_MY_ADD_FOLLOWER = 50001;

	/**
	 * 取消关注 /mobile/delFollower.do
	 */
	public static final int URL_MY_DEL_FOLLOWER = 50002;

	/**
	 * 更新关注时间 /mobile/updateFollowerTime.do
	 */
	public static final int URL_MY_UPDATE_FOLLOWER_TIME = 50003;

	/**
	 * 获取关注列表/mobile/getFollowerList.do
	 */
	public static final int URL_MY_GET_FOLLOWER_LIST = 50004;

	/**
	 * 绑定手机接口 /mobile/bindMobile.do
	 */
	public static final int URL_MY_BIND_MOBILE = 50005;

	/**
	 * 确认/拒绝绑定用户接口 /mobile/confirmBindMobile.do
	 */
	public static final int URL_MY_CONFIRM_BIND = 50006;

	/**
	 * 解绑用户接口 /mobile/cancelBindMobile.do
	 */
	public static final int URL_MY_UNBIND_MOBILE = 50007;

	/**
	 * 修改手机昵称 /mobile/modifyBindMobileName.do
	 */
	public static final int URL_MY_MODIFY_MOBILE_NAME = 50008;

	/**
	 * 获取绑定用户列表 /mobile/getBindList.do
	 */
	public static final int URL_MY_GET_BIND_LIST = 50009;

	/**
	 * 绑定盒子接口 /mobile/bindStb.do
	 */
	public static final int URL_MY_BIND_STB = 50010;

	/**
	 * 取消绑定盒子接口 /mobile/cancelBindSTB.do
	 */
	public static final int URL_MY_CANCEL_STB = 50011;

	/**
	 * 确认绑定/拒绝绑定盒子接口/mobile/confirmBindSTB.do
	 */
	public static final int URL_MY_CONFIRM_STB = 50012;

	/**
	 * 用户登陆接口/mobile/userLogin.do
	 */
	public static final int URL_MY_USER_LOGIN = 50013;

	/**
	 * 向手机发送校验码短信接口/mobile/sendCheckCodeSMS.do
	 */
	public static final int URL_MY_SEND_CHECKCODE = 50014;

	/**
	 * 找回密码接口/mobile/findUserPassword.do
	 */
	public static final int URL_MY_FIND_PW = 50015;

	/**
	 * 绑定盒子时验证手机校验码接口/mobile/bindVerifyCode.do
	 */
	public static final int URL_MY_BIND_CODE = 50016;

	/**
	 * 修改密码接口/mobile/modifyUserPassword.do
	 */
	public static final int URL_MY_MODIFY_USER_PWD = 50017;

	/**
	 * 修改用户信息接口/mobile/modifyUserInfo.do
	 */
	public static final int URL_MY_MODIFY_USER_INFO = 50018;

	/**
	 * 获取用户排行榜接口/mobile/getUserTopList.do
	 */
	public static final int URL_MY_GET_USERTOP_LIST = 50019;

	/**
	 * 用户注册信息接口/mobile/registerUser.do
	 */
	public static final int URL_MY_REGISTER_USER = 50020;

	/**
	 * 获取用户信息接口/mobile/getUserInfo.do
	 */
	public static final int URL_MY_GET_USER_INFO = 50021;

	/**
	 * 设置用户密码接口/mobile/setUserPassword.do
	 */
	public static final int URL_MY_SET_USER_PWD = 50022;

	/**
	 * 修改用户头像接口/mobile/modifyUserPortraitPic.do
	 */
	public static final int URL_MY_MODIFY_USER_PIC = 50023;

	/**
	 * 修改绑定盒子昵称接口/mobile/modifyBindStbName.do
	 */
	public static final int URL_MY_MODIFY_BINGSTB_NAME = 50024;

	/**
	 * 完善用户资料接口/mobile/setUserInfo.do
	 */
	public static final int URL_MY_SET_USERINFO = 50025;

	/**
	 * 获取区域列表接口 mobile/getAreaList.do
	 */
	public static final int URL_MY_GET_AREA_LIST = 50026;

	/**
	 * 获取我的运营商列表接口/mobile/getMyOperatorList.do
	 */
	public static final int URL_MY_GET_MY_OPERATOR_LIST = 50028;

	/**
	 * 获取我的设备列表接口/mobile/getMyDeviceList.do
	 */
	public static final int URL_MY_GET_MY_DEVICE_LIST = 50029;

	/**
	 * 添加我的设备接口/mobile/addMyDevice.do
	 */
	public static final int URL_MY_ADD_MY_DEVICE = 50030;

	/**
	 * 获取运营商列表接口 mobile/getOperatorInfoList.do
	 */
	public static final int URL_MY_GET_OPERATOR_INFO_LIST = 50031;

	/**
	 * 用户头像URL路径
	 */
	public static final int URL_MY_PIC_PREFIX = 60001;

	/**
	 * 获取城市列表
	 */
	public static final int URL_MY_AREA = 60002;

	/**
	 * 添加运营商
	 */
	public static final int URL_MY_ADD_OPERATOR = 60003;

	/**
	 * 1.4.6 MY需要用到的加版本号的接口
	 */
	public static final int URL_MY_BIND_STB_146 = 60004;

	// -TODO--------UPGRADE-----------------------------------------------------
	/**
	 * 意见反馈/upgradeService/ideaTick.do
	 */
	public static final int URL_UPGRADE_IDEA = 70001;

	/**
	 * 升级接口/upgradeService/upgrade.do
	 */
	public static final int URL_UPGRADE_UPDATE = 70002;

	// url类型 0:现网,1:开发环境,2:测试环境
	protected static void init() {
		int urlType = 0;
		FileInputStream fileIn = null;
		try {
			fileIn = new FileInputStream(getSDCardPath() + "/HooTV");
			byte[] buffer = new byte[1];
			fileIn.read(buffer);
			urlType = buffer[0];
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			urlType = 0;

		} catch (IOException e) {
			e.printStackTrace();
			urlType = 0;
		}
		urlType = 1;// ☆ 环境控制开关，请保持常闭 ☆

		switch (urlType) {
		case 1:
			HOO_PHONE_URL_HOST_AAA = "http://dev.aaa.hooray.cn";
			HOO_PHONE_URL_HOST_MSG = "http://dev.msg.hooray.cn";
			HOO_PHONE_URL_HOST_MY = "http://dev.my.hooray.cn";
			HOO_PHONE_URL_HOST_EPG = "http://dev.epg.hooray.cn";
			HOO_PHONE_URL_HOST_COMMENT = "http://dev.comment.hooray.cn";
			HOO_PHONE_URL_HOST_UPGRADE = "http://dev.upgrade.hooray.cn";
			break;
		case 2:
			HOO_PHONE_URL_HOST_AAA = "http://beta.aaa.hooray.cn";
			HOO_PHONE_URL_HOST_MSG = "http://beta.msg.hooray.cn";
			HOO_PHONE_URL_HOST_MY = "http://beta.my.hooray.cn";
			HOO_PHONE_URL_HOST_EPG = "http://beta.epg.hooray.cn";
			HOO_PHONE_URL_HOST_COMMENT = "http://beta.comment.hooray.cn";
			HOO_PHONE_URL_HOST_UPGRADE = "http://beta.upgrade.hooray.cn";
			break;
		case 3:
			HOO_PHONE_URL_HOST_AAA = "http://prd.aaa.hooray.cn";
			HOO_PHONE_URL_HOST_MSG = "http://prd.msg.hooray.cn";
			HOO_PHONE_URL_HOST_MY = "http://prd.my.hooray.cn";
			HOO_PHONE_URL_HOST_EPG = "http://prd.epg.hooray.cn";
			HOO_PHONE_URL_HOST_COMMENT = "http://prd.comment.hooray.cn";
			HOO_PHONE_URL_HOST_UPGRADE = "http://prd.upgrade.hooray.cn";
			break;
		default:
			HOO_PHONE_URL_HOST_AAA = "http://aaa.hooray.cn"; // http://218.17.157.92:9081
			HOO_PHONE_URL_HOST_MSG = "http://msg.hooray.cn"; // 218.17.157.92:9084
			HOO_PHONE_URL_HOST_MY = "http://my.hooray.cn"; // http://218.17.157.92:8084
			HOO_PHONE_URL_HOST_EPG = "http://epg.hooray.cn"; // http://218.17.157.92:8081
			HOO_PHONE_URL_HOST_COMMENT = "http://comment.hooray.cn";
			HOO_PHONE_URL_HOST_UPGRADE = "http://upgrade.hooray.cn";
			break;
		}
		inited = true;
	}

	// TODO
	// ---------------------------接口部分----------------------------------------------------------

	/**
	 * 默认现网URL
	 */
	public static String HOO_PHONE_URL_HOST_AAA = "http://aaa.hooray.cn";

	public static String HOO_PHONE_URL_HOST_MSG = "http://msg.hooray.cn";

	public static String HOO_PHONE_URL_HOST_MY = "http://my.hooray.cn";

	public static String HOO_PHONE_URL_HOST_EPG = "http://epg.hooray.cn";

	public static String HOO_PHONE_URL_HOST_COMMENT = "http://comment.hooray.cn";

	public static String HOO_PHONE_URL_HOST_UPGRADE = "http://upgrade.hooray.cn";

	/**
	 * 获取URL地址
	 * 
	 * @param URL编号
	 *            HOO_PHONE_URL_XXX
	 * @return URL地址
	 */
	public static String getURL(int type) {
		String url = "";
		if (!inited) {
			init();
		}
		switch (type) {
		case URL_AAA_LOGIN:
			return HOO_PHONE_URL_HOST_AAA + "/mobile/login.do";
		case URL_AAA_GET_PRODUCT_LIST:
			return HOO_PHONE_URL_HOST_AAA + "/mobile/getProductList.do";
		case URL_AAA_USERORDER_LIST:
			return HOO_PHONE_URL_HOST_AAA + "/mobile/getUserOrderList.do";
		case URL_AAA_PRODUCT_DETAIL:
			return HOO_PHONE_URL_HOST_AAA + "/mobile/getProductDetail.do";
		case URL_AAA_BUY_PRODUCT:
			return HOO_PHONE_URL_HOST_AAA + "/mobile/buyProduct.do";
		case URL_COMMENT_ADD:
			return HOO_PHONE_URL_HOST_COMMENT + "/comment/addComment.do";
		case URL_COMMENT_GET_LIST:
			return HOO_PHONE_URL_HOST_COMMENT + "/comment/getCommentByPage.do";
		case URL_COMMENT_ADD_LIKE:
			return HOO_PHONE_URL_HOST_COMMENT + "/comment/addCommentLike.do";
		case URL_COMMENT_DELETE_LIKE:
			return HOO_PHONE_URL_HOST_COMMENT + "/comment/deleteCommentLike.do";
		case URL_EPG_GET_MY_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/userProgramList.do";
		case URL_EPG_GET_PROG_TAG:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/programTypeTag.do";
		case URL_EPG_GET_HOT_PROG_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/hotProgramList.do";
		case URL_EPG_GET_CHANNEL_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/channelList.do";
		case URL_EPG_GET_PROGRAM_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/channelProgramList.do";
		case URL_EPG_SEARCH_PROGRAM:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getSearchColumn.do";
		case URL_EPG_RETRIEVAL_PROGRAM:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/categorySearch.do";
		case URL_EPG_GET_COLUMN:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getColumn.do";
		case URL_EPG_GET_COLUMN_MEDIA:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getColumnMedia.do";
		case URL_EPG_GET_COLUMN_RECOMMEND:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getColumnRecommend.do";
		case URL_EPG_GET_USER_FAVORIATE:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getGuessMedia.do";
		case URL_EPG_RECOMMEND_LIST:
			return HOO_PHONE_URL_HOST_EPG
					+ "/mobile/getUserRecommendMediaList.do";
		case URL_EPG_GET_COLUMNBYCHILD:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getColumnByChild.do";
		case URL_EPG_WATCH_PROGRAM:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/stbNowWatchProgram.do";
		case URL_EPG_PROGRAM_DETAIL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/programDetail.do";
		case URL_EPG_ACTIVITY_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/activityList.do";
		case URL_EPG_CHANNEL_TYPE_PROGRAMLIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/channelTypeProgramList.do";
		case URL_EPG_GET_RECOMMENDLIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getRecommendList.do";
		case URL_EPG_TAG_PROGRAMLIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/tagTypeProgramList.do";
		case URL_EPG_GET_GUESSYOULIKE:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getYouLikeProgramList.do";
		case URL_EPG_GET_STARTPHOTO:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/starPhotoAlbum.do";
		case URL_EPG_PTO_VOTE:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/vote.do";
		case URL_EPG_HOME_OUR_WATCH:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/playingProgramList.do";
		case URL_EPG_GET_CATEGORY_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/vodList.do";//
		case URL_EPG_GET_CATEGORYDISPLAY_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/categoryTagList.do";
		case URL_EPG_VOD_CATEGORY_RECOMMEND:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/vodHomeList.do";
		case URL_EPG_GET_MOVIE_DETAIL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/vodDetail.do";
		case URL_EPG_GET_DEVICE_TYPE_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getDeviceTypeList.do";
		case URL_EPG_GET_DEVICE_BRAND_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getDeviceBrandList.do";
		case URL_EPG_GET_DEVICE_MODE_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getDeviceModelList.do";
		case URL_EPG_GET_MY_DEVICE_MODE_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getMyDeviceModelList.do";
		case URL_EPG_ADD_DEVICE_MODEL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/addDeviceModel.do";
		case URL_EPG_DEL_DEVICE_MODEL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/delDeviceModel.do";
		case URL_EPG_MODIFY_DEVICE_MODEL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/modifyDeviceModel.do";
		case URL_EPG_OPERATOR_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getOperatorList.do";
		case URL_EPG_GET_OPERATOR_INFO:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getOperatorInfo.do";
		case URL_MY_AREA:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getAreaList.do";
			// ---游戏公告
		case URL_EPG_GET_PARTAKE_GAMES_NOTICE:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getPartakeGamesNotice.do";
			// --奖品信息列表展示
		case URL_EPG_GET_PRIZE_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getPrizeList.do";
			// --奖品详情接口
		case URL_EPG_GET_PRIZE_DETAIL:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getPrizeDetail.do";
			// --提交订单接口
		case URL_EPG_AUDIT_ORDER:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/auditOrder.do";
			// 我的奖品列表接口
		case URL_EPG_GET_MY_PRIZE_LIST:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/getMyPrizeList.do";
			/**
			 * 1.4.6 EPG需要用到的加版本号的接口
			 */
		case URL_EPG_TAG_PROGRAMLIST_146:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/tagTypeProgramList146.do";
		case URL_EPG_CHANNEL_TYPE_PROGRAMLIST_146:
			return HOO_PHONE_URL_HOST_EPG
					+ "/mobile/channelTypeProgramList146.do";
		case URL_EPG_GET_PROGRAM_LIST_146:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/channelProgramList146.do";
		case URL_EPG_PROGRAM_DETAIL_146:
			return HOO_PHONE_URL_HOST_EPG + "/mobile/programDetail146.do";

		case URL_MSG_GET_MSG_LIST:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/getMsgList.do";
		case URL_MSG_DELETE:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/delMsg.do";
		case URL_MSG_SET_READ:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/setMsgStatus.do";
		case URL_MSG_SEND:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/sendMsg.do";
		case URL_MSG_SEND146:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/sendMsg146.do";
		case URL_USER_UPDATE:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyPrimaryMobile.do";
		case URL_UPLOAD:
			return HOO_PHONE_URL_HOST_MSG + "/mobile/upload.do";
		case URL_MY_ADD_FOLLOWER:
			return HOO_PHONE_URL_HOST_MY + "/mobile/addFollower.do";
		case URL_MY_DEL_FOLLOWER:
			return HOO_PHONE_URL_HOST_MY + "/mobile/delFollower.do";
		case URL_MY_UPDATE_FOLLOWER_TIME:
			return HOO_PHONE_URL_HOST_MY + "/mobile/updateFollowerTime.do";
		case URL_MY_GET_FOLLOWER_LIST:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getFollowerList.do";
		case URL_MY_BIND_MOBILE:
			return HOO_PHONE_URL_HOST_MY + "/mobile/bindMobile.do";
		case URL_MY_CONFIRM_BIND:
			return HOO_PHONE_URL_HOST_MY + "/mobile/confirmBindMobile.do";
		case URL_MY_UNBIND_MOBILE:
			return HOO_PHONE_URL_HOST_MY + "/mobile/cancelBindMobile.do";
		case URL_MY_MODIFY_MOBILE_NAME:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyBindMobileName.do";
		case URL_MY_GET_BIND_LIST:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getBindList.do";
		case URL_MY_BIND_STB:
			return HOO_PHONE_URL_HOST_MY + "/mobile/bindStb.do";
		case URL_MY_CANCEL_STB:
			return HOO_PHONE_URL_HOST_MY + "/mobile/cancelBindSTB.do";
		case URL_MY_CONFIRM_STB:
			return HOO_PHONE_URL_HOST_MY + "/mobile/confirmBindSTB.do";
		case URL_MY_USER_LOGIN:
			return HOO_PHONE_URL_HOST_MY + "/mobile/userLogin.do";
		case URL_MY_SEND_CHECKCODE:
			return HOO_PHONE_URL_HOST_MY + "/mobile/sendCheckCodeSMS.do";
		case URL_MY_FIND_PW:
			return HOO_PHONE_URL_HOST_MY + "/mobile/findUserPassword.do";
		case URL_MY_BIND_CODE:
			return HOO_PHONE_URL_HOST_MY + "/mobile/bindVerifyCode.do";
		case URL_MY_MODIFY_USER_PWD:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyUserPassword.do";
		case URL_MY_MODIFY_USER_INFO:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyUserInfo.do";
		case URL_MY_GET_USERTOP_LIST:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getUserTopList.do";
		case URL_MY_REGISTER_USER:
			return HOO_PHONE_URL_HOST_MY + "/mobile/registerUser.do";
		case URL_MY_GET_USER_INFO:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getUserInfo.do";
		case URL_MY_SET_USER_PWD:
			return HOO_PHONE_URL_HOST_MY + "/mobile/setUserPassword.do";
		case URL_MY_MODIFY_USER_PIC:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyUserPortraitPic.do";
		case URL_MY_MODIFY_BINGSTB_NAME:
			return HOO_PHONE_URL_HOST_MY + "/mobile/modifyBindStbName.do";
		case URL_MY_SET_USERINFO:
			return HOO_PHONE_URL_HOST_MY + "/mobile/setUserInfo.do";
		case URL_MY_PIC_PREFIX:
			return HOO_PHONE_URL_HOST_MY + "/userpicture";
		case URL_MY_ADD_OPERATOR:
			return HOO_PHONE_URL_HOST_MY + "/mobile/addOperator.do";
		case URL_UPGRADE_IDEA:
			return HOO_PHONE_URL_HOST_UPGRADE + "/upgradeService/ideaTick.do";
		case URL_UPGRADE_UPDATE:
			return HOO_PHONE_URL_HOST_UPGRADE + "/upgradeService/upgrade.do";
		case URL_MY_GET_OPERATOR_INFO_LIST:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getOperatorInfoList.do";
		case URL_MY_GET_AREA_LIST:
			return HOO_PHONE_URL_HOST_MY + " mobile/getAreaList.do";
		case URL_MY_GET_MY_OPERATOR_LIST:
			return HOO_PHONE_URL_HOST_MY + "/mobile/getMyOperatorList.do";
		case URL_MY_GET_MY_DEVICE_LIST:
			return HOO_PHONE_URL_HOST_UPGRADE + "/mobile/getMyDeviceList.do";
		case URL_MY_ADD_MY_DEVICE:
			return HOO_PHONE_URL_HOST_UPGRADE + "/mobile/addMyDevice.do";

			/**
			 * 1.4.6 EPG需要用到的加版本号的接口
			 */
		case URL_MY_BIND_STB_146:
			return HOO_PHONE_URL_HOST_MY + "/mobile/bindStb146.do";

		}
		return url;
	}

	// TODO
	// --------------------------------广播部分-----------------------------------------------
	public static final String HOO_BRODCAST_MSG_COUNT = "hooBroadcastMsgCount";

	public static final String HOO_BRODCAST_NEW_MSG = "hooBroadcastNewMsg";

	public static final String HOO_BRODCAST_NEW_USER = "hooBroadcastNewUser";

	/**
	 * 根目录
	 */
	public final static String ROOT = getSDCardPath() + File.separator
			+ "hooray" + File.separator;

	/**
	 * 得到sdcard目录
	 */
	public static String getSDCardPath() {
		return Environment.getExternalStorageDirectory().getPath();
	}

	/**
	 * 检测sdcard是否存在
	 * 
	 * @return 存在返回true，不存在返回false
	 */
	public static boolean checkSDCard() {
		// sd卡是否存在
		return Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
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

}
