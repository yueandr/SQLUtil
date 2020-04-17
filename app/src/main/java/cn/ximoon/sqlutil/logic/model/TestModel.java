package cn.ximoon.sqlutil.logic.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.ximoon.sqlutil.bean.Test;
import cn.ximoon.sqlutil.db.DBHelper;

public class TestModel {

	public static final String TABLE_NAME = "tb_test";
	public static final String M_NAME = "m_name";
	public static final String M_AGE = "m_age";
	public static final String _ID = "_id";

	public static final String CREATE_TABLE = new StringBuilder("CREATE TABLE ").append(TABLE_NAME).append("( ")
			.append(M_NAME).append(" TEXT, ")
			.append(M_AGE).append(" INTEGER, ")
			.append(_ID).append(" INTEGER PRIMARY KEY AUTOINCREMENT )").toString();

	public static final String _ID_CLAUSE = _ID + " = ?";


	public static long insert(Test info){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		info._id = db.insert(TABLE_NAME, null, getKeyAndValue(info));
		return info._id;
	}

	public static boolean insertRow(Test info){
		return insert(info) > 0;
	}

	public static boolean insertRow(List<Test> infos){
		boolean isInsert = false;
		for(Test info : infos){
			isInsert &= insertRow(info);
		}
		return isInsert;
	}

	public static int update(Test info){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		return db.update(TABLE_NAME, getKeyAndValue(info), _ID_CLAUSE, new String[]{String.valueOf(info._id)});
	}

	public static int delete(long _id){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		return db.delete(TABLE_NAME, _ID_CLAUSE, new String[]{String.valueOf(_id)});
	}

	public static int delete(Test info){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		return db.delete(TABLE_NAME, _ID_CLAUSE, new String[]{String.valueOf(info._id)});
	}

	public static List<Test> queryAll(){
		ArrayList<Test> infos = new ArrayList<>();
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		Cursor cr = db.query(TABLE_NAME, null, null, null, null, null, null);
		Test info;
		while (cr.moveToNext()){
			info = new Test();
			getModel(info, cr);
			infos.add(info);
		}
		return infos;
	}

	public static Test query(long _id){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		Cursor cr = db.query(TABLE_NAME, null, _ID_CLAUSE, new String[]{String.valueOf(_id)}, null, null, null);
		Test info = new Test();
		if (cr.moveToNext()){
			getModel(info, cr);
		}
		return info;
	}

	public static Test query(Test info){
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		Cursor cr = db.query(TABLE_NAME, null, _ID_CLAUSE, new String[]{String.valueOf(info._id)}, null, null, null);
		Test data = new Test();
		if (cr.moveToNext()){
			getModel(data, cr);
		}
		return data;
	}

	public static List<Test> queryAll(Test info){
		ArrayList<Test> infos = new ArrayList<>();
		SQLiteDatabase db = DBHelper.getInstance().getSQLiteDatabase();
		Cursor cr = db.query(TABLE_NAME, null, _ID_CLAUSE, new String[]{String.valueOf(info._id)}, null, null, null);
		Test data;
		while (cr.moveToNext()){
			data = new Test();
			getModel(data, cr);
			infos.add(data);
		}
		return infos;
	}

	public static ContentValues getKeyAndValue(Test info){
		ContentValues cv = new ContentValues();
		cv.put(M_NAME, info.mName);
		cv.put(M_AGE, info.mAge);
		return cv;
	}

	public static void getModel(Test info, Cursor cr){
		info.mName = cr.getString(cr.getColumnIndex(M_NAME));
		info.mAge = cr.getInt(cr.getColumnIndex(M_AGE));
		info._id = cr.getLong(cr.getColumnIndex(_ID));
	}

}