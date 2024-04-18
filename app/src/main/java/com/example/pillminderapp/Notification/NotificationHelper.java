package com.example.pillminderapp.Notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class NotificationHelper {
    public static void createNotification(Context context, String prescriptionName) {
        // Create a notification channel (required for Android 8.0 and above)
//        createNotificationChannel(context);

        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "pill_minder_channel")
                .setContentTitle("PillMinder")
                .setContentText("Time to take: " + prescriptionName)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Show the notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }

    public static void createNotificationChannel(Context context) {
        CharSequence name = "PillMinder Channel";
        String description = "Channel for PillMinder notifications";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("pill_minder_channel", name, importance);
        channel.setDescription(description);
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}

