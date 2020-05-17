package com.example.exercise05_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDialog1,btnDialog2,btnDialog3,btnDialog4,btnDialog5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog1 = findViewById(R.id.btnDialog1);
        btnDialog2 = findViewById(R.id.btnDialog2);
        btnDialog3 = findViewById(R.id.btnDialog3);
        btnDialog4 = findViewById(R.id.btnDialog4);
        btnDialog5 = findViewById(R.id.btnDialog5);

        btnDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("제목입니다");
                builder.setMessage("내용입니다");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.show();
            }
        });

        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("제목입니다")
                        .setMessage("내용입니다")
                        .setIcon(R.mipmap.ic_launcher)
                        .setNeutralButton("Neutral",null)
                        .setNegativeButton("Negative",null)
                        .setPositiveButton("Positive",null)
                        .show();
            }
        });
        btnDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] versionArray = new String[]{"누가","오레오","파이"};

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 버전은?")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setItems(versionArray,null)
                        .setPositiveButton("닫기",null)
                        .show();
            }
        });
        final DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_NEUTRAL:
                        Toast.makeText(MainActivity.this,"Button_NEUTRAL",Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(MainActivity.this,"Button_NEGATIVE",Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(MainActivity.this,"Button_POSITIVE",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        };
    }
}
