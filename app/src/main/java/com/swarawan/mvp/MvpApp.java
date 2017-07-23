package com.swarawan.mvp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by rioswarawan on 7/23/17.
 */

public class MvpApp extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
