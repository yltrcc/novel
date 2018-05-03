package com.ttxxly.reader;

import android.app.Application;

import com.ttxxly.reader.utils.AppUtils;


public class ReaderApplication extends Application {

    private static ReaderApplication mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        AppUtils.init(this);

    }

    public static ReaderApplication getsInstance() {
        return mInstance;
    }

}
