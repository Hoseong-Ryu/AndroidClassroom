package com.example.ex07_listview_customadpter02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<ItemVO> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<ItemVO> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }
    //리스트뷰의 아이템 개수 반환
    @Override
    public int getCount() {
        return dataList.size();
    }
    //리스트뷰의 아이템 반환
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    //화면에 보여지는 리스트뷰의 아이템 표시를 위한 뷰 반환
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //재사용 가능한 뷰가 없으면 새로 생성
        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource,null); // R.layout.row xml을 view 객체로 생성하는 과정

        }
        //convertview의 각 구성요소 View들을 참조변수에 연결
        ImageView imageViewIcon = view.findViewById(R.id.imageView);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);
        TextView textViewContent = view.findViewById(R.id.textViewContent);
        ImageView imageViewIcon2 = view.findViewById(R.id.imageViewIcon2);
        //imageView Icon 세팅(type에 따라 doc,img,file) 아이콘 세팅
        switch (dataList.get(i).getTypeStr()){
            case "doc":
                imageViewIcon.setImageResource(R.drawable.ic_type_doc);
                break;
            case "img":
                imageViewIcon.setImageResource(R.drawable.ic_type_image);
                break;
            case  "file":
                imageViewIcon.setImageResource(R.drawable.ic_type_file);
                break;
        }
        textViewTitle.setText(dataList.get(i).getTitleStr());
        textViewContent.setText(dataList.get(i).getContentStr());
        imageViewIcon2.setImageResource(R.drawable.ic_menu);

        return view;
    }
}
