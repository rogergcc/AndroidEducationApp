/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public final class MyUtilsApp {
    private MyUtilsApp(){}
    public static void showToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLog(String TAG,String message){
        Log.d(TAG, "showLog: "+ message);
    }
}
