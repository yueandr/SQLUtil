package cn.ximoon.sqlutil.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cn.ximoon.framework.db.DBInfo;
import cn.ximoon.framework.db.DBOpenHelper;
import cn.ximoon.sqlutil.logic.AppController;
import cn.ximoon.sqlutil.logic.model.TestModel;


public class DBHelper extends DBOpenHelper {

    private static DBHelper instance;

    private DBHelper() {
        open();
    }

    private DBHelper(Context context) {
        open(context);
    }

    public static synchronized DBHelper getInstance() {
        if (null == instance) {
            synchronized(DBHelper.class) {
                instance = new DBHelper();
            }
        }
        return instance;
    }

    public static synchronized void initial(Context context) {
        if (null == instance) {
            synchronized(DBHelper.class) {
                instance = new DBHelper(context);
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TestModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){

        }
    }

    @Override
    public DBInfo getDBInfo() {
        return AppController.getInstance().getDBInfo();
    }
}