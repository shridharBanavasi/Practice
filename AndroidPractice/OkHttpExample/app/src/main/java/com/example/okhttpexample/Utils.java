package com.example.okhttpexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class Utils {
    public static void showNotification(Context context, String title, String text){
        NotificationCompat.Builder mBilder;
        Intent resultIntent;
        PendingIntent resultPandingIntent;
        resultIntent=new Intent(context, MainActivity.class);

        int requestCode=0;
        resultPandingIntent=PendingIntent.getActivity(
                context,
                requestCode,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT//tells how to treat main activity
        );

        mBilder=new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title);

        //set and to remove notification
        mBilder.setAutoCancel(true);

        //handle click event
        mBilder.setContentIntent(resultPandingIntent);

        //set vibration on notification
        mBilder.setVibrate(new long[]{1000,1000});

        //Device LED
        mBilder.setLights(Color.RED, 3000,3000 );

        mBilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        int NotificationId=001;

        //get instance of the Notification service
        NotificationManager mNortificationManager=
                (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        mNortificationManager.notify(NotificationId,mBilder.build());

    }
}
