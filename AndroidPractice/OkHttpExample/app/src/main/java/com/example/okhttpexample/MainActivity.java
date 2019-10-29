package com.example.okhttpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context mContext=this;
    EditText mUsername, mChannel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername=findViewById(R.id.device);
        mChannel=findViewById(R.id.android);

        Button mButton=findViewById(R.id.connect);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectToScoket();
            }
        });
    }

    private void connectToScoket() {
        String username=mUsername.getText().toString();
        String channel=mChannel.getText().toString();
        if(!username.isEmpty() && !channel.isEmpty()){
            //Connect to socket

            SocketClass.getInstance().addUserToChannel(username,channel);

        }else{
            Toast.makeText(mContext,"enter above field",Toast.LENGTH_SHORT).show();
        }
    }
}
