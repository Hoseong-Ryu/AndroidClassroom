package com.example.ex04_excercise10_16;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Intent inIntent = getIntent();
        final int hap = inIntent.getIntExtra("Num1",0)
                + inIntent.getIntExtra("Num2",0);

        Log.d("aaa", String.valueOf(hap));

        findViewById(R.id.btnReturn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Hap", hap);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }


}
