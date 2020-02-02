package com.example.learninglanguage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class categoryAdapter extends BaseAdapter {


    Context context;
    String categoryList[];
    int pics[];
    LayoutInflater inflter;
    public categoryAdapter(Context context, String[] categoryList, int[] pics) {
        this.context = context;
        this.categoryList = categoryList;
        this.pics = pics;
        inflter = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return categoryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.category_layout, null);
        TextView country = (TextView)
                view.findViewById(R.id.text);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        country.setText(categoryList[i]);
        icon.setImageResource(pics[i]);
        return view;
    }
}
