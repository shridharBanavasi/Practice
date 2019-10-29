package example.devtips.senddatatoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMessage;
    private Button btnSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMessage = (EditText) findViewById(R.id.et_message);
        btnSendData = (Button) findViewById(R.id.btn_send_data);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!TextUtils.isEmpty(etMessage.getText().toString().trim())){

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("message", etMessage.getText().toString().trim());
                    startActivity(intent);

                } else {

                    Toast.makeText(MainActivity.this, R.string.fill_with_message, Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
