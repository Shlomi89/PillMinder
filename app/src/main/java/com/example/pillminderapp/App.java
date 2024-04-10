package com.example.pillminderapp;

import android.app.Application;

import com.example.pillminderapp.Utilities.ImageLoader;
import com.example.pillminderapp.Utilities.PopupUtility;
import com.example.pillminderapp.Utilities.SharedPreferencesManager;
import com.example.pillminderapp.Utilities.SignalManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesManager.init(this);
        ImageLoader.initImageLoader(this);
        PopupUtility.initPopupUtility(this);
        SignalManager.init(this);
    }
}
