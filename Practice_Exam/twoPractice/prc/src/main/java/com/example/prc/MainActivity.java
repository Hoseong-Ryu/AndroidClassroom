package com.example.prc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
    int selnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnadd);
        btnDel = findViewById(R.id.btndel);
        btnModify = findViewById(R.id.btnmodify);
        textView = findViewById(R.id.textView);

        final ArrayList<String> item = new ArrayList<>();
        item.add("리스트 데이터1");
        item.add("리스트 데이터2");
        item.add("리스트 데이터3");
        item.add("리스트 데이터4");
        item.add("리스트 데이터5");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,item);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.add("리스트 데이터" + (item.size()+1));
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selnum = i;
                textView.setText(item.get(i));
            }
        });
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("리스트 아이템 수정")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setMessage(item.get(selnum));
                final EditText ed = new EditText(getApplicationContext());
                dig.setView(ed)
                        .setNegativeButton("취소", null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                item.set(selnum, ed.getText().toString());
                                adapter.notifyDataSetChanged();
                            }
                        });
                dig.show();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.remove(selnum);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
