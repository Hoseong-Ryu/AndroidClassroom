package com.example.prc2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btnAdd, btnModify, btnDel;
    ListView listView;
    int selNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        btnAdd = findViewById(R.id.btnadd);
        btnModify=findViewById(R.id.btnmodify);
        btnDel = findViewById(R.id.btndel);
        listView = findViewById(R.id.listView);

        final ArrayList<String> item = new ArrayList<>();
        item.add("리스트 데이터1"); item.add("리스트 데이터2");
        item.add("리스트 데이터3"); item.add("리스트 데이터4");
        item.add("리스트 데이터5");

            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,item);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selNum = i;
                textView.setText(item.get(i));
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.add("리스트 데이터" + (item.size()+1));
                adapter.notifyDataSetChanged();
            }
        });
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("리스트 아이템 수정")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setMessage("현재 데이터:"+ item.get(selNum));
                final EditText editText = new EditText(getApplicationContext());
                dig.setView(editText);
                dig.setNegativeButton("취소",null);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        item.set(selNum,editText.getText().toString());
                        adapter.notifyDataSetChanged();
                    }
                });
                dig.show();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.remove(selNum);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
