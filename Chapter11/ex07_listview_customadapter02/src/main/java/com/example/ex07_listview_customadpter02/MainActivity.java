package com.example.ex07_listview_customadpter02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    Button btnAdd;


    ArrayList<ItemVO>dataList= new ArrayList<ItemVO>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        //리스트뷰에 표시할 초기 데이터
        dataList.add(new ItemVO("doc","Document1","Sample Data"));
        dataList.add(new ItemVO("img","Image1","Sample Data"));
        dataList.add(new ItemVO("file","File1","Sample Data"));
        // customAdapter 객체 생성
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.row,dataList);
        //리스트뷰에 어댑터 연결
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(dataList.get(i).getTitleStr());
            }
        });
        //리스튜에 아이템 추가
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                final View myView = inflater.inflate(R.layout.alertdialog_add_item,null);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("리스트아이템 추가")
                        .setMessage("문서종류 선택")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(myView)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String type =null ,title,content;

                                //라디오 버튼과 EditText에 입력한 데이터 가져오기
                                int checkid = ((RadioGroup)myView.findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
                                switch (checkid){
                                    case R.id.rbDoc:
                                        type = "doc";
                                        break;
                                    case R.id.rbFile:
                                        type = "file";
                                        break;
                                    case R.id.rbImg:
                                        type = "Img";
                                        break;
                                }
                                title = ((EditText)findViewById(R.id.editTextTitle)).getText().toString();
                                content = ((EditText)findViewById(R.id.editTextContent)).getText().toString();
                                dataList.add(new ItemVO(type, title, content));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
            }
        });
    }
}
