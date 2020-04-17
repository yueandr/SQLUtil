package cn.ximoon.sqlutil;

import android.app.Application;

import cn.ximoon.framework.utils.ApplicationUtil;
import cn.ximoon.sqlutil.logic.AppController;

public class AppApplication extends Application {

    private static AppApplication INSTANCE;

    public static AppApplication getInstance() {
        if (null == INSTANCE){
            synchronized (AppApplication.class){
                INSTANCE = (AppApplication) ApplicationUtil.getApplicationContext();
            }
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        ApplicationUtil.initContext(INSTANCE);
        AppController.getInstance();
    }

}
