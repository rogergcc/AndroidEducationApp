package com.appsnipp.education;

import android.app.Application;
import android.content.res.Resources;

import com.appsnipp.education.ui.utils.AppLogger;


public class BaseApplication extends Application {
    private static Resources resources;
    private static BaseApplication mInstance;

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    public static Resources getAppResources() {
        return resources;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        resources = getResources();
        AppLogger.init();
    }
}
