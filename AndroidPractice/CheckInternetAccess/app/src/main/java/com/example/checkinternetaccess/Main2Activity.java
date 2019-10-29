package com.example.checkinternetaccess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements NetworkStateReceiver.NetworkStateReceiverListener {
    private NetworkStateReceiver networkStateReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener(this);
        this.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        networkStateReceiver.removeListener(this);
        this.unregisterReceiver(networkStateReceiver);
    }

    @Override
    public void networkAvailable() {
        Log.d("tommydevall", "I'm in, baby!");
        /* TODO: Your connection-oriented stuff here */
        Toast.makeText(Main2Activity.this,"ghed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void networkUnavailable() {
        Log.d("tommydevall", "I'm dancing with myself");
        /* TODO: Your disconnection-oriented stuff here */
    }
}
