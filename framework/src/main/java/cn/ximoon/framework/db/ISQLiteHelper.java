package cn.ximoon.framework.db;

import android.database.sqlite.SQLiteDatabase;

public interface ISQLiteHelper{
        
        void onCreate(SQLiteDatabase db);
        
        void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
    }