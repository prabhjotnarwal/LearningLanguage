package com.example.learninglanguage.admin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.learninglanguage.R;
import com.example.learninglanguage.categoryAdapter;
import com.example.learninglanguage.levelAdapter;
import com.example.learninglanguage.uploadLevel;
import com.example.learninglanguage.viewLevels;
import com.google.gson.Gson;

import java.util.List;


   class categoryListAdapter extends RecyclerView.Adapter<categoryListAdapter.categoryViewHolder>{
    private Context context;
       RelativeLayout layout;
    private List<uploadCategory> learningList;
    private List<String> idList;

    public categoryListAdapter(Context context, List<uploadCategory> learningList, List<String> idList) {
        this.context = context;
        this.learningList = learningList;
        this.idList = idList;
    }


       @NonNull
       @Override
       public categoryListAdapter.categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(context).inflate(R.layout.layout1_category, parent, false);
           return new categoryListAdapter.categoryViewHolder(view);
       }


       @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {



        final uploadCategory learning = learningList.get(position);
        final String id = idList.get(position);
        holder.cname.setText(learning.getCategoryName());
        holder.cname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(learning);
                Intent intent = new Intent(context, viewLevels.class);
//                intent.putExtra("learning", jsonString);
//                intent.putExtra("key", id);
//                intent.putExtra("name",learning.getCategoryName());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return learningList.size();
    }

       public class categoryViewHolder extends RecyclerView.ViewHolder {
           Button cname;


           public categoryViewHolder(@NonNull View itemView) {
               super(itemView);
               context = itemView.getContext();
               cname = itemView.findViewById(R.id.caName);
               layout = itemView.findViewById(R.id.layout3);

           }


       }
}
