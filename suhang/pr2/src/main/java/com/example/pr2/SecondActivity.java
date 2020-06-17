package com.example.pr2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    RadioButton rd1, rd2;
    TextView textView;
    RadioGroup Rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn = findViewById(R.id.button2);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        textView = findViewById(R.id.textView3);
        Rg = findViewById(R.id.Rg);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        textView.setText(str);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                switch (Rg.getCheckedRadioButtonId()){
                    case R.id.rd1:
                        intent.putExtra("check",1);

                        break;
                    case  R.id.rd2:
                        intent.putExtra("check",2);

                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
