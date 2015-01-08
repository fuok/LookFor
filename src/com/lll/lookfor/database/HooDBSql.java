/**
 * 文件名称 : HooDBSql.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年8月4日, 下午7:14:06
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : HooDBSql.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年8月4日, 下午7:14:06
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.database;

/**
 * @author LIJUNJIE
 *
 */
public class HooDBSql {
  //---------------------------数据库相关-----------------------------------------------------------
    //数据库消息表表名
    public static final String HOO_DATABASE_MESSAGE = "tbl_message";
    //数据库
    public static final String HOO_DATABASE_BINDUSER = "tbl_binduser";
    //数据库版本号
    public static final int HOO_DATABASE_VERSION = 1;
    //---------------------------SQL语句相关-----------------------------------------------------------
  //创建消息表
    public static final String HOO_SQL_MESSAGE_CREATE =
    "CREATE TABLE IF NOT EXISTS "+HooDBSql.HOO_DATABASE_MESSAGE+"(msgId Integer PRIMARY KEY,receiveId CHAR[32],senderId CHAR[32],msgType Integer,"
    + "subject CHAR[256],content CHAR[1024],contentType Integer,mediaName CHAR[1024],mediaPoster CHAR[1024],sendTime CHAR[32],senderName CHAR[32],senderLogo CHAR[256],"
    + "status Integer,mediaId Integer,groupId CHAR[32],mediaStartTime CHAR[32],mediaEndTime CHAR[32],url CHAR[1024],channelId Integer)";
    //新增消息
    public static final String HOO_SQL_MSG_INSERT = 
            "INSERT INTO {0}(msgId,receiveId,senderId,msgType,subject,content,contentType,mediaName,mediaPoster,sendTime,senderName,senderLogo,status,mediaId,groupId,mediaStartTime,mediaEndTime,url,channelId) "
            + "values({1},''{2}'',''{3}'',{4},''{5}'',''{6}'',{7},''{8}'',''{9}'',''{10}'',''{11}'',''{12}'',{13},{14},''{15}'',''{16}'',''{17}'',''{18}'',''{19}'')";
    public static final String HOO_SQL_MSG_UPDATE =
            "UPDATE {0} SET receiveId=''{1}'',senderId=''{2}'',msgType={3},subject=''{4}'',content=''{5}'',contentType={6},mediaName=''{7}'',"
            + "mediaPoster=''{8}'',sendTime=''{9}'',senderName=''{10}'',senderLogo=''{11}'',status=''{12}'',mediaId=''{13}'',groupId=''{14}'',mediaStartTime=''{15}'',mediaEndTime=''{16}'',url=''{17}'',channelId=''{18}'' WHERE msgId={19}";
    public static final String HOO_SQL_DELETE_MSG_MESSAGEID = "DELETE FROM {0} WHERE msgId={1}";
    public static final String HOO_SQL_DELETE_MSG_GROUPID = "DELETE FROM {0} WHERE groupId=''{1}''";
    public static final String HOO_SQL_DELETE_MSG_DATE = "DELETE FROM {0} WHERE groupId=''{1}'' AND sendTime >= ''{2}'' AND sendTime <= ''{3}''";
    //删除一条消息
    public static final String HOO_SQL_MSG_DELETE = 
            "DELETE FROM {0} WHERE msgId={1}";
    //删除所有数据
    public static final String HOO_SQL_ALL_DELETE =
            "DELETE FROM {0}";
    
    //删除一个用户
    public static final String HOO_SQL_USER_DELETE =
            "DELETE FROM {0} WHERE userId={1}";
    //新增一个用户
    public static final String HOO_SQL_USER_INSERT =
            "INSERT INTO "+HOO_DATABASE_BINDUSER+"(bindedUserId,userId,isPrimary,user_cnName,user_mobile,user_portraitPic) "+"values(''{0}'',''{1}'',{2},''{3}'',''{4}'',''{5}'')";
    //创建绑定用户数据表
    public static final String HOO_SQL_USER_CREATE =
            "CREATE TABLE IF NOT EXISTS "+HOO_DATABASE_BINDUSER+" (bindedUserId CHAR[32] KEY,userId CHAR[32],isPrimary Integer,user_cnName CHAR[256],user_mobile CHAR[24],user_portraitPic CHAR[256])";
    
    
}
