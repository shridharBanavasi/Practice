package example.devtips.senddatatoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView textMessage;

    private String intentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        try {
            intentMessage = getIntent().getStringExtra("message");
        } catch (Exception e){
            e.printStackTrace();
        }

        textMessage = (TextView) findViewById(R.id.text_message);

        textMessage.setText(intentMessage);

    }
}
