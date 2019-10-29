package com.example.okhttpexample;

import android.app.Application;
import android.content.Intent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Let's start services
        Intent i=new Intent(this, BackgroundService.class);
        startService(i);
    }
}

