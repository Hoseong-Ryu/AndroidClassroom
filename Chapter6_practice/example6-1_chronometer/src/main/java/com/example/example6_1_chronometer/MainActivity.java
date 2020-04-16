package com.example.example6_1_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Chronometer chronometer =findViewById(R.id.chronometer);
        btn1 = findViewById(R.id.buttonstart);
        btn2 = findViewById(R.id.buttonstop);
        btn3 = findViewById(R.id.buttonreset);

        btn1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                chronometer.start();
            }
        });
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                chronometer.stop();
            }
        });
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
            }
        });

    }
}
