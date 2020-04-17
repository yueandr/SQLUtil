package cn.ximoon.sqlutil.logic;

import cn.ximoon.framework.db.DBInfo;
import cn.ximoon.framework.utils.ApplicationUtil;
import cn.ximoon.sqlutil.base.ConstantUtils;

public class AppController {

    private static AppController INSTANCE;
    private DBInfo mDBInfo;

    public AppController() {
        mDBInfo = new DBInfo();
        mDBInfo.DB_NAME = ConstantUtils.DB_NAME;
        mDBInfo.DB_VERSION = ConstantUtils.DB_VERSION;
        ApplicationUtil.initDB(mDBInfo);
    }

    public static AppController getInstance(){
        if (null == INSTANCE){
            synchronized (AppController.class){
                INSTANCE = new AppController();
            }
        }
        return INSTANCE;
    }

    public DBInfo getDBInfo() {
        return mDBInfo;
    }
}
