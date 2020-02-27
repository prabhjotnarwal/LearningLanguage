package com.example.learninglanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class levelAdapter extends RecyclerView.Adapter<levelAdapter.levelViewHolder> {
    private Context context;
    private List<uploadLevel> levelList;

    public levelAdapter(Context context, List<uploadLevel> levelList) {
        this.context = context;
        this.levelList = levelList;

    }


    @NonNull
    @Override
    public levelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_levels, viewGroup, false);
        return new levelViewHolder(view);

    }


    public void onBindViewHolder(@NonNull levelViewHolder holder, int position) {
        final uploadLevel uplevel = levelList.get(position);
        holder.levelName.setText(uplevel.getLevelName());

    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }

    public class levelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button levelName;


        public levelViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            levelName = itemView.findViewById(R.id.lname);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
    public interface OnItemClickListener {
        public void onClick(View view, int position);
    }

}