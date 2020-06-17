package com.example.suhang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button plus,minus,mul,div;
    EditText ed1, ed2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        textView = findViewById(R.id.textView3);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dap;
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                dap=Double.parseDouble(s1)+Double.parseDouble(s2);
                textView.setText(Double.toString(dap));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dap;
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                dap=Double.parseDouble(s1)-Double.parseDouble(s2);
                textView.setText(Double.toString(dap));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dap;
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                dap=Double.parseDouble(s1)*Double.parseDouble(s2);
                textView.setText(Double.toString(dap));
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dap;
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                dap=Double.parseDouble(s1)/Double.parseDouble(s2);
                textView.setText(Double.toString(dap));
            }
        });
    }
}
