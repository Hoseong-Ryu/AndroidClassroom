package com.example.ex06_listview_customadapter01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        listView = findViewById(R.id.listView);

        // 리스트뷰에 출력할 데이터
        ArrayList<String> dataList = getArrayListData(5);


        // 리스트뷰에 데이터와 항목별 뷰를 설정하는 어댑터 객체 생성
        CustomAdapter adapter = new CustomAdapter(this, R.layout.row, dataList);

        // 리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);

    }

    // 리스트뷰의 문자열 데이터 생성 메소드
    private ArrayList<String> getArrayListData(int Count) {
        ArrayList<String> Temp = new ArrayList<String>();

        for(int i = 1; i <= Count; i++) {
            Temp.add("리스트 아이템" + i );
        }
        return Temp;
    }
}