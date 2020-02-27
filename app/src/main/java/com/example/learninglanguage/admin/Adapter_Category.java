package com.example.learninglanguage.admin;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.learninglanguage.R;

import com.google.gson.Gson;

import java.util.List;
public class Adapter_Category extends RecyclerView.Adapter<Adapter_Category.View_category> {
        private Context context;
        private List<uploadCategory> categoryList;
        private List<String> idList;
        RelativeLayout layout;
        public Adapter_Category(Context context, List<uploadCategory> categoryList,List<String> idList) {
            this.context = context;
            this.categoryList = categoryList;
            this.idList=idList;
        }



        @NonNull
        @Override
        public View_category onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.category_layout, viewGroup, false);
            return new View_category(view);

        }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Category.View_category holder, int position) {
        final uploadCategory uploadCategory = categoryList.get(position);
        final String id = idList.get(position);
        holder.CategoryName.setText(uploadCategory.getCategoryName());

        holder.CategoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String jsonString = gson.toJson(uploadCategory);
                if(position==0) {
                    Intent intent = new Intent(context, View_category.class);
                    context.startActivity(intent);
                }
                else if(position==1) {
                    Intent intent = new Intent(context, View_category.class);
                    context.startActivity(intent);
                }
                else if(position==2) {
                    Intent intent = new Intent(context, View_category.class);
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
            return categoryList.size();
        }

    public class View_category extends RecyclerView.ViewHolder {
        TextView CategoryName,layout;


        public View_category(@NonNull View itemView) {
            super(itemView);
            CategoryName = itemView.findViewById(R.id.Cname);
            layout = itemView.findViewById(R.id.Cname);

        }


    }
}
