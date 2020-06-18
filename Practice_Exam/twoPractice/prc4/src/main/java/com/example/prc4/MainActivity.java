package com.example.prc4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnDel, btnModify;
    ListView listView;
    TextView textView;
    int selnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnadd);
        btnDel = findViewById(R.id.btndel);
        btnModify = findViewById(R.id.btnmodify);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        final ArrayList<String> item = new ArrayList<>();
        item.add("리스트 데이터 1");
        item.add("리스트 데이터 2");
        item.add("리스트 데이터 3");
        item.add("리스트 데이터 4");
        item.add("리스트 데이터 5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,item);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selnum = i;
                textView.setText(item.get(i));
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.add("리스트 데이터"+(item.size()+1));
            }
        });
    }
}
