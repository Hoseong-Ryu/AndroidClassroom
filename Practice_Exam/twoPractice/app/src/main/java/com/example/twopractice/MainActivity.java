package com.example.twopractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView selectedListItem;
    ListView listView;
    Button addBtn,editBtn,delBtn;
    int selNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedListItem = findViewById(R.id.selectedListItem);
        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);
        editBtn = findViewById(R.id.editBtn);
        delBtn = findViewById(R.id.delBtn);

        //요구사항 1. 초기값은 리스트데이터
        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1"); dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3");dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");

        //리스트뷰의 초기 출럭(어댑터 생성 및 Listview와 dataset간 연결)
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,dataSet);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);


        //요구사항중 1. 리스트데이터를 추가한다.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSet.add("리스트 데이터" + (dataSet.size()+1));
                adapter.notifyDataSetChanged(); // 이 메소드가 존재하지 않으면 갱신 x
            }
        });
        //요구사항 2. 선택된 리스트 아이템을 수정
        //무엇을 선택했는지를 판단할 수가 있어야함
        //선택된 위치의 내용을 수정한다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                selNum = position;
                selectedListItem.setText(dataSet.get(position));
            }
        });
        //editbtn을 눌렀을 때 수정할수 있도록 주요한 코드가 이곳에 구현
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("리스트 아이템 수정");
                dig.setMessage(dataSet.get(selNum));
                dig.setIcon(R.mipmap.ic_launcher_round);
                //에디트 텍스트를 새로 포함시키기
                final EditText ed = new EditText(getApplicationContext());
                dig.setView(ed);
                //
                dig.setNegativeButton("취소",null);
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //1. EditText(ed) 에게서 내용물을 가져와 data 갱신
                        dataSet.set(selNum,ed.getText().toString());
                        selectedListItem.setText(dataSet.get(selNum));
                        adapter.notifyDataSetChanged();
                    }
                });
                dig.show();
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSet.remove(selNum);
                adapter.notifyDataSetChanged();
                selectedListItem.setText(dataSet.get(selNum));
            }
        });
    }
}
