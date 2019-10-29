package com.example.okhttpexample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BackgroundService extends Service {

    Intent mIntent;
    public BackgroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int res= super.onStartCommand(intent, flags, startId);
        mIntent=intent;
        //we do our socket work here
        //process you do hear will alive for long, so be carefull here
        SocketClass.getInstance().connect(new SocketClass.SocketListener() {
            @Override
            public void onNewMessage(Object... data) {
                for (int i=0;i<data.length;i++){
                    String message=(String)data[i];

                    Log.d("SERVICE", "onNewMessage: "+message);


                    Context context=getApplicationContext();
                    Utils.showNotification(context,"New Push!", message);
                }
            }

            @Override
            public void onDisconnect() {

            }

            @Override
            public void onConnected() {
                Log.d("connected", "onConnected: ");
            }

            @Override
            public void onError(Exception e) {

            }
        });

        //end socket work
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        startActivity(mIntent);
        super.onDestroy();
    }
}
