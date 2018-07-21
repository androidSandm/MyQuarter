package com.example.boylucky.myquarter.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by BoyLucky on 2018/7/20.
 */

public class App extends AppCompatActivity {
    public static Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        Fresco.initialize(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        CrashReport.initCrashReport(getApplicationContext(), "c38bc0c855", false);
    }
}
