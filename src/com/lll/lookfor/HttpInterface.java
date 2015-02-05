package com.lll.lookfor;

/** 保存请求的数据接口 */
public class HttpInterface {

	/** 主机地址 */
	private static String LOOK_FOR_HOST = "http://182.92.241.249";

	/** 系统登录接口 */
	public static String SYSTEM_LOGIN = LOOK_FOR_HOST + "/lookfor/rest/user/systemLogin";

	/** 获取好友列表 */
	public static String FRIEND_LIST = "http://www.xshcar.com/chen/friendList.html";// 假

	/** 获取指定用户地理数据详情 */
	public static String LBS_LIST = "http://www.xshcar.com/chen/friendDetail.html";// 假

	/** 用户注册 */
	public static String REGIST = LOOK_FOR_HOST + "/lookfor/inter/user/regist";

	/** 用户登录 */
	public static String USER_LOGIN = LOOK_FOR_HOST + "/lookfor/inter/user/userLogin";

	/** 修改昵称 */
	public static String MODIFY_NICKNAME = LOOK_FOR_HOST + "/lookfor/inter/user/modifyNickName";
}
