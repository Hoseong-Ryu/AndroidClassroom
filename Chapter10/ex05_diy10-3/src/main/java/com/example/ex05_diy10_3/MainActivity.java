package com.example.ex05_diy10_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1,editTextNum2;
    Button btnCalculate;
    RadioButton radBtn1,radBtn2,radBtn3,radBtn4;
    int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNum1 = findViewById(R.id.editTextNum1);
        editTextNum2 = findViewById(R.id.editTextNum2);
        btnCalculate = findViewById(R.id.BtnCalculate);
        radBtn1 = findViewById(R.id.radBtn1);
        radBtn2 = findViewById(R.id.radBtn2);
        radBtn3 = findViewById(R.id.radBtn3);
        radBtn4 = findViewById(R.id.radBtn4);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radBtn1){
                    Toast.makeText(getApplicationContext(),"더하기",Toast.LENGTH_SHORT).show();
                    data = 1;
                } else if(i == R.id.radBtn2){
                    Toast.makeText(getApplicationContext(),"빼기",Toast.LENGTH_SHORT).show();
                    data = 2;
                } else if (i == R.id.radBtn3) {
                    Toast.makeText(getApplicationContext(),"곱하기",Toast.LENGTH_SHORT).show();
                    data= 3;
                } else if (i == R.id.radBtn4){
                    Toast.makeText(getApplicationContext(),"나누기",Toast.LENGTH_SHORT).show();
                    data = 4;
                }
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),secondActivity.class);
                intent.putExtra("Num1", Integer.parseInt(editTextNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(editTextNum2.getText().toString()));
                Toast.makeText(getApplicationContext(),"결과:"+data,Toast.LENGTH_SHORT).show();
                intent.putExtra("radBtn", data);
                startActivityForResult(intent, 0);
            }
        });
    }

    //startActivityForResult()의 응답이 돌아오면 자동 실행되는 메소드

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==0&&resultCode==RESULT_OK){
            int dap = data.getIntExtra("dap",0);
            Toast.makeText(getApplicationContext(),"결과:"+dap,Toast.LENGTH_SHORT).show();

        }
    }
}
