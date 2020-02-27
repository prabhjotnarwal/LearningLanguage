package com.example.learninglanguage.admin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.learninglanguage.R;
import com.google.gson.Gson;

import java.util.List;


   class learningListAdapter extends RecyclerView.Adapter<learningListviewHolder>{
    private Context context;
    private List<learning> learningList;
    private List<String> idList;

    public learningListAdapter(Context context, List<learning> learningList, List<String> idList) {
        this.context = context;
        this.learningList = learningList;
        this.idList = idList;
    }

    @NonNull
    @Override
    public learningListviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new learningListviewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_learning, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull learningListviewHolder holder, int position) {
        final learning learning = learningList.get(position);
        final String id = idList.get(position);

        Glide.with(context)
                .load(learning.getLearningImagePath())
                .into(holder.learningImage);
        holder.name.setText(learning.getLearningName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(learning);
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("learning", jsonString);
                intent.putExtra("key", id);
                intent.putExtra("name",learning.getLearningName());
                intent.putExtra("image",learning.getLearningImagePath());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return learningList.size();
    }
}
