package com.leo.scanapp;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import cn.bmob.v3.Bmob;

public class App extends Application {
    private static final String APPID = "72ebddd5872f926dd9d85f16227d58dc";

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, APPID);
        ZXingLibrary.initDisplayOpinion(this);
    }
}
