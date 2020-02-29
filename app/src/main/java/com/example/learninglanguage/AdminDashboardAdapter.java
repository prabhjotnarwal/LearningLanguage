package com.example.learninglanguage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminDashboardAdapter extends BaseAdapter {

    Context context;
    String dashboardList[];
    int pics[];
    LayoutInflater inflter;

    public AdminDashboardAdapter(Context context, String[] dashboardList,int[] pics) {
        this.context = context;
        this.dashboardList = dashboardList;
        this.pics = pics;
        inflter = (LayoutInflater.from(context));

    }
    @Override
    public int getCount() {
        return dashboardList.length;
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
        view = inflter.inflate(R.layout.dashboard_layout, null);
        TextView options = (TextView) view.findViewById(R.id.options);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        options.setText(dashboardList[i]);
        icon.setImageResource(pics[i]);
        return view;
    }

}

