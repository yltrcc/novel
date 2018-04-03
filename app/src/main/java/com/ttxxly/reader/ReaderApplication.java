package com.ttxxly.reader;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.ttxxly.reader.utils.AppUtils;
import com.ttxxly.reader.utils.FileUtils;
import com.ttxxly.reader.utils.LogUtils;



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
