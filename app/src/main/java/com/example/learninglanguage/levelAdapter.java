package com.example.learninglanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class levelAdapter extends RecyclerView.Adapter<levelAdapter.levelViewHolder> {
    private Context context;
    private List<uploadLevel> levelList;
    private List<String> idList;
    RelativeLayout layout;
    public levelAdapter(Context context, List<uploadLevel> levelList,List<String> idList) {
        this.context = context;
        this.levelList = levelList;
        this.idList=idList;
    }



    @NonNull
    @Override
    public levelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_levels, viewGroup, false);
        return new levelViewHolder(view);

    }


    public void onBindViewHolder(@NonNull levelViewHolder holder, final int position) {
        final uploadLevel uplevel = levelList.get(position);
        final String id = idList.get(position);
        holder.levelName.setText(uplevel.getLevelName());

        holder.levelName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(uplevel);
                if(position==0) {
                    Intent intent = new Intent(context, alphaLesson1.class);
                    context.startActivity(intent);
                }
                else if(position==1) {
                    Intent intent = new Intent(context, alphaLesson2.class);
                    context.startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(context, AdvanceLevel.class);
                    context.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(context, nothingToDisplay.class);
                    context.startActivity(intent);
                }
            }
        });
        }

            @Override
            public int getItemCount() {
                return levelList.size();
            }

            public class levelViewHolder extends RecyclerView.ViewHolder {
                Button levelName;


                public levelViewHolder(@NonNull View itemView) {
                    super(itemView);
                    context = itemView.getContext();
                    levelName = itemView.findViewById(R.id.lname);
                    layout = itemView.findViewById(R.id.layout1);

                }


            }


}