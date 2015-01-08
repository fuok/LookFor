/**
 * 文件名称 : SystemUtil.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月23日, 下午7:40:10
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

/**
 * 文件名称 : SystemUtil.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年5月23日, 下午7:40:10
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/
package com.lll.lookfor.utils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.lll.lookfor.database.HooDBSql;
import com.lll.lookfor.database.HooDataBaseHelper;
import com.lll.lookfor.model.BindUserBean;
import com.lll.lookfor.model.HooMsgBean;
import com.lll.lookfor.model.HooUserInfo;

/**
 * @author LIJUNJIE
 *
 */
public class SystemUtil {
	private static final String TAG="SystemUtil";
    //portal lanucher Id
    public static final int  SYSTEM_ID_PORTAL = 0;
    //点播Id
    public static final int  SYSTEM_ID_VOD     = 1000;
    //直播Id
    public static final int  SYSTEM_ID_LIVE    = 2000;
    //直播播放器
    public static final int  SYSTEM_ID_LIVE_PLAYER    = 2001;
    //直播导视
    public static final int  SYSTEM_ID_LIVE_GUIDE    = 2002;
    //家庭圈
    public static final int  SYSTEM_ID_HOME    = 4000;
    
    public static String getSystemPackageName(int systemId){
        switch(systemId){
            case SYSTEM_ID_PORTAL:
                return "com.hooray.portal";
            case SYSTEM_ID_HOME:
                return "com.hooray.hoohome";
            case SYSTEM_ID_LIVE_PLAYER:
                return "com.hooray.hoolive";
        }
        return "";
    }
    public static SharedPreferences getSharedPreferences(Context context,int systemId,String preferenceName){
        Context c = null;
        try{  

             c=context.createPackageContext(getSystemPackageName(systemId),Context.CONTEXT_IGNORE_SECURITY);  

        }catch(NameNotFoundException e){  

             e.printStackTrace();  
             return null;
        }
        return c.getSharedPreferences(preferenceName,Context.MODE_MULTI_PROCESS);
    }
   
    /**获取APK版本号versionName*/
    public static String getVersionName(Context c){
    	PackageInfo pi=null;
    	PackageManager pm = c.getPackageManager();
    	try {
			pi = pm.getPackageInfo(c.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			Log.e("Exception", "版本号异常");
//			e.printStackTrace();
		}
		return pi!=null?pi.versionName:"";
    }

    /**
     * 缓存Msg列表
     */
    protected static HashMap<Integer,ArrayList<HooMsgBean>> msgMap = new HashMap<Integer,ArrayList<HooMsgBean>>();
    // protected static ArrayList<HooMsgBean> msgList = new ArrayList<HooMsgBean>();
    /**
     * 缓存绑定用户列表
     */
    protected static ArrayList<BindUserBean> bindUserList = new ArrayList<BindUserBean>();
    
    /**
     * 清除本地消息
     * @param context
     * @return
     */
    public static boolean clearMessage(Context context){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            db.execSQL(MessageFormat.format(HooDBSql.HOO_SQL_ALL_DELETE, HooDBSql.HOO_DATABASE_MESSAGE));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
        return true;
    }
    /**
     * 新增一条消息
     * @param context
     * @param bean 消息体
     * @return
     */
    public static boolean addMessage(Context context,ArrayList<HooMsgBean> msgList){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
//        msgList.addAll(msgList);
        try{
            for(HooMsgBean msgBean:msgList){
                //更新消息到数据库
            	Log.i(TAG, "保存消息："+msgBean.getInsertSql());
                db.execSQL(msgBean.getInsertSql());
                /*内存中暂不保存，由各个应用自己保存
                 //更新消息到内存
                ArrayList<HooMsgBean> userMsgList = msgMap.get(msgBean.getSenderId()); 
                if(userMsgList == null){
                    userMsgList = new ArrayList<HooMsgBean>();
                    msgMap.put(msgBean.getSenderId(),userMsgList);
                }
                //按照消息时间排序插入
                int i = 0;
                for(HooMsgBean oldMsgBean : msgList){
                    i++;
                    if(oldMsgBean.getSendTime().compareTo(msgBean.getSendTime()) > 0){
                        //插入消息后退出
                        msgList.add(i,msgBean);
                        break;
                    }
                }*/
            }
               
		} catch (SQLException ex) {
			Log.e(TAG, "保存失败");
			// ex.printStackTrace();
		}
        
        db.close();
        
        return true;
    }
    
    //获取用户未读消息数量，发送者ID不为登陆用户ID的且消息类型为用户消息,消息状态为未读,如果出错则返回0
    public static int getUnreadMsgCount(Context context,String userId){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        try{
            //查询对应bindId的消息，如果bindId为null则查询所有消息，按照bindId排序
            Cursor cursor = db.query(true,HooDBSql.HOO_DATABASE_MESSAGE,null," senderId!="+userId+" and msgType=1 and status=0 ",null,null,null,"sendTime",null);
            return cursor.getCount();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
        
        return 0;
    }
    /**
     * 获取和bindId相关的消息
     * @param context   UI上下文
     * @param senderId  发送消息的用户Id
     * @return 消息列表
     */
    public static ArrayList<HooMsgBean> getMessageByGroupId(Context context,int groupId){
        ArrayList<HooMsgBean> msgList = new ArrayList<HooMsgBean>();
        
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        try{
            //查询对应bindId的消息，如果bindId为null则查询所有消息，按照bindId排序
            Cursor cursor = db.query(true,HooDBSql.HOO_DATABASE_MESSAGE,null,"groupId="+groupId,null,null,null,"sendTime",null);
            if(cursor != null){
                //取字段内容
                while(cursor.moveToNext()){
                    HooMsgBean msgBean = new HooMsgBean();                    
                    msgBean.setMsgId(cursor.getInt(0));            //msgId
                    msgBean.setReceiveId(cursor.getString(1));        //receiveId
                    msgBean.setSenderId(cursor.getString(2));         //senderId
                    msgBean.setMsgType(cursor.getInt(3));          //msgType
                    msgBean.setSubject(cursor.getString(4));       //subject
                    msgBean.setContent(cursor.getString(5));       //content
                    msgBean.setContentType(cursor.getInt(6));      //contentType
                    msgBean.setMediaName(cursor.getString(7));     //mediaName
                    msgBean.setMediaPoster(cursor.getString(8));   //mediaPoster
                    msgBean.setSendTime(cursor.getString(9));      //sendTime
                    msgBean.setSenderName(cursor.getString(10));    //senderName
                    msgBean.setSenderLogo(cursor.getString(11));    //senderLogo
                    msgBean.setStatus(cursor.getInt(12));           //status
                    msgBean.setMediaId(cursor.getInt(13));          //mediaId
                    msgBean.setGroupId(cursor.getString(14));          //groupId
                    msgBean.setMediaStartTime(cursor.getString(15));//mediaStartTime
                    msgBean.setMediaEndTime(cursor.getString(16));//mediaEndTime
                    msgBean.setUrl(cursor.getString(17));//Url
                    msgBean.setChannelId(cursor.getInt(18));//ChannelId
                    msgList.add(msgBean);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
        return msgList;
    }
    /**
    public static ArrayList<HooMsgBean> getAllMessage(Context context){
        ArrayList<HooMsgBean> list = new ArrayList<HooMsgBean>();
        for(Entry<Integer,ArrayList<HooMsgBean>> entry:msgMap.entrySet()){
            list.addAll(entry.getValue());
        }
        return list;
    }*/
    
    /**
     * 更新数据
     * @param context
     * @param msgList 需要更新的数据列表
     */
    public static void updateMessage(Context context,ArrayList<HooMsgBean> msgList){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        for(HooMsgBean bean : msgList){
            db.execSQL(bean.getUpdateSql());
        }
        db.close();
    }
    /**
     * 将数据库中的消息同步到内存中
     * 已过期，暂时不用
     * @param context
     */
    synchronized public static ArrayList<HooMsgBean> loadMessage(Context context){
        ArrayList<HooMsgBean> msgList =new ArrayList<HooMsgBean>();
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        //清空原有的消息
        //msgMap.clear();
        try{
            //获取所有用户消息
            
            
          //查询对应bindId的消息，如果bindId为null则查询所有消息，按照bindId排序
            Cursor cursor = db.query(true,HooDBSql.HOO_DATABASE_MESSAGE,null,null,null,null,null,"sendTime desc",null);
            if(cursor != null){
                //取字段内容
                while(cursor.moveToNext()){
                    HooMsgBean msgBean = new HooMsgBean();                    
                    msgBean.setMsgId(cursor.getInt(0));            //msgId
                    msgBean.setReceiveId(cursor.getString(1));        //receiveId
                    msgBean.setSenderId(cursor.getString(2));         //senderId
                    msgBean.setMsgType(cursor.getInt(3));          //msgType
                    msgBean.setSubject(cursor.getString(4));       //subject
                    msgBean.setContent(cursor.getString(5));       //content
                    msgBean.setContentType(cursor.getInt(6));      //contentType
                    msgBean.setMediaName(cursor.getString(7));     //mediaName
                    msgBean.setMediaPoster(cursor.getString(8));   //mediaPoster
                    msgBean.setSendTime(cursor.getString(9));      //sendTime
                    msgBean.setSenderName(cursor.getString(10));    //senderName
                    msgBean.setSenderLogo(cursor.getString(11));    //senderLogo
                    msgBean.setStatus(cursor.getInt(12));           //status
                    msgBean.setMediaId(cursor.getInt(13));          //mediaId
                    msgBean.setGroupId(cursor.getString(14));          //groupId
                    msgBean.setMediaStartTime(cursor.getString(15));//mediaStartTime
                    msgBean.setMediaEndTime(cursor.getString(16));//mediaEndTime
                    msgBean.setUrl(cursor.getString(17));//Url
                    msgBean.setChannelId(cursor.getInt(18));//ChannelId
                    msgList.add(msgBean);
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
        return msgList;
    }

    /**
     *  获取所有绑定用户列表
     * @param context
     * @return
     */
    public static ArrayList<BindUserBean> getBindUserList(Context context){
        return bindUserList;
    }
    public static void clearBindUserList(Context context){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            db.execSQL(MessageFormat.format(HooDBSql.HOO_SQL_ALL_DELETE, HooDBSql.HOO_DATABASE_BINDUSER));    
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
    }
    /**
     * 根据消息Id来删除消息
     * @param context
     * @param msgId
     */
    public static void deleteMsgByMsgId(Context context,int msgId){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            db.execSQL(MessageFormat.format(HooDBSql.HOO_SQL_DELETE_MSG_MESSAGEID, HooDBSql.HOO_DATABASE_MESSAGE,msgId+""));    
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
    }
    
    /**
     * 根据发送用户Id来删除消息
     * @param context
     * @param groupId
     */
    public static void deleteMsgByGroupId(Context context,String groupId){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            db.execSQL(MessageFormat.format(HooDBSql.HOO_SQL_DELETE_MSG_GROUPID, HooDBSql.HOO_DATABASE_MESSAGE,groupId));    
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
    }
    /**
     * 
     * @param context
     * @param groupId
     * @param startDate
     * @param endDate
     */
    public static void deleteMsgByDate(Context context,String groupId,String startDate,String endDate){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_MESSAGE,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            String sql = MessageFormat.format(HooDBSql.HOO_SQL_DELETE_MSG_DATE, HooDBSql.HOO_DATABASE_MESSAGE,groupId,startDate,endDate);
            db.execSQL(MessageFormat.format(HooDBSql.HOO_SQL_DELETE_MSG_DATE, HooDBSql.HOO_DATABASE_MESSAGE,groupId,startDate,endDate));    
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        db.close();
    }
    /**
     * 新增一个绑定用户
     * @param context
     * @param userBean
     * @return
     */
    public static boolean addBindUser(Context context,ArrayList<BindUserBean> userList){
        HooDataBaseHelper helper = new HooDataBaseHelper(context,HooDBSql.HOO_DATABASE_BINDUSER,null,HooDBSql.HOO_DATABASE_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            for(BindUserBean userBean:userList){
                //更新消息到数据库
                String sql = userBean.getInsertSql();
                db.execSQL(sql);
                //更新消息到内存
//                bindUserList.add(userBean);
            }
               
        }catch(SQLException ex){
            ex.printStackTrace();
        }        
        db.close();

        return true;
    }
    
    /**从数据库中获取绑定用户列表*/
	synchronized public static ArrayList<BindUserBean> loadUsers(Context context) {
		ArrayList<BindUserBean> userList = new ArrayList<BindUserBean>();
		HooDataBaseHelper helper = new HooDataBaseHelper(context, HooDBSql.HOO_DATABASE_MESSAGE, null, HooDBSql.HOO_DATABASE_VERSION);
		SQLiteDatabase db = helper.getReadableDatabase();
		try {
			Cursor cursor = db.query(true, HooDBSql.HOO_DATABASE_BINDUSER, null, null, null, null, null, null, null);
			if (cursor != null) {
				// 取字段内容
				while (cursor.moveToNext()) {
					BindUserBean bean = new BindUserBean();
					bean.setUser(new HooUserInfo());
					bean.setBindedUserId(cursor.getString(0));
					bean.setUserId(cursor.getString(1));
					bean.setPrimary(cursor.getInt(2));
					bean.getUser().setCnName(cursor.getString(3));
					bean.getUser().setMobile(cursor.getString(4));
					bean.getUser().setPortraitPic(cursor.getString(5));
					Log.w(TAG, bean.toString());

					userList.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		db.close();
		return userList;
	}
}
