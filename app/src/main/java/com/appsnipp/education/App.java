package com.appsnipp.education;

import android.app.Application;

import com.appsnipp.education.ui.helpers.DiscreteScrollViewOptions;



public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //this need for using course pager scrolling
        DiscreteScrollViewOptions.init(this);
    }
}
