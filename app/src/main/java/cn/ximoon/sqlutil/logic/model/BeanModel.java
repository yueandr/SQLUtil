package cn.ximoon.sqlutil.logic.model;

import cn.ximoon.framework.db.SQLUtil;
import cn.ximoon.sqlutil.bean.Bean;

public class BeanModel {

    public static void main(String[] args) {
        try {
            SQLUtil.writeFile(Bean.class,
                    BeanModel.class,
                    "F:\\AndroidWorkSpace\\SQLUtil\\app\\src\\main\\java\\cn\\ximoon\\sqlutil\\bean\\Bean.java",
                    "F:\\AndroidWorkSpace\\SQLUtil\\app\\src\\main\\java\\cn\\ximoon\\sqlutil\\logic\\model\\BeanModel.java",
                    "DBHelper.getInstance().getSQLiteDatabase()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
