package com.example.a7pr.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a7pr.Data.Models.Exhibit;
import com.example.a7pr.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
        public List<Exhibit> listData;
        Context context;

    public CustomAdapter(Context context,List<Exhibit> listData) {
        this.listData = listData;
        this.context = context;
    }

    @Override
        public int getCount() {return listData.size();}

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View MyView, ViewGroup parent) {
            View view = View.inflate(context, R.layout.customlayout,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textView2);
            imageView.setImageResource(listData.get(position).getImgID());
            textView.setText(listData.get(position).getName());
            return view;
        }
}

