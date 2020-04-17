package cn.ximoon.framework.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.ximoon.framework.utils.ApplicationUtil;


public abstract class DBOpenHelper implements ISQLiteHelper {

    public DatabaseHelper dbHelper = null;
    public SQLiteDatabase db = null;

    public boolean isDBOpen() {
        if (null == db) {
            return false;
        } else {
            return db.isOpen();
        }
    }

    /**
     * 打开数据库
     */
    public void open() {
        dbHelper = new DatabaseHelper(ApplicationUtil.getApplicationContext());
        db = dbHelper.getWritableDatabase();
    }

    public void open(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * 获取数据库操作对象
     */
    public SQLiteDatabase getSQLiteDatabase() {
        if (db != null) {
            return db;
        } else {
            open();
            return db;
        }
    }

    /**
     * 返回只读的数据库实例
     * 注意：由于底层返回的数据库实例和可写的是同一个实例，所以只能由调用者自己来保证不用于写操作。
     *
     * @return 只读的数据库实例
     */
    public SQLiteDatabase getReadOnlySQLiteDatabase() {
        if (db != null) {
            return db;
        } else {
            open();
            return db;
        }
    }

    /**
     * 关闭数据库
     */
    public void close() {
        if (null != db) {
            db.close();
        }
        if (null != dbHelper) {
            dbHelper = null;
        }
    }

    public abstract DBInfo getDBInfo();

    public class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, getDBInfo().DB_NAME, null, getDBInfo().DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.beginTransaction();
            try {
                DBOpenHelper.this.onCreate(db);
                db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
            db.endTransaction();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            DBOpenHelper.this.onUpgrade(db, oldVersion, newVersion);
        }
    }

}