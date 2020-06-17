package com.example.ex03_listview_addmodifydelete;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    ListView listView;
    Button btnAdd,btnModify, btnDelete;
    ArrayList<String> arrayList = getArrayListData();
    //리스트뷰에 각 항목을 표시할 뷰와 데이터를 제공할 ArrayAdapter 객체 생성
    //ArrayAdapter(Context context, int resource, List<T> objects)
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                arrayList
        );

        // ListView에 ArrayAdapter 연결
        listView.setAdapter(adapter);

        // ListView의 Item을 클릭하면 발생하는 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // 항목을 클릭하면 호출되는 메소드
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position : 사용자가 클릭한 항목의 index 번호
                textView.setText(arrayList.get(position));
            }
        });


        //ListView가 라디오 단추 레이아웃을 사용한다고 설정
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //adapter를 listView에 연결한다
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }
    //리스트 뷰에 들어갈 데이터 생성
    private ArrayList<String> getArrayListData() {
        ArrayList<String>arrayList = new ArrayList<String>();
        for(int i=0; i<5; i++){
            arrayList.add("리스트 아이템"+(i+1));
        }
        return arrayList;
    }

    @Override
    public void onClick(View view) {
        final int checkedItemPosition = listView.getCheckedItemPosition();//체크된 아이템 번호 가져오기
        switch (view.getId()){
            case R.id.btnAdd:
                int count = adapter.getCount();
                arrayList.add("리스트 아이템"+(count+1));
                break;
            case R.id.btnModify:
                final EditText editText = new EditText(getApplicationContext());//대화상자에 추가할 EditText
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("리스트뷰의 아이템 수정")
                        .setMessage("선택된 데이터:"+ arrayList.get(checkedItemPosition))
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setView(editText)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrayList.set(checkedItemPosition, editText.getText().toString());
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                break;
            case R.id.btnDelete:
                arrayList.remove(checkedItemPosition);
                break;
        }
        adapter.notifyDataSetChanged();
    }

}
