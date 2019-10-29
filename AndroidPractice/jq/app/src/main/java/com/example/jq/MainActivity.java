package com.example.jq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> binName= new ArrayList<>();
    ArrayList<String> binLocation= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get_json();
    }

    public void get_json(){
        String json;
        try {
            InputStream is=getAssets().open("cbin.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();

            json=new String(buffer,"UTF-8");
            JSONArray jsonArray= new JSONArray(json);

            for(int i =0; i<jsonArray.length();i++){
                JSONObject obj=jsonArray.getJSONObject(i);
                JSONObject currDevice=obj.getJSONObject("currDevice");
                binName.add(currDevice.getString("name"));
                binLocation.add(currDevice.getString("location"));
                JSONObject dem=obj.getJSONObject("dimension");
                Toast .makeText(getApplicationContext(),binName.toString()+binLocation.toString(),Toast.LENGTH_LONG).show();
                //Toast .makeText(getApplicationContext(),binName.toString(),Toast.LENGTH_LONG).show();
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
