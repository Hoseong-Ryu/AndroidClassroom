package com.example.practice_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button plus,minus,mul,div;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2= findViewById(R.id.ed2) ;
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        textView = findViewById(R.id.textView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dap;
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                dap = Integer.parseInt(s1)+
                        Integer.parseInt(s2);
                textView.setText(Integer.toString(dap));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                int dap;
                dap = Integer.parseInt(s1)-
                        Integer.parseInt(s2);
                textView.setText(Integer.toString(dap));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                int dap;
                dap = Integer.parseInt(s1)*
                        Integer.parseInt(s2);
                textView.setText(Integer.toString(dap));
            }

        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();
                double dap;
                dap = Double.parseDouble(s1)/
                        Double.parseDouble(s2);
                textView.setText(Double.toString(dap));
            }
        });
    }
}
