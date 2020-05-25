package com.example.ex01_practice10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton rd1, rd2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rd1 = findViewById(R.id.act2);
        rd2 = findViewById(R.id.act3);
        btn = findViewById(R.id.move_act);
        rd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rd2.isChecked()){
                    rd2.setChecked(false);
                }
            }
        });
        rd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rd1.isChecked()){
                    rd1.setChecked(false);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(rd1.isChecked()){
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                } else if (rd2.isChecked()){
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"액티비티를 골라주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
