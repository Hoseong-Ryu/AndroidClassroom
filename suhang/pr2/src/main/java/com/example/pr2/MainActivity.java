package com.example.pr2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        editText = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",str);
                startActivityForResult(intent,0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int check = data.getIntExtra("check",0);
        if (check == 1){
            Uri uri = Uri.parse("tel:0629496800");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        }
        if (check == 2){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
            startActivity(intent);
        }
    }
}
