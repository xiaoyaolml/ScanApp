package com.leo.scanapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startScan(View view) {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle == null) {
                return;
            }
            if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                final String result = bundle.getString(CodeUtils.RESULT_STRING);
                BmobQuery<Information> query = new BmobQuery<>();
                query.addWhereEqualTo("barcode", result);
                query.findObjects(new FindListener<Information>() {
                    @Override
                    public void done(List<Information> list, BmobException e) {
                        if (e == null) {
                            Information information = list.get(0);
                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                            intent.putExtra(TAG, information);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "条码："+result+" ,无详细信息！", Toast.LENGTH_LONG).show();
                            Log.i(TAG, "查询失败：" + e.getMessage() + ",错误码：" + e.getErrorCode());
                        }
                    }
                });

            } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                Toast.makeText(MainActivity.this, "条码解析失败！", Toast.LENGTH_LONG).show();
            }
        }
    }
}
