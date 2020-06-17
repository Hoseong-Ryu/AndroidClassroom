package com.example.ex_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//    Button send;
//    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //region
//        editText=findViewById(R.id.editText);
//        send = findViewById(R.id.send);
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String str;
//                Intent intent;
//                str = editText.getText().toString();
//                intent = new Intent(getApplicationContext(), second.class);
//                intent.putExtra("str",str);
//                startActivity(intent);
//            }
//        });
        //endregion
    }
}
