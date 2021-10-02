package com.appsnipp.education;

import android.app.Application;

import com.appsnipp.education.ui.utils.AppLogger;


public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        AppLogger.init();
    }
}
