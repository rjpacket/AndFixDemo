package com.taovo.rjp.andfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvMsg = (TextView) findViewById(R.id.tv_msg);
        tvMsg.setText("Heelo word!");
    }
}
