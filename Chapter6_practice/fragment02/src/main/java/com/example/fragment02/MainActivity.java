package com.example.fragment02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener


 {
    //참조 변수 생성
    Button btn1,btn2;
    LinearLayout linearLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.showFragment01);
        btn2 = findViewById(R.id.showFragment02);
        linearLayout = findViewById(R.id.linearLayout_container);

        fragmentManager = getSupportFragmentManager(); // 이 Activity와 관련된 Fragment와 상호작용하기 위한 FragmentManager 반환
        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.showFragment01:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linearLayout_container,fragmentOne);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            break;
            case R.id.showFragment02:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linearLayout_container,fragmentTwo);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }
    }
}
