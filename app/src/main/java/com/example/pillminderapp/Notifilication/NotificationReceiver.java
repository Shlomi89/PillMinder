package com.example.pillminderapp.Notifilication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String prescriptionName = intent.getStringExtra("prescription_name");

        // Create and send the notification here
        NotificationHelper.createNotification(context, prescriptionName);
    }
}
