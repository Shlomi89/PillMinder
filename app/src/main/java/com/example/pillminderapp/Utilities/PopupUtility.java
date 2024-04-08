package com.example.pillminderapp.Utilities;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class PopupUtility {

    private static PopupUtility instance;
    private static Context appContext;


    private PopupUtility(Context context) {
        appContext = context;
    }

    public static PopupUtility getInstance() {
        return instance;
    }

    public static PopupUtility initPopupUtility(Context context) {
        if (instance == null)
            instance = new PopupUtility(context);
        return instance;
    }




    public MaterialAlertDialogBuilder getAlertBuilder(){
        return new MaterialAlertDialogBuilder(appContext);
    }


}
