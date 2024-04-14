package com.example.pillminderapp.Utilities;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.pillminderapp.Model.Prescription;
import com.example.pillminderapp.Notifilication.NotificationReceiver;

import java.util.Calendar;
import java.util.List;

public class AlarmUtils {

    public static void updateAlarms(Context context, List<Prescription> prescriptionList) {
        for (Prescription prescription : prescriptionList) {
            cancelAlarm(context, prescription); // Cancel existing alarm
            if (prescription.getHour() != -1 && prescription.getMinute() != -1) {
                scheduleAlarm(context, prescription); // Schedule new alarm
            }
        }
    }

    private static void scheduleAlarm(Context context, Prescription prescription) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("prescription_name", prescription.getName());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        // Calculate the time to trigger the alarm
        long triggerAtMillis = calculateTriggerTime(prescription);
        // Set the alarm to trigger at the specified time and repeat every day
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    private static void cancelAlarm(Context context, Prescription prescription) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.cancel(pendingIntent);
        pendingIntent.cancel();
    }

    private static long calculateTriggerTime(Prescription prescription) {
        // Calculate the time to trigger the alarm based on prescription hour and minute
        // Here, you can implement your own logic to calculate the exact time
        // For example, you can use Calendar to set the time
        // For simplicity, we assume the prescription time is today
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, prescription.getHour());
        calendar.set(Calendar.MINUTE, prescription.getMinute());
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }
}

