package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    RadioButton rd1,rd2;
    RadioGroup Rg;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView2);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        Rg = findViewById(R.id.Rg);
        btn2 = findViewById(R.id.btn2);
        final Intent intent = getIntent();
        String s = intent.getStringExtra("str");
        textView.setText(s);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Rg.getCheckedRadioButtonId()){
                    case R.id.rd1:
                        intent.putExtra("check",1);
                        break;
                    case R.id.rd2:
                        intent.putExtra("check",2);
                        break;
                }
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}
