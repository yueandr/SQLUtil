package cn.ximoon.sqlutil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import cn.ximoon.framework.utils.StringUtil;
import cn.ximoon.sqlutil.bean.Test;
import cn.ximoon.sqlutil.logic.model.TestModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);
        Test test = new Test();
        test.mName = "Android";
        test.mAge = 18;
        TestModel.insert(test);
        List<Test> list = TestModel.queryAll();
        for (Test info : list) {
            tv.append("\n");
            tv.append(info.mName);
            tv.append("------");
            tv.append(String.valueOf(info._id));
        }

    }

}
