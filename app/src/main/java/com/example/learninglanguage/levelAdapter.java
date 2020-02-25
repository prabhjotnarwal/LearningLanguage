package com.example.learninglanguage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learninglanguage.admin.UpdateActivity;
import com.google.gson.Gson;

import java.util.List;

public class levelAdapter extends RecyclerView.Adapter<levelViewHolder>{
    private Context context;
    private List<uploadLevel> levelList;

    public levelAdapter(Context context, List<uploadLevel> levelList) {
        this.context = context;
        this.levelList = levelList;

    }


    @NonNull
    @Override
    public levelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_levels,viewGroup,false);
        return new levelViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull levelViewHolder holder, int position) {
        final uploadLevel uplevel = levelList.get(position);
        holder.levelName.setText(uplevel.getLevelName());
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }
}
