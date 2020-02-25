package com.example.learninglanguage;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class levelViewHolder extends RecyclerView.ViewHolder  {
    Button levelName;


    public levelViewHolder(@NonNull View itemView) {
        super(itemView);
        levelName = itemView.findViewById(R.id.lname);

    }
}
