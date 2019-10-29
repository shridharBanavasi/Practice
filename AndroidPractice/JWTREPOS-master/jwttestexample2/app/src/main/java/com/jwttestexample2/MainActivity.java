package com.jwttestexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jwttestexample2.model.JWTToken;
import com.jwttestexample2.remote.APIService;
import com.jwttestexample2.remote.RetroClass;
import com.jwttestexample2.tokenmanager.TokenManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private EditText username,userpass;
    private Button senddata;
    private TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText)findViewById(R.id.username);
        userpass = (EditText)findViewById(R.id.userpass);
        senddata = (Button)findViewById(R.id.senddata);

        tokenManager = new TokenManager(getApplicationContext());

        senddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String usernameval=username.getText().toString();
                final String userpassval = userpass.getText().toString();


                final APIService apiService = RetroClass.getAPIService();


                Call<JWTToken> jwtTokenCall = apiService.userlogin(usernameval,userpassval);
                jwtTokenCall.enqueue(new Callback<JWTToken>() {
                    @Override
                    public void onResponse(Call<JWTToken> call, Response<JWTToken> response) {

                        JWTToken jwtToken = response.body();
                        tokenManager.createLoginSession(usernameval,jwtToken.getToken().toString());


                        Call<String> calluser = apiService.getUser(jwtToken.getToken().toString());
                        calluser.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                showToast(""+response.body().toString());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                showToast("inner"+t.getMessage());

                            }
                        });




                        showToast(""+jwtToken.getToken().toString());

                    }

                    @Override
                    public void onFailure(Call<JWTToken> call, Throwable t) {

                        showToast(""+t.getMessage());
                    }
                });






            }
        });



    }

    void showToast(String msg)
    {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}
