package com.example.exercise01_optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                textView.setText("메뉴1이 선택됨");
                break;
            case R.id.itme2:
                textView.setText("메뉴2이 선택됨");
                break;
            case R.id.subItem1:
                textView.setText("서브아이템 1이 선택됨");
                break;
            case R.id.subItem2:
                textView.setText("서브 아이템2이 선택됨");
                break;
            case Menu.FIRST:
                textView.setText("자바코드로 추가한 아이템1이 선택됨");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"Java 코드에서 추가한 메뉴");

        return true;
    }
}
