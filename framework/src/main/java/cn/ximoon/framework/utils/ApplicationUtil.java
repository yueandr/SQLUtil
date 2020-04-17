package cn.ximoon.framework.utils;

import android.app.Application;
import android.content.Context;

import cn.ximoon.framework.db.DBInfo;

/**
 * Created by Admin on 2018/1/8.
 */

public class ApplicationUtil {

    private static Context mContext ;
    private static DBInfo mDBInfo;

    public static void initContext(Context context){
        mContext = context;
    }

    public static void initDB(DBInfo info){
        mDBInfo = info;
    }

    public static DBInfo getDBInfo(){
        if (null == mDBInfo){
            mDBInfo = new DBInfo();
            mDBInfo.DB_NAME = "app.db";
            mDBInfo.DB_VERSION = 1;
        }
        return mDBInfo;
    }

    public static Context getApplicationContext(){
        if(null != mContext){
            return mContext;
        }
        Application application = null;
        try {
            application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null, (Object[]) null);
            if (null == application){
                application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null, (Object[]) null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mContext = application;
        return application;
    }
}
