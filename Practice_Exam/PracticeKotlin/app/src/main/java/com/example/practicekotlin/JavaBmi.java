package com.example.practicekotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JavaBmi extends AppCompatActivity {
    EditText height_xml ;
    EditText weight_xml ;
    Button resultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_bmi);
         height_xml = findViewById(R.id.height);
        weight_xml = findViewById(R.id.weight);
        resultButton = findViewById(R.id.btn);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double weight = Double.parseDouble(weight_xml.getText().toString());
                Double heigth = Double.parseDouble(height_xml.getText().toString());

                //val result = weight / (height/100).pow(2.0)
                Double result = weight / Math.pow(heigth/100,2);
                Toast.makeText(getApplicationContext(),"BMI: "+result.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
