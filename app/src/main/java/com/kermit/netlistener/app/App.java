package com.kermit.netlistener.app;

import android.app.Application;

/**
 * Created by Kermit on 15-9-6.
 * e-mail : wk19951231@163.com
 */
public class App extends Application {

    public static App instance;

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
