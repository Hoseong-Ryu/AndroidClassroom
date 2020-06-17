package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    RadioButton rd1,rd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        String str = intent.getExtras().getString("str");
        textView.setText(str);

    }
}
