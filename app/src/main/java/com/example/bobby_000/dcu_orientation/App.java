package com.example.bobby_000.dcu_orientation;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by bobby_000 on 29/05/2017.
 */

public class App extends Application {

    private static  Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
        //should help when the app crashes and you cannot set the static context to null
    }
}
