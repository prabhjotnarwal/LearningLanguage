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
    private List<String> idList;
    public levelAdapter(Context context, List<uploadLevel> levelList, List<String> idList) {
        this.context = context;
        this.levelList = levelList;
        this.idList = idList;
    }

    @NonNull
    @Override
    public levelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new levelViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_levels, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull levelViewHolder holder, int position) {
        final uploadLevel uplevel = levelList.get(position);
        final String id = idList.get(position);


        holder.levelName.setText(uplevel.getLevelName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(uplevel);
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("level", jsonString);
                intent.putExtra("key", id);
                intent.putExtra("levelName",uplevel.getLevelName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }
}
