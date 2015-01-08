/**
 * 文件名称 : HooDataBaseHelper.java
 * <p>
 * 作者信息 : LIJUNJIE
 * <p>
 * 创建时间 : 2014年7月28日, 下午8:56:44
 * <p>
 * 版权声明 : Copyright (c) Hooray Ltd. All rights reserved
 * <p>
 **/

package com.lll.lookfor.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author LIJUNJIE
 *
 */
public class HooDataBaseHelper extends SQLiteOpenHelper {

    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     * @param errorHandler
     */
    public HooDataBaseHelper(Context context, String name,
            CursorFactory factory, int version,
            DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public HooDataBaseHelper(Context context, String name,
            CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    /* 初始化数据库
     * @
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HooDBSql.HOO_SQL_MESSAGE_CREATE);
        db.execSQL(HooDBSql.HOO_SQL_USER_CREATE);
    }
    /* 更新数据库
     * @删除旧数据，建立新表
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int upgradeVersion = oldVersion;
        //将版本1升级到版本2
        if(upgradeVersion == 1){
            
            upgradeVersion = 2;
        }
        //将版本2升级到版本3
        if(upgradeVersion == 2){
            upgradeVersion = 3;
        }
    }    
}
